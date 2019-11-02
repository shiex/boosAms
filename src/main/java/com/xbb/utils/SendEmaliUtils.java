package com.xbb.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author shiex-薛
 * @title: SendEmaliUtils
 * @projectName boosAms
 * @description: TODO
 * @date 2019\8\27 002720:52
 */
public class SendEmaliUtils {
    public static void SendMail(String emali, int userId) throws Exception{
        Properties props = new Properties();
        props.setProperty("mail.debug", "true"); // 开启debug调试
        props.setProperty("mail.smtp.auth", "true"); // 发送服务器需要身份验证
        props.setProperty("mail.host", "smtp.qq.com"); // 设置邮件服务器主机名
        props.setProperty("mail.transport.protocol", "smtp"); // 发送邮件协议名称

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
                "        <a href='http://127.0.0.1:8080/register?userId="
                + userId + "&code=" + FileUploadUtils.createUUID() + "'>用户激活</a>\n" +
                "        </div>","text/html;charset=gbk");
        // 发送的邮箱地址
        msg.setFrom(new InternetAddress("2920602749@qq.com"));
        // 通过session得到transport对象
        Transport transport = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        transport.connect("smtp.qq.com", "2920602749@qq.com", "scvztmqxgtttdgda");
        // 发送邮件
        transport.sendMessage(msg, new Address[]{new InternetAddress(emali)});
        transport.close();
    }


}
