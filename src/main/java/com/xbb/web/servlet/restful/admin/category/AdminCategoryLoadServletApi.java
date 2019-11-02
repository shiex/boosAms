package com.xbb.web.servlet.restful.admin.category;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Category;
import com.xbb.entity.Classify;
import com.xbb.service.CategoryService;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: AdminCategoryLoadServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00282:01
 */
public class AdminCategoryLoadServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        List<Category> categoryList = categoryService.selectAll();

        ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
        List<Classify> classifyList = classifyService.
                selectAllByCategoryId(categoryList.get(0).getCategoryId());
        Map<String, Object> data = new HashMap<>();

        data.put("categoryList", categoryList);
        data.put("classifyList", classifyList);
        return data;
    }
}
