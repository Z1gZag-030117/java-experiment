package pojo;

import inter.Common;

/**
 * @author �솴
 * @version 1.0
 */
public class Plane implements Common {
    @Override
    public double speed(double a, double b, double c) {
        return  a+b+c;
    }
}
