
import inter.Common;

import java.util.Scanner;

public class ComputeTime {

    public static void main(String[] args)   //输入的都是字符串
    {
        String[] s=new String[4];
        String vehicle;

        System.out.println("1.Car007   2.Plane   3.Ship");
        System.out.println("选择交通工具 : ");
        vehicle = new Scanner(System.in).next();
        System.out.print(" 参数 A: " );
        s[1]=new Scanner(System.in).next();
        System.out.print(" 参数 B: " );
        s[2]=new Scanner(System.in).next();
        System.out.print(" 参数 C: " );
        s[3]=new Scanner(System.in).next();

        if (s[1] != null && s[1].matches("^[0-9]+$") && s[2] != null && s[2].matches("^[0-9]+$") && s[3] != null && s[3].matches("^[0-9]+$")) { //判断abc是否是整数
            double a = Double.parseDouble(s[1]);      //把abc换成浮点型数（单位都是km/h）
            double b = Double.parseDouble(s[2]);
            double c = Double.parseDouble(s[3]);
            double v, t;                                 //定义速度、时间

            try {
                Common d = (Common) Class.forName("pojo." + vehicle).newInstance();   //d为通过pojo包里的接口，输入的args[0]
                v = d.speed(a, b, c);            // v = return的值
                t = 1000 / v;
                System.out.println("平均速度：" + v + " km/h");
                System.out.println("运行时间：" + t + " h ");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {   //找不到类 例外 or 实例化 例外 or 非法访问 例外  ？？？
                System.out.println("class not found");
            }
        }   // if 括号结束
        else {
            System.out.println("不是整数！" + "\n");
        }  // if - else 结束

    }

}