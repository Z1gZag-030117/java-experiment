import javax.swing.*;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test extends JPanel {

    public static void main(String[] args) {
        new test();
    }

    public test(){
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        JPanel panel = new JPanel();
        JRadioButton jr1 = new JRadioButton("一年级");
        JRadioButton jr2 = new JRadioButton("二年级");
        ButtonGroup group = new ButtonGroup();
        group.add(jr1);
        group.add(jr2);
        panel.add(jr1);
        panel.add(jr2);
        frame.add(panel);
        frame.setVisible(true);
    }
}
