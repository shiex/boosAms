package com.xbb.web.base.mvc;

import com.xbb.web.base.exception.WebException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public abstract class AbstractSimpleMVC extends HttpServlet {

    protected Configuration frmkConfig;
    protected File appRoot;

    @Override
    public void init() throws ServletException {
        initFreeMarker();
    }

    private void initFreeMarker() {
        // 取得APP所在目录
        if (appRoot == null) {
            appRoot = new File(getServletContext().getRealPath("/"));
            try {
                frmkConfig = new Configuration(Configuration.VERSION_2_3_28);
                frmkConfig.setDirectoryForTemplateLoading(appRoot); // 设置模板根目录
                frmkConfig.setDefaultEncoding("UTF-8");
                frmkConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                frmkConfig.setLogTemplateExceptions(false);
            } catch (Exception e) {
                System.out.println("This Should Not Happen!");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 在init()中初始化; 如果忘了初始化,则在首次访问时初始化
        if (frmkConfig == null) initFreeMarker();

        // 生成 model, 并指定相应的 view
        HashMap<String, Object> model = new HashMap<>();
        String view = null;
        try {
            view = execute(req, resp, model);
        } catch (WebException e) {
            resp.sendError(e.error, e.reason);
            return;
        } catch (Exception e) {
            resp.sendError(500, e.getMessage());
            return;
        }

        // 以下为固定套路, 根据 model 和 view 作出应答
        Template tp = null;
        try {
            tp = frmkConfig.getTemplate(view);
        } catch (TemplateNotFoundException ex) {
            resp.sendError(404, "Cannot find view: " + view);
            return; // 目标HTML不存在，则直接返回404
        }

        // 处理并返回应答
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            tp.process(model, resp.getWriter()); // 输出给客户端
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500, e.getMessage());
        }
    }

    // 子类必重写这个方法: 生成数据到model, 并返回指定的view
    // 此方法必须支持线程重入！
    protected abstract String execute(HttpServletRequest req
            , HttpServletResponse resp
            , HashMap<String, Object> model) throws Exception;
}
