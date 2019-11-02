package com.xbb.service.Impl;

import com.xbb.dao.ClassifyDao;
import com.xbb.entity.Classify;
import com.xbb.service.ClassifyService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: ClassifyServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:21
 */
public class ClassifyServiceImpl implements ClassifyService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private ClassifyDao classifyDao = sqlSession.getMapper(ClassifyDao.class);

    @Override
    public int deleteById(int id) {
        return classifyDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return classifyDao.deleteByIds(ids);
    }

    @Override
    public int insert(Classify classify) {
        return classifyDao.insert(classify);
    }

    @Override
    public Classify selectOneById(int id) {
        return classifyDao.selectOneById(id);
    }

    @Override
    public List<Classify> selectAllByCategoryId(Integer categoryId) {
        return classifyDao.selectAllByCategoryId(categoryId);
    }

    @Override
    public List<Classify> selectAll() {
        return classifyDao.selectAll();
    }

    @Override
    public int selectCount() {
        return classifyDao.selectCount();
    }

    @Override
    public int updateById(Classify classify) {
        return classifyDao.updateById(classify);
    }

    @Override
    public int update(Classify classify) {
        return classifyDao.update(classify);
    }
}
