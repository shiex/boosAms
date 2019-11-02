package com.xbb.web.servlet;

import com.xbb.constant.WebConstant;
import com.xbb.utils.ValidateCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shiex-薛
 * @title: validateCodeServlet
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\26 002621:45
 */
@WebServlet("/validateCode")
public class ValidateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");

        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();
        ValidateCodeUtils vCode = new ValidateCodeUtils(120,40,5,100);
        session.setAttribute(WebConstant.SESSEION_KEY_CODE, vCode.getCode());

        vCode.write(response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
