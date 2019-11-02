package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.OrderItem;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderItemDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:27
 */
public interface OrderItemDao extends BaseCrudDao<OrderItem> {
    void insertList(List<OrderItem> orderItemList);
}
