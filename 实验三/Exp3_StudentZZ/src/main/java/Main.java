
import pojo.Student;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static String idStr; //Ҫд���ļ�������ת��ΪString����
    public static String gradeStr;
    public static String name;

    public static void main(String[] args) throws IOException {
        System.out.print("������¼��ѧ��������");
        int stu_num = get_num();
        Student[] students = new Student[stu_num]; //����һ��ѧ�����飬����ѧ����Ϣ
        for (int i = 0; i < stu_num; i++) {
            getInformation();
            for (int j = 0; j < i; j++) {
                while (idStr.equals(students[j].getId())) {
                    System.out.println("ѧ���ظ������������룡");
                    getInformation();
                }
            }
            Student s = new Student(idStr, name, gradeStr);
            students[i] = s;
        }
        File file = new File("Student.txt"); //����һ���ļ�����file
        writeFile(file, students);
        ReadFile(file);
    }

    public static int get_num() //��ȡ¼��ѧ����Ϣ������
    {
        try {
            Scanner sc = new Scanner(System.in);
            int stu_num = sc.nextInt();
            if (stu_num < 0) {
                System.out.println("��������������");
                return get_num();
            }
            return stu_num;
        } catch (InputMismatchException e) {
            System.out.println("������������");
            return get_num();
        }
    }

    public static void getInformation() //��ȡ��Ϣ
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("������ѧ�ţ�");
            int id = sc.nextInt();
            System.out.print("�������꼶��");
            int grade = sc.nextInt();
            System.out.print("������������");
            name = sc.next();

            Pattern pattern = Pattern.compile(".*\\d+.*");
            idStr = String.valueOf(id); //int����ת��ΪString����
            gradeStr = String.valueOf(grade);
            if (pattern.matcher(name).matches()) {
                System.out.println("���ֲ���Ϊ���֣����������룡");
                getInformation();
            }
        } catch (InputMismatchException e) {
            System.out.println("����Ƿ������������룡");
            getInformation();
        }
    }

    public static void writeFile(File file, Student[] students) throws IOException //д���ļ�
    {
        FileWriter fw = new FileWriter(file, false); //Ҫ����֮ǰ�����ݣ�ѡ��false
        BufferedWriter bw = new BufferedWriter(fw);

        for (Student s : students) {
            bw.write(s.getInfo());
            bw.newLine(); //д��һ��ѧ������Ϣ����
        }
        bw.close();
        fw.close();
    }

    public static void ReadFile(File file) throws IOException //��ȡ�ļ�
    {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.printf(s); //���д�ӡ�����printf��Ϊ�����\t
        }
        br.close();
        fr.close();
    }
}

