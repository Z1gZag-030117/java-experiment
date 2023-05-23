
package word;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Severity;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class www extends JFrame{
    JButton btn;
    private static JPanel pane1 ;
    public www() {
        JFrame frame = new JFrame("单选框");   //顶层容器
        frame.setSize(200, 200);          //窗口大小
        pane1 = new JPanel();       //中间容器
        //单选框
        JRadioButton c1 = new JRadioButton("草莓",true);//创建单选框，true为默认选中，不需要可去掉
        JRadioButton c2 = new JRadioButton("柠檬");//创建单选框
        JRadioButton c3 = new JRadioButton("香蕉");//创建单选框
        ButtonGroup group = new ButtonGroup(); //创建单选框按钮组
        JLabel l1 = new JLabel("模式:");
        group.add(c1);//将单选框组件加入单选框按钮组，否则两个都可以选择
        group.add(c2);
        group.add(c3);
        pane1.add(l1);
        pane1.add(c1);//将单选框组件加入面板
        pane1.add(c2);
        pane1.add(c3);
        //按钮
        btn = new JButton("你选择的是:");
        pane1.add(btn);//将按钮加入面板

        frame.add(pane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);//显示

        btn.addActionListener(new ActionListener() {//按钮监听

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String info ="";
                //通过面板属性名获取到该面板上的所有组件
                System.out.println(info);
                for(Component c:pane1.getComponents()){
                    if(c instanceof JRadioButton){
                        if(((JRadioButton) c).isSelected()){
                            info += ((JRadioButton)c).getText();
                        }
                    }
                }
                System.out.println(info);//输出选择的单选框文本
                JOptionPane.showMessageDialog(null, "你选择了"+info);
            }
        });
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new www();
    }

}


