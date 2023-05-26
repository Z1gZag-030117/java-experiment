package com.zz.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author 朱喆
 * @version 1.0
 */
public class SendMailUtils {

    public static void sendMail(String from,String to,String text,String subject) throws MessagingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmail.xml");
        JavaMailSender javaMailSender= (JavaMailSender) context.getBean("zz");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,false,"UTF-8");
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setText(text);
        messageHelper.setSubject(subject);
        javaMailSender.send(mimeMessage);
    }

    //带附件
    public static void sendMailWithAttachment(String from,String to,String text,String subject,String attachment,String file) throws MessagingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmail.xml");
        JavaMailSender javaMailSender= (JavaMailSender) context.getBean("zz");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setText(text);
        messageHelper.setSubject(subject);
        messageHelper.addAttachment(attachment,new File(file));
        javaMailSender.send(mimeMessage);
    }

}
