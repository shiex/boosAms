package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface OrderDao extends BaseCrudDao<Order> {
    Order selectPayData(@Param("orderId") Integer orderId);

    List<Order> selectPageHelper(@Param("userId") Integer userId,
                                 @Param("page") int page,
                                 @Param("pageSize") int pageSize);

    List<Order> selectAllByStatus(Integer status);
}
