package com.xbb.service.base;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BaseSelectService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:22
 */
public interface BaseSelectService<T> {

    T selectOneById(int id);

    List<T> selectAll();

    int selectCount();

}
