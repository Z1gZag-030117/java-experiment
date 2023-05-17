
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
                System.out.println("ѡ��ͨ���� : ");
                vehicle = new Scanner(System.in).next();
                common= (Common) Class.forName("pojo." + vehicle).newInstance();
            }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
                System.out.println("class not found");
            }
        }

        System.out.print("���� A: ");
        s[0] = new Scanner(System.in).next();
        System.out.print("���� B: ");
        s[1] = new Scanner(System.in).next();
        System.out.print("���� C: ");
        s[2] = new Scanner(System.in).next();

        if (s[0] != null && s[0].matches("^[0-9]+$") && s[1] != null && s[1].matches("^[0-9]+$") && s[2] != null && s[2].matches("^[0-9]+$")) { //�ж�abc�Ƿ�������
            double a = Double.parseDouble(s[0]);//��abc���ɸ�����������λ����km/h��
            double b = Double.parseDouble(s[1]);
            double c = Double.parseDouble(s[2]);
            double v, t;//v�ٶȣ�tʱ��
                v = common.speed(a, b, c);// v = return��ֵ
                t = 1000 / v;
                System.out.println("ƽ���ٶȣ�" + v + " km/h");
                System.out.println("����ʱ�䣺" + t + " h ");
        } else {
            System.out.println("����������" + "\n");
        }
    }




}