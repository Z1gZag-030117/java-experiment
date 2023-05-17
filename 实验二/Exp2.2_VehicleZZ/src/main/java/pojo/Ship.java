package pojo;

import inter.Common;

/**
 * @author Öì†´
 * @version 1.0
 */
public class Ship implements Common {
    @Override
    public double speed(double a, double b, double c) {
        return a+b*c;
    }
}
