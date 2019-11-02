package com.xbb.web.servlet;

import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiex-薛
 * @title: EmaliCodeServlet
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002721:25
 */
@WebServlet("/register")
public class EmaliCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        String code = req.getParameter("code");
        UserService userService = ServiceUtils.getService(UserService.class);
        User user = new User();
        user.setuId(userId);
        user.setActivationCode(code);
        userService.updateById(user);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/palin");
        resp.getWriter().write("激活成功!");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
