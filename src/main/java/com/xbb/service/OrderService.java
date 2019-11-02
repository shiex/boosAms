package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.Order;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:19
 */
public interface OrderService extends BaseCrudService<Order> {
    Order selectPayData(Integer orderId);

    List<Order> selectPageHelper(Integer userId, int page, int pageSize);

    List<Order> selectAllByStatus(Integer status);
}
