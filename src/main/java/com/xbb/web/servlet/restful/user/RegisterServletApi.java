package com.xbb.web.servlet.restful.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.constant.WebConstant;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.SendEmaliUtils;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.exception.RestfulException;
import com.xbb.web.base.restful.RestfulApi;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * @author shiex-薛
 * @title: UserRegisterApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\26 002622:12
 */
public class RegisterServletApi extends RestfulApi {

    private static Logger log = LoggerFactory.getLogger(RegisterServletApi.class);

    @Override
    public Object execute(JSONObject jreq) throws Exception {
        User user = JSON.toJavaObject(jreq, User.class);

        HttpSession session = httpReq.getSession();
        String imgCode = (String) session.getAttribute(WebConstant.SESSEION_KEY_CODE);
        if (!StringUtils.equalsIgnoreCase(user.getImgCode(), imgCode)) {  //忽略验证码大小写
            throw new RestfulException(-1, "验证码错误!!!");
        }

        UserService userService = ServiceUtils.getService(UserService.class);
        User userIsExist = userService.selectUserByName(user.getLoginName());
        if (userIsExist != null) {
            throw new RestfulException(-1, "用户名已注册，请登录!");
        } else {
            int emaliIsExist = userService.selectCount();
            if (emaliIsExist != 0) {
                throw new RestfulException(-1, "邮箱已存在，不可重复注册!");
            }
        }

        int isSucceed = userService.insert(user);
        if (isSucceed != 0) {
            session.setAttribute(WebConstant.SESSEION_KEY_USER, user);
        }

        SendEmaliUtils.SendMail(user.getEmali(), user.getuId());
        return null;
    }
}
