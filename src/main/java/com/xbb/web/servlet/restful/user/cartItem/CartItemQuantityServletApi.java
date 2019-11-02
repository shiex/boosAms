package com.xbb.web.servlet.restful.user.cartItem;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.CartItem;
import com.xbb.service.CartItemService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.List;

/**
 * @author shiex-薛
 * @title: QuantityCartItemServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002715:39
 */
public class CartItemQuantityServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        CartItemService cartItemService = ServiceUtils.getService(CartItemService.class);
        int isAdd = jreq.getIntValue("isAdd");
        int cartItemId = jreq.getIntValue("cartItemId");
        if (isAdd == 1) {
            cartItemService.updateIncreaseQuantity(cartItemId);
        } else {
            CartItem cartItem = cartItemService.selectOneById(cartItemId);
            if (cartItem.getQuantity() > 1){
                cartItemService.updateReduceQuantity(cartItemId);
            }
        }
        return null;
    }
}
