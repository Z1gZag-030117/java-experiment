
import inter.Common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeTime {

    public static void main(String[] args) {
        String[] s = new String[3];
        String vehicle;
        Common common = null;

        while(common == null){
            try {
                System.out.println("选择交通工具 : ");
                vehicle = new Scanner(System.in).next();
                common= (Common) Class.forName("pojo." + vehicle).newInstance();
            }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
                System.out.println("class not found");
            }
        }

        System.out.print("参数 A: ");
        s[0] = new Scanner(System.in).next();
        System.out.print("参数 B: ");
        s[1] = new Scanner(System.in).next();
        System.out.print("参数 C: ");
        s[2] = new Scanner(System.in).next();

        if (s[0] != null && s[0].matches("^[0-9]+$") && s[1] != null && s[1].matches("^[0-9]+$") && s[2] != null && s[2].matches("^[0-9]+$")) { //判断abc是否是整数
            double a = Double.parseDouble(s[0]);//把abc换成浮点型数（单位都是km/h）
            double b = Double.parseDouble(s[1]);
            double c = Double.parseDouble(s[2]);
            double v, t;//v速度，t时间
                v = common.speed(a, b, c);// v = return的值
                t = 1000 / v;
                System.out.println("平均速度：" + v + " km/h");
                System.out.println("运行时间：" + t + " h ");
        } else {
            System.out.println("不是整数！" + "\n");
        }
    }




}