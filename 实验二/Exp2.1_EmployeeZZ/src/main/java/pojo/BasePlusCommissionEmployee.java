package pojo;

import method.GetBaseSalary;
import method.GetSalaryPerSale;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class BasePlusCommissionEmployee extends CommissionEmployee implements GetSalaryPerSale, GetBaseSalary {
    public static int redEnvelope = 100;

    public int salaryMethod() {
            int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            int amountOfSale;
            System.out.print("请输入您的销售量：");
            amountOfSale = new Scanner(System.in).nextInt();
            if (amountOfSale < 0) {
                System.out.println("请输入正整数！");
                return salaryMethod();
            } else {
                salary = baseSalary + amountOfSale * salaryPerSale;
                if (month == birthMonth)
                    salary += redEnvelope;
                return salary;
            }
    }
}
