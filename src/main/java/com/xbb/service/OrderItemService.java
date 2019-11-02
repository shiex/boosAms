package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.OrderItem;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderItemService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:19
 */
public interface OrderItemService extends BaseCrudService<OrderItem> {
    void insertList(List<OrderItem> orderItemList);
}
