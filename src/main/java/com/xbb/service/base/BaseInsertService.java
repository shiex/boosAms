package com.xbb.service.base;

/**
 * @author shiex-薛
 * @title: BaseInsertService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public interface BaseInsertService<T> {
    int insert(T t);
}
