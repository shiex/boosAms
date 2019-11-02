package com.xbb.web.servlet.restful.admin;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Order;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminFaHuoServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00286:48
 */
public class AdminFaHuoServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Integer orderId = Integer.valueOf(jreq.getIntValue("orderId"));
        Order order = new Order();
        order.setoId(orderId);
        order.setStatus(3);
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        orderService.updateById(order);
        return null;
    }
}
