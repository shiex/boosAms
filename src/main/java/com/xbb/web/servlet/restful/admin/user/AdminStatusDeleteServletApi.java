package com.xbb.web.servlet.restful.admin.user;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminStatusDeleteServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 002819:46
 */
public class AdminStatusDeleteServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        User user = JSONObject.toJavaObject(jreq, User.class);
        UserService userService = ServiceUtils.getService(UserService.class);
        userService.updateById(user);
        return null;
    }
}
