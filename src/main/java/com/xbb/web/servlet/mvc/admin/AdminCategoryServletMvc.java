package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.Category;
import com.xbb.service.CategoryService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminCategoryServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00283:27
 */
@WebServlet("/admin/category.html")
public class AdminCategoryServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        List<Category> categoryList = categoryService.selectAllCategoryClassify();
        model.put("categoryList", categoryList);
        return "/admin_category_list.ftl";
    }
}
