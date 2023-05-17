package pojo;

import inter.Common;

/**
 * @author Öì†´
 * @version 1.0
 */
public class Car007 implements Common {
    @Override
    public double speed(double a, double b, double c) {
        if(c==0)
        {
            System.out.println("³ıÊıÎª0");
            return  0;
        }
        else{
            return a*b/c;
        }
    }
}
