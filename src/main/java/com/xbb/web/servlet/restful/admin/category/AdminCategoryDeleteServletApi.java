package com.xbb.web.servlet.restful.admin.category;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Category;
import com.xbb.service.CategoryService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.exception.RestfulException;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminCategoryDeleteServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00283:58
 */
public class AdminCategoryDeleteServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
        int is = categoryService.selectCountById(jreq.getIntValue("categoryId"));
        if (is > 0) {
            throw new RestfulException(-9, "该分类存在二级分类，不可删除");
        }
        categoryService.deleteById(jreq.getIntValue("categoryId"));
        return null;
    }
}
