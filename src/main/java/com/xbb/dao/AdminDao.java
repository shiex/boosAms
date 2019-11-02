package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.Admin;

/**
 * @author shiex-薛
 * @title: AdminDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface AdminDao extends BaseCrudDao<Admin> {
    Admin selectByName(String adminName);
}
