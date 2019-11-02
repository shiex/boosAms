package com.xbb.web.servlet.restful.admin;

import com.alibaba.fastjson.JSONObject;
import com.xbb.constant.WebConstant;
import com.xbb.entity.Admin;
import com.xbb.service.AdminService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.exception.RestfulException;
import com.xbb.web.base.restful.RestfulApi;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author shiex-薛
 * @title: AdminLoginServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002723:42
 */
public class AdminLoginServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        String adminName = jreq.getString("adminName");
        String adminPwd = jreq.getString("adminPwd");
        AdminService adminService = ServiceUtils.getService(AdminService.class);
        Admin admin = adminService.selectByName(adminName);
        if (admin == null) {
            throw new RestfulException(-1, "管理员不存在!");
        }
        if (!StringUtils.equals(adminPwd, admin.getAdminPwd())) {
            throw new RestfulException(-1, "密码错误!");
        }

        HttpSession session = httpReq.getSession();
        session.setAttribute(WebConstant.SESSEION_KEY_USER, admin);
        return null;
    }
}
