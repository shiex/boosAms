package com.xbb.dao.base;

/**
 * @author shiex-薛
 * @title: BaseUpdateDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:41
 */
public interface BaseUpdateDao<T> {

    int updateById(T t);

    int update(T t);

}
