package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱喆
 * @version 1.0
 */
@Data
public abstract class Employee {
    public int id;
    public String name=null;
    public int birthYear;
    public int birthMonth;
    public static int salary;
    public abstract int salaryMethod();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                '}';
    }
}
