package com.zz.view;


import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * @author �솴
 * @version 1.0
 */
public class LoginView {

    public LoginView() {
        init();
    }

    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService) context.getBean("userService");
        JFrame frame = new JFrame("Сѧ��ѧ�������");
        frame.setLayout(null);

        JLabel Label = new JLabel("��ӭ����Сѧ��ѧ���������");
        Label.setFont(new Font("�����п�", Font.PLAIN, 40));
        Label.setBounds(180, 70, 1500, 50);
        frame.add(Label);

        JLabel account = new JLabel("�˺�:");
        account.setBounds(250, 200, 100, 25);
        frame.add(account);


        JLabel passwordStr = new JLabel("����:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);


        JTextField accountNumberText = new JTextField();
        accountNumberText.setBounds(300, 200, 150, 25);
        frame.add(accountNumberText);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(300, 250, 150, 25);
        frame.add(passwordText);

        JButton buttonlogin = new JButton("��¼");
        buttonlogin.setBounds(275, 300, 70, 25);
        frame.add(buttonlogin);

        JButton buttonRegisterUser = new JButton("ע���û�");
        buttonRegisterUser.setBounds(375, 300, 90, 25);
        frame.add(buttonRegisterUser);

        JButton retrievePassword = new JButton("�һ�����");
        retrievePassword.setBounds(500, 300, 90, 25);
        frame.add(retrievePassword);


        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonlogin.addActionListener(e -> {
            String accountNumber = accountNumberText.getText();
            String password = String.valueOf(passwordText.getPassword());
            User user = userService.login(accountNumber, password);
            if (user != null) {  //�û����ڣ���¼�ɹ�����תҳ��
                //������¼�ɹ��Ĵ���
                JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
                //���ȷ�������ת��������
                frame.setVisible(false);
                new UserView(user); //�����û�����
            } else {  //��¼ʧ�ܣ��˺Ż���������󣬵�����ʾ
                JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
                //���������е���Ϣ
                passwordText.setText("");
                //����˺ſ��е���Ϣ
                accountNumberText.setText("");
            }
        });

        buttonRegisterUser.addActionListener(e -> {
            frame.setVisible(false);//�رյ�¼ҳ��
            new RegisterView();//����ע��ҳ��
        });

        retrievePassword.addActionListener(e -> {
            frame.setVisible(false);
            ForgotPasswordView forgotPasswordView = new ForgotPasswordView();
            forgotPasswordView.setVisible(true);
        });
    }


}
