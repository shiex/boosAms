package com.xbb.web.servlet.mvc.user;

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

/**
 * @author shiex-薛
 * @title: PayServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002719:58
 */
@WebServlet("/pay.html")
public class PayServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(WebConstant.SESSEION_KEY_USER);
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        OrderService orderService = ServiceUtils.getService(OrderService.class);
        Order order = orderService.selectOneById(orderId);
        model.put("order", order);
        return "/pay.ftl";
    }
}
