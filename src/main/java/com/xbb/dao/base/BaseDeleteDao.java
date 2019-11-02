package com.xbb.dao.base;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BaseDeleteDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:40
 */
public interface BaseDeleteDao<T> {
    int deleteById(int id);
    int deleteByIds(List<Integer> ids);
}
