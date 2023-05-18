
import pojo.Student;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static String idStr; //要写入文件，所以转换为String类型
    public static String gradeStr;
    public static String name;

    public static void main(String[] args) throws IOException {
        System.out.print("请输入录入学生人数：");
        int stu_num = get_num();
        Student[] students = new Student[stu_num]; //创建一个学生数组，保存学生信息
        for (int i = 0; i < stu_num; i++) {
            getInformation();
            for (int j = 0; j < i; j++) {
                while (idStr.equals(students[j].getId())) {
                    System.out.println("学号重复，请重新输入！");
                    getInformation();
                }
            }
            Student s = new Student(idStr, name, gradeStr);
            students[i] = s;
        }
        File file = new File("Student.txt"); //创建一个文件对象file
        writeFile(file, students);
        ReadFile(file);
    }

    public static int get_num() //获取录入学生信息的人数
    {
        try {
            Scanner sc = new Scanner(System.in);
            int stu_num = sc.nextInt();
            if (stu_num < 0) {
                System.out.println("请输入正整数！");
                return get_num();
            }
            return stu_num;
        } catch (InputMismatchException e) {
            System.out.println("请输入整数！");
            return get_num();
        }
    }

    public static void getInformation() //获取信息
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入学号：");
            int id = sc.nextInt();
            System.out.print("请输入年级：");
            int grade = sc.nextInt();
            System.out.print("请输入姓名：");
            name = sc.next();

            Pattern pattern = Pattern.compile(".*\\d+.*");
            idStr = String.valueOf(id); //int类型转换为String类型
            gradeStr = String.valueOf(grade);
            if (pattern.matcher(name).matches()) {
                System.out.println("名字不能为数字，请重新输入！");
                getInformation();
            }
        } catch (InputMismatchException e) {
            System.out.println("输入非法，请重新输入！");
            getInformation();
        }
    }

    public static void writeFile(File file, Student[] students) throws IOException //写入文件
    {
        FileWriter fw = new FileWriter(file, false); //要覆盖之前的内容，选择false
        BufferedWriter bw = new BufferedWriter(fw);

        for (Student s : students) {
            bw.write(s.getInfo());
            bw.newLine(); //写入一个学生的信息后换行
        }
        bw.close();
        fw.close();
    }

    public static void ReadFile(File file) throws IOException //读取文件
    {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.printf(s); //逐行打印结果，printf是为了输出\t
        }
        br.close();
        fr.close();
    }
}

