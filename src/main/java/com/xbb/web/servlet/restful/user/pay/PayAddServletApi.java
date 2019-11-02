package com.xbb.web.servlet.restful.user.pay;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Order;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: PayAddServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002722:45
 */
public class PayAddServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Integer orderId = Integer.valueOf(jreq.getIntValue("orderId"));
        Order order = new Order();
        order.setoId(orderId);
        order.setStatus(2);
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        orderService.updateById(order);
        return null;
    }
}
