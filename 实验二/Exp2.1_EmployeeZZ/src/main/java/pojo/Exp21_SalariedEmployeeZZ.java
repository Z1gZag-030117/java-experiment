package pojo;

import method.Exp21_GetSalaryPerMonthZZ;

import java.util.Calendar;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Exp21_SalariedEmployeeZZ extends Employee implements Exp21_GetSalaryPerMonthZZ {
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
