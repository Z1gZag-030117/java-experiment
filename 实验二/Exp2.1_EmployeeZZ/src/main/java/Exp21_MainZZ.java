import pojo.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Exp21_MainZZ {

    public static int choice;

    //选择菜单
    public static int choice() {
        try {
            choice = new Scanner(System.in).nextInt();
            if (choice < 0 || choice > 4) {
                System.out.println("请输入整数0-4！");
                return choice();
            } else if (choice == 0)
                System.exit(0);
            else
                return choice;
        } catch (InputMismatchException e) {
            System.out.println("请输入整数！");
            return choice();
        }
        return -1;
    }

    //获取工号
    public static int get_number() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入工号：");
        try {
            int number = sc.nextInt();
            if (number <= 0) {
                System.out.println("请输入正整数！");
                return get_number();
            }
            return number;
        } catch (InputMismatchException e) {
            System.out.println("请输入整数！");
            return get_number();
        }
    }

    //获取姓名
    public static String get_name() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = sc.next();
        Pattern pattern = Pattern.compile(".*\\d+.*");
        if (pattern.matcher(name).matches()) {
            System.out.println("不能输入数字");
            return get_name();
        }
        return name;
    }

    //获取出生年份
    public static int get_birthYear() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入出生年份：");
        try {
            int birthYear = sc.nextInt();
            if (birthYear < 1900 || birthYear > 2021) {
                System.out.println("输入有误，请重新输入！");
                return get_birthYear();
            }
            return birthYear;
        } catch (InputMismatchException e) {
            System.out.println("请输入合法数字！");
            return get_birthYear();
        }
    }

    //获取出生月份
    public static int get_birthMonth() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入出生月份：");
        try {
            int birthMonth = sc.nextInt();
            if (birthMonth < 1 || birthMonth > 12) {
                System.out.println("输入有误，请重新输入！");
                return get_birthMonth();
            }
            return birthMonth;
        } catch (InputMismatchException e) {
            System.out.println("请输合法入数字！");
            return get_birthMonth();
        }
    }


    public static void show(int i) {
        Employee[] Data = new Employee[4];
        Data[0] = new Exp21_SalariedEmployeeZZ();
        Data[1] = new Exp21_HourlyEmployeeZZ();
        Data[2] = new Exp21_CommissionEmployeeZZ();
        Data[3] = new Exp21_BasePlusCommissionEmployeeZZ();

        Data[i].id = get_number();
        Data[i].name = get_name();
        Data[i].birthYear = get_birthYear();
        Data[i].birthMonth = get_birthMonth();
        System.out.println("处理结果：");
        System.out.println("工号：" + Data[i].id);
        System.out.println("姓名：" + Data[i].name);
        System.out.println("出生年月：" + Data[i].birthYear + "年" + Data[i].birthMonth + "月");
        System.out.println("工资：" + Data[i].salaryMethod());

    }

    public static void main(String[] args) {
        Employee[] Data = new Employee[4];
        Data[0] = new Exp21_SalariedEmployeeZZ();
        Data[1] = new Exp21_HourlyEmployeeZZ();
        Data[2] = new Exp21_CommissionEmployeeZZ();
        Data[3] = new Exp21_BasePlusCommissionEmployeeZZ();

        System.out.println("请输入员工类型：1.领固定月薪 2.计时取酬 3.按销售额提成 4.带底薪并按销售额提成 0.退出");
        choice = choice();
        switch (choice) {
            case 1: {
                show(0);
                break;
            }
            case 2: {
                show(1);
                break;
            }
            case 3: {
                show(2);
                break;
            }
            case 4: {
                show(3);
                break;
            }
            default:
                System.out.println("error");
        }
    }
}
