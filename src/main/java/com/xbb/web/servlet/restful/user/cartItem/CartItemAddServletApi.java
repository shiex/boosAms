package com.xbb.web.servlet.restful.user.cartItem;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.constant.WebConstant;
import com.xbb.entity.CartItem;
import com.xbb.entity.User;
import com.xbb.service.CartItemService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AddCartItemServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002713:41
 */
public class CartItemAddServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        CartItem cartItem = JSON.toJavaObject(jreq, CartItem.class);
        User user = (User) httpReq.getSession().getAttribute(WebConstant.SESSEION_KEY_USER);
        cartItem.setuId(user.getuId());
        CartItemService cartItemService = ServiceUtils.getService(CartItemService.class);
        cartItemService.insert(cartItem);
        return null;
    }
}
