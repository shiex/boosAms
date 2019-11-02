package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.CartItem;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: CartitemService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:18
 */
public interface CartItemService extends BaseCrudService<CartItem> {
    List<CartItem> selectAllByUserId(Integer userId);

    int updateIncreaseQuantity(int cartItemId);

    int updateReduceQuantity(int cartItemId);

    List<CartItem> selectAllByIds(List<Integer> idList);
}
