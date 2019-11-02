package com.xbb.service;

import com.xbb.entity.Book;
import com.xbb.service.base.BaseCrudService;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BookService
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:18
 */
public interface BookService extends BaseCrudService<Book> {

    Object[] getPageInfoData(int classifyId, int page, int pageSize);

    List<Book> getPageInfoList(int classifyId, int page, int pageSize);

    int selectCountByClassifyId(int classifyId);

    List<Book> findBookAll(Book book);

}
