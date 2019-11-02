package com.xbb.web.servlet.mvc.user;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xbb.constant.WebConstant;
import com.xbb.entity.Order;
import com.xbb.entity.User;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderListServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002719:27
 */
@WebServlet("/orderlist.html")
public class OrderListServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(WebConstant.SESSEION_KEY_USER);
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        List<Order> orderList = orderService.selectPageHelper(user.getuId(), 0, 10);
        for (Order order : orderList) {
            setStatusStr(order);
        }
        model.put("orderList", orderList);
        return "orderList.ftl";
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
