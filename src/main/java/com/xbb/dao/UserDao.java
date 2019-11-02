package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author shiex-薛
 * @title: UserDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:27
 */
public interface UserDao extends BaseCrudDao<User> {
    User select();

    User selectUserByName(String loginName);

    int selectPass(@Param("userId") Integer userId,
                    @Param("loginPass") String loginPass);
}
