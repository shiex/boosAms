package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.CartItem;

import java.util.List;

/**
 * @author shiex-薛
 * @title: CartItemDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface CartItemDao extends BaseCrudDao<CartItem> {
    List<CartItem> selectAllByUserId(Integer userId);

    int updateIncreaseQuantity(int cartItemId);

    int updateReduceQuantity(int cartItemId);

    List<CartItem> selectAllByIds(List<Integer> idList);
}
