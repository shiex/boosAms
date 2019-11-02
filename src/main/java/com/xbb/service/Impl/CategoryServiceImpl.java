package com.xbb.service.Impl;

import com.xbb.dao.CartItemDao;
import com.xbb.dao.CategoryDao;
import com.xbb.entity.Category;
import com.xbb.service.CategoryService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: CategoryServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:21
 */
public class CategoryServiceImpl implements CategoryService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);

    @Override
    public int deleteById(int id) {
        return categoryDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return categoryDao.deleteByIds(ids);
    }

    @Override
    public int insert(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public Category selectOneById(int id) {
        return categoryDao.selectOneById(id);
    }

    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public List<Category> selectAllCategoryClassify() {
        sqlSession.clearCache();
        return categoryDao.selectAllCategoryClassify();
    }

    @Override
    public int selectCount() {
        return categoryDao.selectCount();
    }

    @Override
    public int selectCountById(int categoryId) {
        return categoryDao.selectCountById(categoryId);
    }

    @Override
    public int updateById(Category category) {
        return categoryDao.updateById(category);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }
}
