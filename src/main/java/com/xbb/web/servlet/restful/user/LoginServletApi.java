package com.xbb.web.servlet.restful.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.constant.WebConstant;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.exception.RestfulException;
import com.xbb.web.base.restful.RestfulApi;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * @author shiex-薛
 * @title: UserLoginApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\26 002622:12
 */
public class LoginServletApi extends RestfulApi {

    private static Logger log = LoggerFactory.getLogger(LoginServletApi.class);

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
        if (userIsExist == null) {
            throw new RestfulException(-1, "用户不存在，请先注册!");
        }
        if (!StringUtils.equals(userIsExist.getLoginPass(), user.getLoginPass())) {
            throw new RestfulException(-1, "密码错误!");
        }
        if (userIsExist.getActivationCode() == null) {
            throw new RestfulException(-1, "请先在邮箱进行激活!");
        }
        if (userIsExist.getStatus()) {
            throw new RestfulException(-1, "无法登陆！您处于禁止状态，请联系管理员!");
        }
        session.setAttribute(WebConstant.SESSEION_KEY_USER, userIsExist);

        return null;
    }

}
