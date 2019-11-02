package com.xbb.web.servlet;

import com.xbb.constant.WebConstant;
import com.xbb.entity.User;
import sun.plugin.services.WIExplorerBrowserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shiex-薛
 * @title: LogoutServlet
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 00270:18
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(WebConstant.SESSEION_KEY_USER);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/palin");
        resp.sendRedirect("/index.html");
        resp.getWriter().write("logout");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
