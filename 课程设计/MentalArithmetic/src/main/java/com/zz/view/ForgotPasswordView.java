package com.zz.view;

import com.zz.pojo.Code;
import com.zz.service.CodeService;
import com.zz.utils.SendMailUtils;
import com.zz.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
public class ForgotPasswordView extends JFrame {
    private JLabel titleLabel, emailLabel, codeLabel;
    private JTextField emailField, codeTextFile;
    private JButton submitButton, cancelButton, codeButton;


    public ForgotPasswordView() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CodeService codeService = (CodeService) context.getBean("codeService");
        System.out.println(codeService);
        String code = ValidateCodeUtils.generateValidateCode(4).toString();
        String from = "1286549860@qq.com";
        String text = "【口算软件】验证码 " + code + " 用于口算软件身份验证，请勿泄露和转发。如非本人操作，请忽略此短信。";
        String subject = "【口算软件】";

        // 设置窗口标题和大小
        setTitle("找回密码");
        setSize(400, 200);

        // 创建并设置标题标签
        titleLabel = new JLabel("请输入您的注册邮箱");
        titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        // 创建并设置邮箱标签和文本框
        emailLabel = new JLabel("邮箱：");
        emailField = new JTextField(20);
        codeLabel = new JLabel("验证码：");
        codeTextFile = new JTextField(20);

        // 创建并设置提交和取消按钮
        submitButton = new JButton("提交");
        codeButton = new JButton("确认验证码");
        cancelButton = new JButton("取消");

        // 设置布局管理器为网格布局，并将组件添加到面板中
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        panel.add(titleLabel);
        panel.add(new JLabel(""));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(codeLabel);
        panel.add(codeTextFile);
        panel.add(submitButton);
        panel.add(codeButton);
        panel.add(cancelButton);


        // 将面板添加到窗口中，并设置窗口关闭时的操作
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置提交按钮的点击事件，实现邮件发送功能
        submitButton.addActionListener(e -> {
            String email = emailField.getText();
            // TODO: 实现邮件发送功能，将验证码发送到该邮箱
            try {
                SendMailUtils.sendMail(from, email, text, subject);
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }
            Code c = new Code();
            c.setCodeNum(code);
            c.setEmail(email);
            //将验证码和邮箱存入数据库
            codeService.saveCode(c);
            JOptionPane.showMessageDialog(this, "验证码已发送到您的邮箱，请查收并输入验证码");
        });

        codeButton.addActionListener(e -> {
            String emile = emailField.getText();
            //根据邮箱从数据库中查找验证码
            String code1 = codeService.selectCode(emile);
            if (code1==null||code1.equals(code)){
                JOptionPane.showMessageDialog(this, "验证码错误！");
            }else {
                JOptionPane.showMessageDialog(this, "找回密码成功！");
            }
        });

        // 设置取消按钮的点击事件，关闭窗口
        cancelButton.addActionListener(e -> {
            dispose();
            new LoginView();
        });

        // 设置窗口居中显示
        setLocationRelativeTo(null);
        //setVisible(true);
    }

}