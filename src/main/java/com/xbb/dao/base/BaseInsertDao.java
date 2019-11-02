package com.xbb.dao.base;

/**
 * @author shiex-薛
 * @title: BaseInsertDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:40
 */
public interface BaseInsertDao<T> {
    int insert(T t);
}
