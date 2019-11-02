package com.xbb.service;

import com.xbb.entity.Admin;
import com.xbb.entity.User;
import com.xbb.service.base.BaseCrudService;

/**
 * @author shiex-薛
 * @title: UserService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:19
 */
public interface UserService extends BaseCrudService<User> {
    User selectUserByName(String loginName);

    int selectPass(Integer userId, String loginPass);
}
