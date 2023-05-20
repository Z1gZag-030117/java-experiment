
import pojo.Exp3_StudentZZ;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exp3_MainZZ {
    public static String idStr; //要写入文件，所以转换为String类型
    public static String gradeStr;
    public static String name;

    public static void main(String[] args) throws IOException {
        System.out.print("请输入录入学生人数：");
        int stuNum = getNum();
        Exp3_StudentZZ[] students = new Exp3_StudentZZ[stuNum]; //创建一个学生数组，保存学生信息
        for (int i = 0; i < stuNum; i++) {
            getInformation();
            for (int j = 0; j < i; j++) {
                while (idStr.equals(students[j].getId())) {
                    System.out.println("学号重复，请重新输入！");
                    getInformation();
                }
            }
            Exp3_StudentZZ s = new Exp3_StudentZZ(idStr, name, gradeStr);
            students[i] = s;
        }
        File filePath = new File("Student.txt"); //创建一个文件对象file
        writeFile(filePath, students);
        readFile(filePath);
    }

    public static int getNum() { //获取录入学生信息的人数
        try {
            Scanner sc = new Scanner(System.in);
            int stuNum = sc.nextInt();
            if (stuNum < 0) {
                System.out.println("请输入正整数！");
                return getNum();
            }
            return stuNum;
        } catch (InputMismatchException e) {
            System.out.println("请输入整数！");
            return getNum();
        }
    }

    public static void getInformation() {  //获取信息
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入学号：");
            int id = sc.nextInt();
            System.out.print("请输入年级：");
            int grade = sc.nextInt();
            System.out.print("请输入姓名：");
            name = sc.next();
            Pattern patternName = Pattern.compile(".*\\d+.*");
/*
            匹配任意字符（.表示匹配任意单个字符，*表示匹配前面的字符任意次），
            然后匹配至少一个数字（\d+表示匹配一个或多个数字），
            最后再匹配任意字符（.*表示匹配前面的字符任意次）。
            因此，这个正则表达式可以用来匹配包含至少一个数字的任意字符串。
*/
            idStr = String.valueOf(id); //int类型转换为String类型
            gradeStr = String.valueOf(grade);
            if (patternName.matcher(name).matches()) {
                System.out.println("名字不能为数字，请重新输入！");
                getInformation();
            }
        } catch (InputMismatchException e) {
            System.out.println("输入非法，请重新输入！");
            getInformation();
        }
    }

    public static void writeFile(File filePath, Exp3_StudentZZ[] students) throws IOException { //写入文件
        FileWriter fw = new FileWriter(filePath, false); //要覆盖之前的内容，选择false
        BufferedWriter bw = new BufferedWriter(fw);
        for (Exp3_StudentZZ s : students) {
            bw.write(s.toString());
            bw.newLine(); //写入一个学生的信息后换行
        }
        bw.close();
        fw.close();
    }

    public static void readFile(File filePath) throws IOException {  //读取文件
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s); //逐行打印结果，printf是为了输出\t
        }
        br.close();
        fr.close();
    }
}

