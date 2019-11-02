package com.xbb.web.servlet.restful.admin.classify;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Classify;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: AdminClassifyLoadServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00282:01
 */
public class AdminClassifyLoadServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Integer categoryId = jreq.getIntValue("categoryId");
        ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
        List<Classify> classifyList = classifyService.selectAllByCategoryId(categoryId);
        Map<String, Object> data = new HashMap<>();
        data.put("classifyList", classifyList);
        return data;
    }
}
