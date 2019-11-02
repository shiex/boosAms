package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.Category;
import com.xbb.service.CategoryService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author shiex-薛
 * @title: AdminCategoryAddServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00284:10
 */
@WebServlet("/admin/category/add")
public class AdminCategoryAddServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        if (req.getParameter("categoryId") != null){
            Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));
            CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
            Category category = categoryService.selectOneById(categoryId);
            model.put("category", category);
        }
        return "/admin_category_add.ftl";
    }
}
