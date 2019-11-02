package com.xbb.service.Impl;

import com.xbb.dao.UserDao;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: UserServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public class UserServiceImpl implements UserService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserDao userDao = sqlSession.getMapper(UserDao.class);

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int selectPass(Integer userId, String loginPass) {
        return userDao.selectPass(userId, loginPass);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return 0;
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User selectOneById(int id) {
        return userDao.selectOneById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }

    @Override
    public User selectUserByName(String loginName) {
        return userDao.selectUserByName(loginName);
    }

    @Override
    public int updateById(User user) {
        return userDao.updateById(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
