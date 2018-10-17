package com.xzy.utils;


import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailUtils {
        public static String createEmail(String emailAdress) throws Exception {
            Properties config = new Properties();
            Session session = Session.getInstance(config,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1850547134@qq.com", "zsdsmbmwwzsmbcba");
                }
            });
            //1 创建邮件发送对象
            MimeMessage m = new MimeMessage(session);
            //2 设置发件人邮件
            Address from = new InternetAddress("1850547134@qq.com","蜜雪客服","utf-8");
            m.setFrom(from);
            //3 设置收件人的地址
            m.setRecipient(RecipientType.TO, new InternetAddress(emailAdress));
            //设置主题
            m.setSubject("蜜雪休闲室", "utf-8");
            // 设置正文
            String code=Code.getCode();
            m.setContent("尊敬的蜜雪休闲室用户：您好!您正在尝试修改密码！\n" +
                   "您的验证码是："+code, "text/plain;charset=utf-8");
            //设置邮件发送时间
            m.setSentDate(new Date());
            // 确认操作
            m.saveChanges();
            session.setDebug(true);
            config = session.getProperties();
            config.put("mail.transport.protocol", "smtp");
            config.put("mail.smtp.host", "smtp.qq.com");
            config.put("mail.smtp.port", "25");
            config.put("mail.smtp.auth", "true");
            Transport.send(m);
            return code;
        }
}



