package com.xbb.service.base;

/**
 * @author shiex-薛
 * @title: BaseCrudService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:23
 */
public interface BaseCrudService<T> extends
        BaseInsertService<T>,
        BaseUpdateService<T>,
        BaseDeleteService<T>,
        BaseSelectService<T> {
}
