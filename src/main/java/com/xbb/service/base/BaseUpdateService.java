package com.xbb.service.base;

/**
 * @author shiex-薛
 * @title: BaseUpdateService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public interface BaseUpdateService<T> {

    int updateById(T t);

    int update(T t);

}
