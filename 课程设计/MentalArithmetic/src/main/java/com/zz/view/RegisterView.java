package com.zz.view;

import com.zz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author �솴
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
        // ���ô��ڵı���ʹ�С
        frame.setTitle("ע��");
        frame.setSize(400, 300);

        // �������
        usernameLabel = new JLabel("�û���");
        accountLabel = new JLabel("�˺�");
        emailLabel = new JLabel("����");
        passwordLabel = new JLabel("����");
        confirmPasswordLabel = new JLabel("ȷ������");
        genderLabel = new JLabel("�Ա�");

        usernameField = new JTextField();
        accountField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        jb1 = new JRadioButton("һ�꼶");
        jb2 = new JRadioButton("���꼶");
        jb1.setSelected(true);
        genderGroup = new ButtonGroup();
        genderGroup.add(jb1);
        genderGroup.add(jb2);

        submitButton = new JButton("ע��");
        returnButton = new JButton("����");

        // ��������
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

        // ������
        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(returnButton);
        buttonPanel.add(submitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setBounds(400, 100, 800, 640);
        // ���ô��ڿɼ�
        frame.setVisible(true);


        //���ذ�ť
        returnButton.addActionListener(e -> {
            frame.setVisible(false);
            new LoginView();
        });

        //Ϊע�ᰴť���Ӽ�����
        submitButton.addActionListener(e -> {
            String gander;
            for (java.awt.Component c : panel.getComponents()) {
                if (c instanceof JRadioButton) {
                    ((JRadioButton) c).isSelected();
                }
            }
            gander = jb1.isSelected() ? "һ�꼶" : "���꼶";
            String account = accountField.getText();
            String name = usernameField.getText();
            String psd = String.valueOf(passwordField.getPassword());
            String cpsd = String.valueOf(confirmPasswordField.getPassword());
            String mailBoxNum = emailField.getText();
            boolean flag = userService.register(account, name, psd, cpsd, mailBoxNum, gander);
            if (flag) {
                JOptionPane.showMessageDialog(null, "ע��ɹ���", "ע��ɹ���", JOptionPane.WARNING_MESSAGE);
                frame.setVisible(false);
                new LoginView();
            } else {
            }
        });
    }

}
