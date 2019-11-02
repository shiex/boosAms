package com.xbb;

import com.sun.mail.util.MailSSLSocketFactory;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.xbb.dao.BookDao;
import com.xbb.dao.OrderDao;
import com.xbb.entity.Book;
import com.xbb.entity.Order;
import com.xbb.service.BookService;
import com.xbb.service.Impl.BookServiceImpl;
import com.xbb.service.base.BaseCrudService;
import com.xbb.utils.MybatisUtils;
import com.xbb.utils.SendEmaliUtils;
import com.xbb.utils.ServiceUtils;
import org.apache.ibatis.session.SqlSession;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shiex-薛
 * @title: Test
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\25 002515:17
 */
public class Test {

    // 测试数据
    @org.junit.Test
    public void m1() throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // BookDao bookDao = (BookDao) sqlSession.getMapper(BookDao.class);
        /*Book book = null;
        for (int i=0; i<55; i++) {
            book = new Book();
            book.setbName("书名" + i);
            book.setAuthor("作者" + i);
            book.setClassifyId(1);
            book.setPrice(Double.valueOf(i));
            book.setCurrPrice(Double.valueOf(i));
            book.setDiscount(Double.valueOf(i));
            book.setPress("出版社" + i);
            book.setPublishTime(new Date());
            bookDao.insert(book);
        }*/
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
    }

    @org.junit.Test
    public void m2() throws Exception {
        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        // 创建session
        Session session = Session.getInstance(props);
        // 创建邮件
        Message msg = new MimeMessage(session);
        // 设置标题
        msg.setSubject("注册激活码");
        // 编辑内容
        msg.setContent("<div>\n" +
                "        <div>请点击下方链接进行激活</div>\n" +
                "        <a href='http://localhost:8080/register/code=1'>用户激活</a>\n" +
                "        </div>","text/html;charset=gbk");
        // 发送的邮箱地址
        msg.setFrom(new InternetAddress("2920602749@qq.com"));
        // 通过session得到transport对象
        Transport transport = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        transport.connect("smtp.qq.com", "2920602749@qq.com", "scvztmqxgtttdgda");
        // 发送邮件
        transport.sendMessage(msg, new Address[]{new InternetAddress("136290357@qq.com")});
        transport.close();
    }

}
