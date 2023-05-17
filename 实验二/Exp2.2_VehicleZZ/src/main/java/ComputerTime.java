package expp4;

import inter.Common;

import java.lang.reflect.InvocationTargetException;

public class ComputerTime
{
    public static void main(String[] args)
    {
        System.out.println("交通工具是："+args[0]);
        System.out.println("参数A"+args[1]);
        System.out.println("参数B"+args[2]);
        System.out.println("参数C"+args[3]);
        double a=Double.parseDouble(args[1]);
        double b=Double.parseDouble(args[2]);
        double c=Double.parseDouble(args[3]);
        double v,t;                             // 定义速度，时间
        try
        {
            Common d=(Common) Class.forName("expp4."+args[0]).getDeclaredConstructor().newInstance();
            v=d.speed(a,b,c);
            t=1000/v;
            System.out.println("平均速度:"+v+"km/h");
            System.out.println("运行时间:"+t+"h");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            System.out.println("class not found");
        }
    }
}

