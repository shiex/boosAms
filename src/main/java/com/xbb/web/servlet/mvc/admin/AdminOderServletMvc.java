package com.xbb.web.servlet.mvc.admin;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Order;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;
import com.xbb.web.base.restful.RestfulApi;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminOderServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00286:31
 */
@WebServlet("/admin/order.html")
public class AdminOderServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        List<Order> orderList = null;
        if (req.getParameter("status") != null){
            orderList = orderService.selectAllByStatus(Integer.valueOf(req.getParameter("status")));
        }else {
            orderList = orderService.selectAll();
        }
        for (Order order : orderList) {
            setStatusStr(order);
        }
        model.put("orderList", orderList);
        return "admin_order.ftl";
    }

    private void setStatusStr(Order order) {
        if (order.getStatus() == 1){
            order.setStatusStr("等待付款");
        }
        if (order.getStatus() == 2){
            order.setStatusStr("已付款");
        }
        if (order.getStatus() == 3){
            order.setStatusStr("已发货");
        }
        if (order.getStatus() == 4){
            order.setStatusStr("交易成功");
        }
        if (order.getStatus() == 5){
            order.setStatusStr("已取消");
        }
    }
}
