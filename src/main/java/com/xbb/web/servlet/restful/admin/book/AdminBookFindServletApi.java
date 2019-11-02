package com.xbb.web.servlet.restful.admin.book;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: BookFindServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002720:25
 */
public class AdminBookFindServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        String type = jreq.getString("type");
        String find = jreq.getString("find");
        BookService bookService = ServiceUtils.getService(BookService.class);
        Book book = new Book();
        if (StringUtils.equals(type, "1")) {
            book.setbName(find);
        }
        if (StringUtils.equals(type, "2")) {
            book.setAuthor(find);
        }
        if (StringUtils.equals(type, "3")) {
            book.setPress(find);
        }
        List<Book> bookList = bookService.findBookAll(book);
        Map<String, Object> data = new HashMap<>();
        data.put("bookList", bookList);
        return data;
    }
}
