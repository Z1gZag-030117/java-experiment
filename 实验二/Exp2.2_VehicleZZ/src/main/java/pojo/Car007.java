package pojo;

import inter.Exp22_CommonZZ;

/**
 * @author �솴
 * @version 1.0
 */
public class Car007 implements Exp22_CommonZZ {
    @Override
    public double speed(double a, double b, double c) {
        if(c==0) {
            System.out.println("����Ϊ0");
            return  0;
        }
        else{
            return a*b/c;
        }
    }
}
