package com.xbb.web.servlet.restful.admin.book;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.FileUploadUtils;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.restful.RestfulApi;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * @author shiex-薛
 * @title: AdminBookAddServletApi
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00280:55
 */
public class AdminBookAddServletApi extends RestfulApi {

    @Override
    public Object execute(JSONObject jreq) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Integer categoryId = jreq.getIntValue("categoryId");
        String publishTime = jreq.getString("publishTime");
        String printTime = jreq.getString("printTime");
        jreq.remove("publishTime");
        jreq.remove("printTime");
        if (categoryId != null){
            jreq.remove("categoryId");
        }

        BookService bookService = ServiceUtils.getService(BookService.class);
        Book book = JSON.toJavaObject(jreq, Book.class);
        if (book.getbId() == null){
            String imageUri = (String) httpReq.getSession().getAttribute("imageUri");
            if (imageUri != null) {
                book.setImageUri(imageUri);
            }
            bookService = ServiceUtils.getService(BookService.class);
            book.setIsbn(FileUploadUtils.createUUID());
            book.setPublishTime(format.parse(publishTime));
            book.setPrintTime(format.parse(printTime));
            bookService.insert(book);
        } else {
            bookService.updateById(book);
        }
        return null;
    }
}
