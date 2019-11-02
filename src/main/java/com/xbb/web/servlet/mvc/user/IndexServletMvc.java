package com.xbb.web.servlet.mvc.user;

import com.xbb.constant.WebConstant;
import com.xbb.entity.Category;
import com.xbb.entity.User;
import com.xbb.service.CategoryService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: IndexServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 00270:01
 */
@WebServlet("/index.html")
public class IndexServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        List<Category> categoryList = categoryService.selectAllCategoryClassify();
        model.put("categoryList", categoryList);

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(WebConstant.SESSEION_KEY_USER);
        model.put("user", user);

        return "/index.ftl";
    }
}
