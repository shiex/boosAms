package com.xbb.web.servlet.mvc.user;

import com.xbb.entity.CartItem;
import com.xbb.service.CartItemService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002716:19
 */
@WebServlet("/order.html")
public class OrderServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model)
            throws Exception {
        HttpSession session = req.getSession();
        String cartItemIds = (String) session.getAttribute("cartItemIds");
        String priceAll = (String) session.getAttribute("priceAll");
        String[] ids = cartItemIds.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Integer.valueOf(id));
        }

        CartItemService cartItemService = ServiceUtils.getService(CartItemService.class);
        List<CartItem> cartItemList = cartItemService.selectAllByIds(idList);
        session.setAttribute("cartItemList", cartItemList);
        model.put("cartItemList", cartItemList);
        model.put("priceAll", priceAll);
        return "order.ftl";
    }
}
