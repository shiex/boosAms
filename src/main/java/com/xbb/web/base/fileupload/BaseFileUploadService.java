package com.xbb.web.base.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.xbb.web.base.QueryParams;
import com.xbb.utils.WebUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

// 请在 web.xml 配置本 Servlet
public class BaseFileUploadService extends HttpServlet {
    protected HashMap<String, ConfigItem> configs = new HashMap<String, ConfigItem>();

    @Override
    public void init() throws ServletException {
        // 从xml配置文件中读取配置
        try {
            loadConfig();
        } catch (Exception e) {
            throw new Error("af-service.xml 加载失败! " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        JSONObject jresp = new JSONObject();
        boolean printLog = false;

        try {
            // 从URL中解析服务的名字
            // servletPath: "/.../hello.upload"
            String servletPath = request.getServletPath();
            int p1 = servletPath.lastIndexOf('/');
            int p2 = servletPath.lastIndexOf('.');
            String serviceName = servletPath.substring(p1 + 1, p2);

            // 创建服务类的对象, 处理该请求
            ConfigItem cfg = configs.get(serviceName);
            if (cfg == null)
                throw new Exception("上传服务: " + serviceName + "在af-service.xml里尚未配置!");

            AbstractFileUploadHandler instance = null;
            try {
                instance = (AbstractFileUploadHandler) cfg.clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new Exception(cfg.clazzName + "无法实例化, 请确保构造方法不带参数!");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new Exception(cfg.clazzName + "无法实例化, 请确保构造方法为public!");
            } catch (ClassCastException e) {
                e.printStackTrace();
                throw new Exception(cfg.clazzName + "必须是  AfFileUploadHandler 的子类(或子类的子类)!");
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("在创建 " + cfg.clazzName + "实例的时候出错!请检查构造方法是否有异常!");
            }

            // 读取URL里的参数
            String query = request.getQueryString();
            HashMap<String, String> queryParams = WebUtils.parseQuery(query, cfg.charset);

            // 处理请求
            instance.httpReq = request;
            instance.httpResp = response;
            instance.queryParams = new QueryParams(queryParams);
            instance.charset = cfg.charset;
            printLog = instance.enableErrorLog;

            request.setCharacterEncoding(cfg.charset);
            Object data = doUpload(request, response, instance);
            jresp.put("error", 0);
            jresp.put("reason", "OK");
            if (data != null)
                jresp.put("data", data);

        } catch (Exception e) {
            // 输出错误日志
            if (printLog)
                e.printStackTrace();
            else
                System.out.println("[FileUpload] [" + e.getClass().getName() + "] " + e.getMessage());

            // 返回结果
            String reason = e.getMessage();
            if (reason == null) reason = e.getClass().getName();
            jresp.put("error", -1);
            jresp.put("reason", reason);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.write(jresp.toString());
        out.close();
    }

    private Object doUpload(HttpServletRequest request,
                            HttpServletResponse response,
                            AbstractFileUploadHandler handler) throws Exception {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart)
            throw new Exception("请求编码必须为: multipart/form-data !");

        // ServletFileUpload ： commons包里提供的工具类
        ServletFileUpload upload = new ServletFileUpload();

        FileItemIterator iter = upload.getItemIterator(request);
        while (iter.hasNext()) {
            // 表单域
            FileItemStream item = iter.next();
            String fieldName = item.getFieldName();
            InputStream fieldStream = item.openStream();
            if (item.isFormField()) {
                String fieldValue = Streams.asString(fieldStream, handler.charset);
                handler.queryParams.put(fieldName, fieldValue);
            } else {
                // 生成唯一的文件名
                String orginalFileName = item.getName(); // 原始文件名
                OutputStream outStream = handler.uploadStarted(orginalFileName);
                if (outStream == null)
                    throw new Exception("在uploadStarted()里必须返回 OutputStream !");

                //printLog("文件上传开始:" + orginalFileName );
                long fileSize = 0; // 已上传的字节数
                try {
                    // 从请求里读取文件数据，保存到本地文件
                    fileSize = copy(fieldStream, outStream, handler);
                } catch (Exception ex) {
                    handler.uploadError(); // 出错时的善后处理
                    throw ex;
                } finally {
                    try {
                        fieldStream.close();
                    } catch (Exception e) {
                    }
                }

                //printLog("文件上传完成:" + orginalFileName + ", 大小: " + fileSize);

                return handler.uploadComplete(fileSize);
            }
        }

        // 如果请求里根本没有文件域,则提示异常（前台代码漏写了)
        throw new Exception("请求里没有文件域!");
    }

    public long copy(InputStream in,
                     OutputStream out,
                     AbstractFileUploadHandler handler) throws Exception {
        long count = 0;
        byte[] buf = new byte[8192];
        while (true) {
            int n = in.read(buf);
            if (n < 0)
                break;
            if (n == 0)
                continue;
            out.write(buf, 0, n);

            count += n;
            handler.uploadProgress(count); // handler可以作文件大小控制
        }
        return count;
    }

    /////////////////////////////////////
    // af-service.xml 中的配置项
    // <upload name="CommonFile" class="my.CommonFileUpload" />
    class ConfigItem {
        public String name;       // 服务接口名
        public String clazzName;
        public Class clazz;      // 类的实体
        public String charset = "UTF-8";
    }

    // 从 af-service.xml 中获取配置
    private void loadConfig() throws Exception {

        InputStream stream = this.getClass().getResourceAsStream(
                "/web-service.xml");
        SAXReader reader = new SAXReader();
        Document doc = reader.read(stream);
        stream.close();

        Element root = doc.getRootElement();
        List<Element> xServiceList = root.elements("upload");
        for (Element e : xServiceList) {
            ConfigItem cfg = new ConfigItem();
            cfg.name = e.attributeValue("name");
            cfg.clazzName = e.attributeValue("class");

            try {
                // 加载类的信息
                cfg.clazz = Class.forName(cfg.clazzName);

                // 检查是不是 AfFileUploadHandler 的子类
                if (cfg.clazz.isAssignableFrom(AbstractFileUploadHandler.class))
                    throw new Exception("类" + cfg.clazzName + "不是AfFileUploadHandler的子类!无法加载!");

                configs.put(cfg.name, cfg);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new Exception("类 " + cfg.clazzName + "不存在!");
            }
        }
    }
}
