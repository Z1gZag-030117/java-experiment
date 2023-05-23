import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {
    private JLabel usernameLabel, accountLabel, emailLabel, passwordLabel, confirmPasswordLabel, genderLabel;
    private JTextField usernameField, accountField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    private JButton submitButton, returnButton;

    public RegisterForm() {
        // 设置窗口的标题和大小
        setTitle("注册");
        setSize(400, 300);

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

        maleButton = new JRadioButton("男");
        femaleButton = new JRadioButton("女");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        submitButton = new JButton("提交");
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
        panel.add(maleButton);
        panel.add(new JLabel());
        panel.add(femaleButton);

        // 添加组件
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(returnButton);
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 设置窗口可见
        setVisible(true);
    }
    public static void main(String[] args) {
        RegisterForm registerForm = new RegisterForm();
    }
}

