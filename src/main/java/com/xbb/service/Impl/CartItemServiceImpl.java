package com.xbb.service.Impl;

import com.xbb.dao.CartItemDao;
import com.xbb.entity.CartItem;
import com.xbb.service.CartItemService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: CartItemServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:21
 */
public class CartItemServiceImpl implements CartItemService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private CartItemDao cartItemDao = sqlSession.getMapper(CartItemDao.class);

    @Override
    public int deleteById(int id) {
        return cartItemDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return cartItemDao.deleteByIds(ids);
    }

    @Override
    public int insert(CartItem cartItem) {
        return cartItemDao.insert(cartItem);
    }

    @Override
    public CartItem selectOneById(int id) {
        return cartItemDao.selectOneById(id);
    }

    @Override
    public List<CartItem> selectAll() {
        return cartItemDao.selectAll();
    }

    @Override
    public List<CartItem> selectAllByUserId(Integer userId) {
        return cartItemDao.selectAllByUserId(userId);
    }

    @Override
    public List<CartItem> selectAllByIds(List<Integer> idList) {
        return cartItemDao.selectAllByIds(idList);
    }

    @Override
    public int selectCount() {
        return cartItemDao.selectCount();
    }

    @Override
    public int updateById(CartItem cartItem) {
        return cartItemDao.updateById(cartItem);
    }

    @Override
    public int update(CartItem cartItem) {
        return cartItemDao.update(cartItem);
    }

    @Override
    public int updateIncreaseQuantity(int cartItemId) {
        return cartItemDao.updateIncreaseQuantity(cartItemId);
    }

    @Override
    public int updateReduceQuantity(int cartItemId) {
        return cartItemDao.updateReduceQuantity(cartItemId);
    }
}
