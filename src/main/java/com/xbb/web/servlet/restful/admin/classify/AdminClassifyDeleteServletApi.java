package com.xbb.web.servlet.restful.admin.classify;

import com.alibaba.fastjson.JSONObject;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminClassifyDeleteServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00283:58
 */
public class AdminClassifyDeleteServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
        classifyService.deleteById(jreq.getIntValue("classifyId"));
        return null;
    }
}
