package com.zz.view;

import com.zz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author 朱喆
 * @version 1.0
 */

public class RegisterView {

//    @Autowired
//    private UserService userService;
    //UserService userService = new UserServiceImpl();

    public RegisterView() {
        init();
    }

    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService) context.getBean("userService");
        JLabel usernameLabel, accountLabel, emailLabel, passwordLabel, confirmPasswordLabel, genderLabel;
        JTextField usernameField, accountField, emailField;
        JPasswordField passwordField, confirmPasswordField;
        JRadioButton jb1, jb2;
        ButtonGroup genderGroup;
        JButton submitButton, returnButton;
        JFrame frame = new JFrame();
        // 设置窗口的标题和大小
        frame.setTitle("注册");
        frame.setSize(400, 300);

        // 创建组件
        usernameLabel = new JLabel("用户名");
        accountLabel = new JLabel("账号");
        emailLabel = new JLabel("邮箱");
        passwordLabel = new JLabel("密码");
        confirmPasswordLabel = new JLabel("确认密码");
        genderLabel = new JLabel("性别");

        usernameField = new JTextField();
        accountField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        jb1 = new JRadioButton("一年级");
        jb2 = new JRadioButton("二年级");
        jb1.setSelected(true);
        genderGroup = new ButtonGroup();
        genderGroup.add(jb1);
        genderGroup.add(jb2);

        submitButton = new JButton("注册");
        returnButton = new JButton("返回");

        // 创建布局
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(genderLabel);
        panel.add(jb1);
        panel.add(new JLabel());
        panel.add(jb2);

        // 添加组件
        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(returnButton);
        buttonPanel.add(submitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setBounds(400, 100, 800, 640);
        // 设置窗口可见
        frame.setVisible(true);


        //返回按钮
        returnButton.addActionListener(e -> {
            frame.setVisible(false);
            new LoginView();
        });

        //为注册按钮增加监听器
        submitButton.addActionListener(e -> {
            String gander;
            for (java.awt.Component c : panel.getComponents()) {
                if (c instanceof JRadioButton) {
                    ((JRadioButton) c).isSelected();
                }
            }
            gander = jb1.isSelected() ? "一年级" : "二年级";
            String account = accountField.getText();
            String name = usernameField.getText();
            String psd = String.valueOf(passwordField.getPassword());
            String cpsd = String.valueOf(confirmPasswordField.getPassword());
            String mailBoxNum = emailField.getText();
            boolean flag = userService.register(account, name, psd, cpsd, mailBoxNum, gander);
            if (flag) {
                JOptionPane.showMessageDialog(null, "注册成功！", "注册成功！", JOptionPane.WARNING_MESSAGE);
                frame.setVisible(false);
                new LoginView();
            } else {
            }
        });
    }

}
