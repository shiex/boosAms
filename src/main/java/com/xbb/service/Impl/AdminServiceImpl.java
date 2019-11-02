package com.xbb.service.Impl;

import com.xbb.dao.AdminDao;
import com.xbb.entity.Admin;
import com.xbb.service.AdminService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: AdminServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:20
 */
public class AdminServiceImpl implements AdminService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private AdminDao adminDao = sqlSession.getMapper(AdminDao.class);

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return 0;
    }

    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public Admin selectByName(String adminName) {
        return adminDao.selectByName(adminName);
    }

    @Override
    public Admin selectOneById(int id) {
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        return null;
    }

    @Override
    public int selectCount() {
        return 0;
    }

    @Override
    public int updateById(Admin admin) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }
}
