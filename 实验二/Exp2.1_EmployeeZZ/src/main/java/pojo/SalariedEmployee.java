package pojo;

import method.GetSalaryPerMonth;

import java.util.Calendar;

/**
 * @author 朱喆
 * @version 1.0
 */
public class SalariedEmployee extends Employee implements GetSalaryPerMonth {
    public static int redEnvelope = 100;

    @Override
    public int salaryMethod() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (month == birthMonth) {
            salary = salaryPerMonth + redEnvelope;
        }else {
            salary=salaryPerMonth;
        }
        return salary;
    }
}
