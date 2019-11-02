package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.Classify;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: ClassifyService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:19
 */
public interface ClassifyService extends BaseCrudService<Classify> {
    List<Classify> selectAllByCategoryId(Integer categoryId);
}
