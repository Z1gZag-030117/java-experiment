package com.zz.view;

import com.zz.pojo.Code;
import com.zz.service.CodeService;
import com.zz.utils.SendMailUtils;
import com.zz.utils.ValidateCodeUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        String text = "�������������֤�� " + code + " ���ڿ�����������֤������й¶��ת������Ǳ��˲���������Դ˶��š�";
        String subject = "�����������";

        // ���ô��ڱ���ʹ�С
        setTitle("�һ�����");
        setSize(400, 200);

        // ���������ñ����ǩ
        titleLabel = new JLabel("����������ע������");
        titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));

        // ���������������ǩ���ı���
        emailLabel = new JLabel("���䣺");
        emailField = new JTextField(20);
        codeLabel = new JLabel("��֤�룺");
        codeTextFile = new JTextField(20);

        // �����������ύ��ȡ����ť
        submitButton = new JButton("�ύ");
        codeButton = new JButton("ȷ����֤��");
        cancelButton = new JButton("ȡ��");

        // ���ò��ֹ�����Ϊ���񲼾֣����������ӵ������
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


        // �������ӵ������У������ô��ڹر�ʱ�Ĳ���
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // �����ύ��ť�ĵ���¼���ʵ���ʼ����͹���
        submitButton.addActionListener(e -> {
            String email = emailField.getText();
            // TODO: ʵ���ʼ����͹��ܣ�����֤�뷢�͵�������
            try {
                SendMailUtils.sendMail(from, email, text, subject);
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }
            Code c = new Code();
            c.setCodeNum(code);
            c.setEmail(email);
            //����֤�������������ݿ�
            codeService.saveCode(c);
            JOptionPane.showMessageDialog(this, "��֤���ѷ��͵��������䣬����ղ�������֤��");
        });

        codeButton.addActionListener(e -> {
            String emile = emailField.getText();
            //������������ݿ��в�����֤��
            String code1 = codeService.selectCode(emile);
            if (code1==null||code1.equals(code)){
                JOptionPane.showMessageDialog(this, "��֤�����");
            }else {
                JOptionPane.showMessageDialog(this, "�һ�����ɹ���");
            }
        });

        // ����ȡ����ť�ĵ���¼����رմ���
        cancelButton.addActionListener(e -> {
            dispose();
            new LoginView();
        });

        // ���ô��ھ�����ʾ
        setLocationRelativeTo(null);
        //setVisible(true);
    }

}