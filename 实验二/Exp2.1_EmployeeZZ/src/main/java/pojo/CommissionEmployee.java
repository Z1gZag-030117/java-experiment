package pojo;

import method.GetSalaryPerSale;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class CommissionEmployee extends Employee implements GetSalaryPerSale {
    public static double redEnvelope = 100;
    @Override
    public int salaryMethod() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int amountOfSale;
        System.out.print("请输入您的销售量：");
        amountOfSale = new Scanner(System.in).nextInt();
        if (amountOfSale < 0) {
            System.out.println("请输入正整数！");
            return salaryMethod();
        } else {
            salary = amountOfSale * salaryPerSale;
            if (month == birthMonth){
                salary += redEnvelope;
            }
            return salary;
        }
    }
}


