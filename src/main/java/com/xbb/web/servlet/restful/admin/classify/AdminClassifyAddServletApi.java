package com.xbb.web.servlet.restful.admin.classify;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Classify;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminClassifyAddServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00285:08
 */
public class AdminClassifyAddServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Classify classify = JSONObject.toJavaObject(jreq, Classify.class);
        ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
        classifyService.insert(classify);
        return null;
    }
}
