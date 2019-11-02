package com.xbb.web.servlet.restful.user.cartItem;

import com.alibaba.fastjson.JSONObject;
import com.xbb.service.CartItemService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiex-薛
 * @title: CartItemDeleteServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002714:13
 */
public class CartItemDeleteServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        String cartItemIds = jreq.getString("cartItemIds");
        String[] ids = cartItemIds.split(",");
        CartItemService cartItemService = ServiceUtils.getService(CartItemService.class);
        List<Integer> idList = null;
        if(ids.length > 1){
            idList = new ArrayList<>();
            for (String id : ids) {
                idList.add(Integer.valueOf(id));
            }
            cartItemService.deleteByIds(idList);
        } else {
            cartItemService.deleteById(Integer.valueOf(ids[0]));
        }

        return null;
    }
}
