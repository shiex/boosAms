package com.xbb.dao;

import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.Category;

import java.util.List;

/**
 * @author shiex-薛
 * @title: CategoryDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface CategoryDao extends BaseCrudDao<Category> {
    List<Category> selectAllCategoryClassify();

    int selectCountById(int categoryId);
}
