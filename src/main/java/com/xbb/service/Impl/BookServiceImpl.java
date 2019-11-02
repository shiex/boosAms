package com.xbb.service.Impl;
import com.xbb.dao.BookDao;
import com.xbb.entity.Book;
import com.xbb.service.BookService;
import com.xbb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author shiex-薛
 * @title: BookServiceImpl
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002513:21
 */
public class BookServiceImpl implements BookService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private BookDao bookDao = sqlSession.getMapper(BookDao.class);

    @Override
    public int deleteById(int id) {
        return bookDao.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return 0;
    }

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public Book selectOneById(int id) {
        return bookDao.selectOneById(id);
    }

    @Override
    public List<Book> findBookAll(Book book) {
        return bookDao.findBookAll(book);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public int selectCount() {
        return bookDao.selectCount();
    }

    @Override
    public int selectCountByClassifyId(int classifyId) {
        return bookDao.selectCountByClassifyId(classifyId);
    }

    @Override
    public Object[] getPageInfoData(int classifyId, int page, int pageSize) {
        int count = selectCountByClassifyId(classifyId);
        List<Book> bookList = getPageInfoList(classifyId, page, pageSize);
        Object[] objects = new Object[2];
        objects[0] = count;
        objects[1] = bookList;
        return objects;
    }

    @Override
    public List<Book> getPageInfoList(int classifyId, int page, int pageSize) {
        return bookDao.selectPageHelper(classifyId, page, pageSize);
    }

    @Override
    public int updateById(Book book) {
        return bookDao.updateById(book);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }
}
