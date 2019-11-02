package com.xbb.web.servlet.restful.user;

import com.alibaba.fastjson.JSONObject;
import com.xbb.constant.WebConstant;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.exception.RestfulException;
import com.xbb.web.base.restful.RestfulApi;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author shiex-薛
 * @title: PassUpdateServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002722:47
 */
public class PassUpdateServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        HttpSession session = httpReq.getSession();

        String imgCode = (String) session.getAttribute(WebConstant.SESSEION_KEY_CODE);
        if (!StringUtils.equalsIgnoreCase(imgCode, jreq.getString("imgCode"))){
            throw new RestfulException(-1, "验证码错误，请重新输入!");
        }

        String loginPass = jreq.getString("password");
        User user = (User) session.getAttribute(WebConstant.SESSEION_KEY_USER);
        UserService userService = ServiceUtils.getService(UserService.class);
        int is = userService.selectPass(user.getuId(), loginPass);
        if (is == 0) {
            throw new RestfulException(-1, "原密码错误，请重新输入!");
        }

        user.setLoginPass(jreq.getString("newPassword"));
        userService.updateById(user);
        return null;
    }
}
