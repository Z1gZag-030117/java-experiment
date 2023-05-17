
import inter.Common;

import java.util.Scanner;

public class ComputeTime {

    public static void main(String[] args)   //����Ķ����ַ���
    {
        String[] s=new String[4];
        String vehicle;

        System.out.println("1.Car007   2.Plane   3.Ship");
        System.out.println("ѡ��ͨ���� : ");
        vehicle = new Scanner(System.in).next();
        System.out.print(" ���� A: " );
        s[1]=new Scanner(System.in).next();
        System.out.print(" ���� B: " );
        s[2]=new Scanner(System.in).next();
        System.out.print(" ���� C: " );
        s[3]=new Scanner(System.in).next();

        if (s[1] != null && s[1].matches("^[0-9]+$") && s[2] != null && s[2].matches("^[0-9]+$") && s[3] != null && s[3].matches("^[0-9]+$")) { //�ж�abc�Ƿ�������
            double a = Double.parseDouble(s[1]);      //��abc���ɸ�����������λ����km/h��
            double b = Double.parseDouble(s[2]);
            double c = Double.parseDouble(s[3]);
            double v, t;                                 //�����ٶȡ�ʱ��

            try {
                Common d = (Common) Class.forName("pojo." + vehicle).newInstance();   //dΪͨ��pojo����Ľӿڣ������args[0]
                v = d.speed(a, b, c);            // v = return��ֵ
                t = 1000 / v;
                System.out.println("ƽ���ٶȣ�" + v + " km/h");
                System.out.println("����ʱ�䣺" + t + " h ");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {   //�Ҳ����� ���� or ʵ���� ���� or �Ƿ����� ����  ������
                System.out.println("class not found");
            }
        }   // if ���Ž���
        else {
            System.out.println("����������" + "\n");
        }  // if - else ����

    }

}