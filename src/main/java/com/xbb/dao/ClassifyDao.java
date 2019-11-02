package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.Classify;

import java.util.List;

/**
 * @author shiex-薛
 * @title: ClassifyDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface ClassifyDao extends BaseCrudDao<Classify> {
    List<Classify> selectAllByCategoryId(Integer categoryId);
}
