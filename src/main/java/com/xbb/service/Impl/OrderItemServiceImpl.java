package com.xbb.service.Impl;

import com.xbb.dao.OrderItemDao;
import com.xbb.entity.Order;
import com.xbb.entity.OrderItem;
import com.xbb.service.OrderItemService;
import com.xbb.service.OrderService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderItemServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public class OrderItemServiceImpl implements OrderItemService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private OrderItemDao orderItemDao = sqlSession.getMapper(OrderItemDao.class);

    @Override
    public int deleteById(int id) {
        return orderItemDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return orderItemDao.deleteByIds(ids);
    }

    @Override
    public int insert(OrderItem orderItem) {
        return orderItemDao.insert(orderItem);
    }

    @Override
    public void insertList(List<OrderItem> orderItemList) {
        orderItemDao.insertList(orderItemList);
    }

    @Override
    public OrderItem selectOneById(int id) {
        return orderItemDao.selectOneById(id);
    }

    @Override
    public List<OrderItem> selectAll() {
        return orderItemDao.selectAll();
    }

    @Override
    public int selectCount() {
        return orderItemDao.selectCount();
    }

    @Override
    public int updateById(OrderItem orderItem) {
        return orderItemDao.updateById(orderItem);
    }

    @Override
    public int update(OrderItem orderItem) {
        return orderItemDao.update(orderItem);
    }
}
