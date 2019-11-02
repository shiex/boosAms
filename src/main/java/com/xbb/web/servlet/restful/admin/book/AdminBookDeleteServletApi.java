package com.xbb.web.servlet.restful.admin.book;

import com.alibaba.fastjson.JSONObject;
import com.xbb.service.BookService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

/**
 * @author shiex-薛
 * @title: AdminBookDeleteServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00283:58
 */
public class AdminBookDeleteServletApi extends RestfulApi {
    @Override
    public Object execute(JSONObject jreq) throws Exception {
        BookService bookService = ServiceUtils.getService(BookService.class);
        bookService.deleteById(jreq.getIntValue("bookId"));
        return null;
    }
}
