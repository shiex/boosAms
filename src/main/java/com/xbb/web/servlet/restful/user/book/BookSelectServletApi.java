package com.xbb.web.servlet.restful.user.book;

import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author shiex-薛
 * @title: BookServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\25 002521:14
 */
public class BookSelectServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        int page = jreq.getIntValue("page") - 1;
        if (page > 0) {
            page = page * 8;
        }
        BookService bookService = ServiceUtils.getService(BookService.class);
        Object[] objects = bookService.getPageInfoData(jreq.getIntValue("classifyId"), page, 8);
        Map<String, Object> data = new HashMap<>();
        data.put("classifyId", jreq.getIntValue("classifyId"));
        data.put("count", objects[0]);
        data.put("bookList", objects[1]);
        return data;
    }
}
