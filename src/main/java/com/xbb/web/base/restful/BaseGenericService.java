package com.xbb.web.base.restful;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbb.constant.WebConstant;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;
import com.xbb.utils.WebUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseGenericService extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(BaseGenericService.class);

    protected boolean enableErrorLog = false; // 是否打印异常输出
    protected int MAX_REQUEST_SIZE = 1024 * 512; // 允许上传的JSON最大长度

    protected Map<String, ConfigItem> configs = new HashMap<>();

    @Override
    public void init() throws ServletException {
        try {
            // 从xml配置文件中读取配置
            loadConfig();
            // 初始化加载service（单例模式）
            ServiceUtils serviceUtils = new ServiceUtils();
            // 初始化上下文路径以及项目路径
            WebConstant.WEB_CONTEXT_PATH = this.getServletContext().getContextPath();
            WebConstant.WEB_PROJECT_PATH = this.getServletContext().getRealPath("/");

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 无论是 GET/POST, 均统一处理
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理请求数据
        try {
            handleRequest(request, response);
        } catch (Exception e) {
            if (enableErrorLog) e.printStackTrace();
            response.sendError(500, e.getMessage());
            return;
        }
    }

    private void handleRequest(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        // 从URL中解析API的名字
        // servletPath: "/.../hello.api"
        String servletPath = request.getServletPath();
        int p1 = servletPath.lastIndexOf('/');
        int p2 = servletPath.lastIndexOf('.');
        String apiName = servletPath.substring(p1 + 1, p2);

        // 查找相关的配置
        ConfigItem cfg = configs.get(apiName);
        if (cfg == null)
            throw new Exception("服务" + apiName + "在af-service.xml里没有配置!");

        // 创建服务类的对象, 处理该请求
        AbstractGenericApi instance = null;
        try {
            instance = (AbstractGenericApi) cfg.clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new Exception(cfg.clazzName + "无法实例化, 请确保构造方法不带参数!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new Exception(cfg.clazzName + "无法实例化, 请确保构造方法为public!");
        } catch (ClassCastException e) {
            e.printStackTrace();
            throw new Exception(cfg.clazzName + "必须是  AfGenericApi 的子类(或子类的子类)!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在创建 " + cfg.clazzName + "实例的时候出错!请检查构造方法是否有异常!");
        }

        // 读取请求数据 和 URL里的参数
        String strReq = WebUtils.readAsText(request.getInputStream(), cfg.charset, MAX_REQUEST_SIZE);
        // 默认不再提取 URL里的参数，如果需要，则由子类调用 AfFormData.parse(query, "UTF-8") 提取
//		String query = request.getQueryString(); 
//		HashMap<String,String> queryParams = AfServiceUtils.parseQuery(query, cfg.charset);

        // 读取请求数据, 转成字符串, 转成 JSON
        instance.httpReq = request;
        instance.httpResp = response;
        instance.charset = cfg.charset;
        instance.debug = cfg.debug;
        instance.config = cfg;
        String strResp = instance.execute(strReq);

        // 发送应答给客户端
        response.setCharacterEncoding(cfg.charset);
        response.setContentType("text/plain");
        //response.setHeader("Connection", "close");
        Writer writer = response.getWriter();
        writer.write(strResp);
        writer.close();
    }


    /////////////////////////////////////
    // af-service.xml 中的配置项
    public static class ConfigItem {
        public String name;       // 服务接口名
        public String clazzName;  // 类名
        public Class clazz;      // 类的实体
        public String charset = "UTF-8";
        public int debug = 0; // 默认出错时不 printStackTrace()

    }

    // 从 af-service.xml 中获取配置
    private void loadConfig() throws Exception {
        InputStream stream = this.getClass().getResourceAsStream("/web-service.xml");
        if (stream == null)
            throw new Exception("找不到 web-service.xml! 请检查 src 下是否有这个文件 !");

        // 加载XML
        SAXReader reader = new SAXReader();
        Document doc = reader.read(stream);
        stream.close();

        // 读取配置项
        Element root = doc.getRootElement();
        List<Element> xServiceList = root.elements("service");
        for (Element e : xServiceList) {
            ConfigItem cfg = new ConfigItem();
            cfg.name = e.attributeValue("name").trim();
            cfg.clazzName = e.attributeValue("class").trim();
            String debug = e.attributeValue("debug");
            if (debug != null)
                cfg.debug = Integer.valueOf(debug.trim());

            // 检查配置项是否重复
            if (configs.get(cfg.name) != null)
                throw new Exception(getServletContext().getContextPath()
                        + ": web-service.xml里的配置项重复: name=" + cfg.name
                        + ",class=" + cfg.clazzName);

            // 加载XML时，即检查 class路径是否正确
            try {
                cfg.clazz = Class.forName(cfg.clazzName);
            } catch (Exception ex) {
                throw new Exception("web-service.xml: 找不到服务 '" + cfg.name + "' 的类:" + cfg.clazzName);
            }

            configs.put(cfg.name, cfg);
        }
    }
}
