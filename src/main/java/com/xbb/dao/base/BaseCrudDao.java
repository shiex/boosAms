package com.xbb.dao.base;

/**
 * @author shiex-薛
 * @title: BaseCrudDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:41
 */
public interface BaseCrudDao<T> extends
        BaseDeleteDao<T>,
        BaseSelectDao<T>,
        BaseUpdateDao<T>,
        BaseInsertDao<T> {
}
