package com.xbb.web.servlet.mvc.admin;

import com.xbb.entity.Book;
import com.xbb.entity.Category;
import com.xbb.entity.Classify;
import com.xbb.service.BookService;
import com.xbb.service.CategoryService;
import com.xbb.service.ClassifyService;
import com.xbb.utils.ServiceUtils;
import com.xbb.web.base.mvc.AbstractSimpleMVC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: AdminBookAddServletMvc
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\28 00282:51
 */
@WebServlet("/admin/book/add")
public class AdminBookAddServletMvc extends AbstractSimpleMVC {
    @Override
    protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model) throws Exception {

        if (req.getParameter("bookId") != null){
            BookService bookService = ServiceUtils.getService(BookService.class);
            Book book = bookService.selectOneById(Integer.valueOf(req.getParameter("bookId")));
            model.put("book", book);
        } else {
            CategoryService categoryService = ServiceUtils.getService(CategoryService.class);
            ClassifyService classifyService = ServiceUtils.getService(ClassifyService.class);
            List<Category> categoryList = categoryService.selectAll();
            if (categoryList != null && categoryList.size() > 0) {
                List<Classify> classifyList = classifyService.
                        selectAllByCategoryId(categoryList.get(0).getCategoryId());
                model.put("categoryList", categoryList);
                model.put("classifyList", classifyList);
            }
        }
        return "/admin_add_book.ftl";
    }
}
