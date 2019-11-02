package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.Category;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: CategoryService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:19
 */
public interface CategoryService extends BaseCrudService<Category> {
    List<Category> selectAllCategoryClassify();

    int selectCountById(int categoryId);

}
