package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.Order;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminOrderPayServletAPi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00286:43
 */
@WebServlet("/admin/orderpay.html")
public class AdminOrderPayServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        Order order = orderService.selectPayData(orderId);
        model.put("order", order);
        return "/admin_orderpay.ftl";
    }
}
