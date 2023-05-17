package pojo;

import method.GetSalaryPerHour;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class HourlyEmployee extends Employee implements GetSalaryPerHour {
    public static double redEnvelope = 100;
    public static int standardWorkTime = 160;
    int workHour;

    @Override
    public int salaryMethod() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        System.out.println("输入你本月工作时间: ");
        workHour = new Scanner(System.in).nextInt();
        if (workHour < 0){
            System.out.println("请输入正确的工作时间");
            return salaryMethod();
        }else {
            if (workHour>standardWorkTime){
                salary = salaryPerHour * standardWorkTime + overTimePerHour * (workHour - 160);
            }else {
                salary=salaryPerHour*workHour;
            }
            if (month== birthMonth){
                salary+=redEnvelope;
            }
            return salary;
        }
    }
}
