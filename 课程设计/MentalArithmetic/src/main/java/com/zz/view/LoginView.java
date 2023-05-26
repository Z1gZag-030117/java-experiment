package com.zz.view;


import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author 朱喆
 * @version 1.0
 */
public class LoginView {

    public LoginView() {
        init();
    }

    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService) context.getBean("userService");
        JFrame frame = new JFrame("小学数学口算软件");
        frame.setLayout(null);

        JLabel Label = new JLabel("欢迎来到小学数学口算软件！");
        Label.setFont(new Font("华文行楷", Font.PLAIN, 40));
        Label.setBounds(180, 70, 1500, 50);
        frame.add(Label);

        JLabel account = new JLabel("账号:");
        account.setBounds(250, 200, 100, 25);
        frame.add(account);


        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);


        JTextField accountNumberText = new JTextField();
        accountNumberText.setBounds(300, 200, 150, 25);
        frame.add(accountNumberText);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(300, 250, 150, 25);
        frame.add(passwordText);

        JButton buttonlogin = new JButton("登录");
        buttonlogin.setBounds(275, 300, 70, 25);
        frame.add(buttonlogin);

        JButton buttonRegisterUser = new JButton("注册用户");
        buttonRegisterUser.setBounds(375, 300, 90, 25);
        frame.add(buttonRegisterUser);

        JButton retrievePassword = new JButton("找回密码");
        retrievePassword.setBounds(500, 300, 90, 25);
        frame.add(retrievePassword);


        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonlogin.addActionListener(e -> {
            String accountNumber = accountNumberText.getText();
            String password = String.valueOf(passwordText.getPassword());
            User user = userService.login(accountNumber, password);
            if (user != null) {  //用户存在，登录成功，跳转页面
                //弹出登录成功的窗口
                JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
                //点击确定后会跳转到主窗口
                frame.setVisible(false);
                new UserView(user); //进入用户界面
            } else {  //登录失败，账号或者密码错误，弹出提示
                JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
                //清除密码框中的信息
                passwordText.setText("");
                //清除账号框中的信息
                accountNumberText.setText("");
            }
        });

        buttonRegisterUser.addActionListener(e -> {
            frame.setVisible(false);//关闭登录页面
            new RegisterView();//进入注册页面
        });

        retrievePassword.addActionListener(e -> {
            frame.setVisible(false);
            ForgotPasswordView forgotPasswordView = new ForgotPasswordView();
            forgotPasswordView.setVisible(true);
        });
    }


}
