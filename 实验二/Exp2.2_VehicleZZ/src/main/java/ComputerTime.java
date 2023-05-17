package expp4;

import inter.Common;

import java.lang.reflect.InvocationTargetException;

public class ComputerTime
{
    public static void main(String[] args)
    {
        System.out.println("��ͨ�����ǣ�"+args[0]);
        System.out.println("����A"+args[1]);
        System.out.println("����B"+args[2]);
        System.out.println("����C"+args[3]);
        double a=Double.parseDouble(args[1]);
        double b=Double.parseDouble(args[2]);
        double c=Double.parseDouble(args[3]);
        double v,t;                             // �����ٶȣ�ʱ��
        try
        {
            Common d=(Common) Class.forName("expp4."+args[0]).getDeclaredConstructor().newInstance();
            v=d.speed(a,b,c);
            t=1000/v;
            System.out.println("ƽ���ٶ�:"+v+"km/h");
            System.out.println("����ʱ��:"+t+"h");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            System.out.println("class not found");
        }
    }
}

