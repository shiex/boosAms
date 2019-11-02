package com.xbb.service.base;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BaseDeleteService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:23
 */
public interface BaseDeleteService<T> {
    int deleteById(int id);

    int deleteByIds(List<Integer> ids);
}
