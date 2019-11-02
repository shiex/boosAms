package com.xbb.service.Impl;

import com.xbb.dao.OrderDao;
import com.xbb.entity.Order;
import com.xbb.service.OrderService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: OrderServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public class OrderServiceImpl implements OrderService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private OrderDao orderDao = sqlSession.getMapper(OrderDao.class);

    @Override
    public int deleteById(int id) {
        return orderDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return orderDao.deleteByIds(ids);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public Order selectOneById(int id) {
        return orderDao.selectOneById(id);
    }

    @Override
    public List<Order> selectAllByStatus(Integer status) {
        return orderDao.selectAllByStatus(status);
    }

    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }

    @Override
    public Order selectPayData(Integer orderId) {
        return orderDao.selectPayData(orderId);
    }

    @Override
    public List<Order> selectPageHelper(Integer userId, int page, int pageSize) {
        return orderDao.selectPageHelper(userId, page, pageSize);
    }

    @Override
    public int selectCount() {
        return orderDao.selectCount();
    }

    @Override
    public int updateById(Order order) {
        return orderDao.updateById(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }
}
