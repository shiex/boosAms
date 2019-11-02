package com.xbb.web.servlet.restful.admin.category;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Category;
import com.xbb.service.CategoryService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminAddCategoryServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00285:06
 */
public class AdminCategorEditServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Category category = JSON.toJavaObject(jreq, Category.class);
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        categoryService.update(category);
        return null;
    }
}
