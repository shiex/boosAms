package com.xbb.web.servlet.restful.user.cartItem;

import com.alibaba.fastjson.JSONObject;
import com.xbb.web.base.restful.RestfulApi;

import javax.servlet.http.HttpSession;

/**
 * @author shiex-薛
 * @title: AccountsCartItemServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002716:18
 */
public class CartItemAccountsServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        HttpSession session = httpReq.getSession();
        session.setAttribute("cartItemIds", jreq.getString("cartItemIds"));
        session.setAttribute("priceAll", jreq.getString("priceAll"));
        return null;
    }
}
