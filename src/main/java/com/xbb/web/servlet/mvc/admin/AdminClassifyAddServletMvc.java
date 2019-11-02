package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.Category;
import com.xbb.entity.Classify;
import com.xbb.service.CategoryService;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminClassifyAddServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00284:10
 */
@WebServlet("/admin/classify/add")
public class AdminClassifyAddServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        if (req.getParameter("classifyId") != null) {
            Integer classifyId = Integer.valueOf(req.getParameter("classifyId"));
            ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
            Classify classify = classifyService.selectOneById(classifyId);
            model.put("classify", classify);
            model.put("categoryName", req.getParameter("categoryName"));
        } else {
            CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
            List<Category> categoryList = categoryService.selectAll();
            model.put("categoryList", categoryList);
        }
        return "/admin_classify_add.ftl";
    }
}
