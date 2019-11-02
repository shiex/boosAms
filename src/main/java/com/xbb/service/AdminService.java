package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.service.base.BaseCrudService;

/**
 * @author shiex-薛
 * @title: AdminService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:18
 */
public interface AdminService extends BaseCrudService<Admin> {
    Admin selectByName(String adminName);
}
