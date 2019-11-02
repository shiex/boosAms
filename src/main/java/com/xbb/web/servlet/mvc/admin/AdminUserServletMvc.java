package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminUserServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 002819:30
 */
@WebServlet("/admin/user")
public class AdminUserServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        UserService userService = ServiceUtils.getService(UserService.class);
        List<User> userList = userService.selectAll();
        model.put("userList", userList);
        return "/admin_user.ftl";
    }
}
