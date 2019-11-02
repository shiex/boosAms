package com.xbb.web.servlet.mvc.user;

import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author shiex-薛
 * @title: BookServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 00271:36
 */
@WebServlet("/book.html")
public class BookServletMvc extends AbstractSimpleMVC {

    private static Logger log = LoggerFactory.getLogger(BookServletMvc.class);

    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        BookService bookService = ServiceUtils.getService(BookService.class);
        Book book = bookService.selectOneById(bookId);
        log.info(book.toString());
        model.put("book", book);
        return "book.ftl";
    }
}
