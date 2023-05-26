package com.zz.pojo;

import lombok.Data;

/**
 * @author 朱喆
 * @version 1.0
 */
@Data
public class Subject {
    private int id;
    private String userAccount;
    private int num1;
    private int operator1;
    private int num2;
    private int operator2;
    private int num3;
    private int answer;
    public int misAnswer;
    public int num;//错误次数

    @Override
    public String toString() {
        String o1, o2;
        if (operator1 == 0) {
            o1 = "+";
        } else {
            o1 = "-";
        }
        if (operator2 == 0) {
            o2 = "+";
        } else {
            o2 = "-";
        }
        if (num3 == 0) {
            return num1 + o1 + num2 + "=" + answer;
        }
        return num1 + o1 + num2 + o2 + num3 + "=" + answer;
    }

    public String show() {
        return this.showMis() + "=";
    }

    public String showMis() {
        String o1, o2;
        if (operator1 == 0) {
            o1 = "+";
        } else {
            o1 = "-";
        }
        if (operator2 == 0) {
            o2 = "+";
        } else {
            o2 = "-";
        }
        if (num3 == 0) {
            return num1 + o1 + num2;
        }
        return num1 + o1 + num2 + o2 + num3;
    }
}
