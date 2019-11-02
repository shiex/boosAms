package com.xbb.web.servlet.mvc.user;

import com.xbb.constant.WebConstant;
import com.xbb.entity.CartItem;
import com.xbb.entity.Order;
import com.xbb.entity.OrderItem;
import com.xbb.entity.User;
import com.xbb.service.OrderItemService;
import com.xbb.service.OrderService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderOkServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002717:06
 */
@WebServlet("/orderok.html")
public class OrderOkServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        HttpSession session = req.getSession();

        OrderService orderService = ServiceUtils.getService(OrderService.class);
        User user = (User) session.getAttribute(WebConstant.SESSEION_KEY_USER);
        String address = req.getParameter("address");
        String priceAll = (String) session.getAttribute("priceAll");
        Order order = new Order();
        order.setuId(user.getuId());
        order.setAddress(address);
        order.setTotal(Double.valueOf(priceAll));
        order.setStatus(1);
        order.setOrderTime(new Date());
        orderService.insert(order);

        OrderItemService orderItemService = ServiceUtils.getService(OrderItemService.class);
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItemList");
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = null;
        if (cartItemList != null && cartItemList.size() > 0) {
            for(CartItem cartItem : cartItemList){
                Double subtotal = (Double) (cartItem.getQuantity() * cartItem.getBook().getCurrPrice());
                orderItem = new OrderItem();
                orderItem.setbId(cartItem.getBook().getbId());
                orderItem.setoId(order.getoId());
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setSubtotal(subtotal);
                orderItemList.add(orderItem);
            }
            orderItemService.insertList(orderItemList);
        }

        session.removeAttribute("priceAll");
        session.removeAttribute("cartItemList");

        model.put("order", order);
        return "orderok.ftl";
    }
}
