package com.xbb.dao.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BaseSelevtDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:40
 */
public interface BaseSelectDao<T> {

    T selectOneById(int id);

    List<T> selectAll();

    int selectCount();

}
