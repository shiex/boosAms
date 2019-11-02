package com.xbb.web.servlet.restful.admin.category;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.CartItem;
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
public class AdminCategorySaveServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        Category category = JSON.toJavaObject(jreq, Category.class);
        if (category.getCategoryId() == 0){
            category.setCategoryId(null);
            categoryService.insert(category);
        } else {
            categoryService.updateById(category);
        }
        return null;
    }
}
