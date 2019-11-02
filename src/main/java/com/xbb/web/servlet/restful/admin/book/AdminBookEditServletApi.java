package com.xbb.web.servlet.restful.admin.book;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: AdminBookEditServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00282:15
 */
public class AdminBookEditServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        Book book = JSON.toJavaObject(jreq, Book.class);
        BookService bookService = ServiceUtils.getService(BookService.class);
        bookService.updateById(book);
        Map<String, Object> data = new HashMap<>();
        data.put("book", book);
        return data;
    }
}
