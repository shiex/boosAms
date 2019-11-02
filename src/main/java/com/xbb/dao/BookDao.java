package com.xbb.dao;


import com.xbb.dao.base.BaseCrudDao;
import com.xbb.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BookDao
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:26
 */
public interface BookDao extends BaseCrudDao<Book> {

    List<Book> selectPageHelper(@Param("classifyId") int classifyId,
                                @Param("page") int page,
                                @Param("pageSize") int pageSize);

    int selectCountByClassifyId(int classifyId);

    List<Book> findBookAll(Book book);
}
