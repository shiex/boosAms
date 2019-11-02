package com.xbb.web.servlet.mvc.user;

import com.xbb.constant.WebConstant;
import com.xbb.entity.CartItem;
import com.xbb.entity.User;
import com.xbb.service.CartItemService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: CartItemServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002714:01
 */
@WebServlet("/shopping.html")
public class CartItemServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        User user = (User) req.getSession().getAttribute(WebConstant.SESSEION_KEY_USER);
        CartItemService cartItemService = ServiceUtils.getService(CartItemService.class);
        List<CartItem> cartItemList = cartItemService.selectAllByUserId(user.getuId());
        model.put("cartItemList", cartItemList);
        return "/shopping.ftl";
    }
}
