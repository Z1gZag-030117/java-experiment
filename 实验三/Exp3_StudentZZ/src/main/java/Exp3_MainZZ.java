
import pojo.Exp3_StudentZZ;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exp3_MainZZ {
    public static String idStr; //Ҫд���ļ�������ת��ΪString����
    public static String gradeStr;
    public static String name;

    public static void main(String[] args) throws IOException {
        System.out.print("������¼��ѧ��������");
        int stuNum = getNum();
        Exp3_StudentZZ[] students = new Exp3_StudentZZ[stuNum]; //����һ��ѧ�����飬����ѧ����Ϣ
        for (int i = 0; i < stuNum; i++) {
            getInformation();
            for (int j = 0; j < i; j++) {
                while (idStr.equals(students[j].getId())) {
                    System.out.println("ѧ���ظ������������룡");
                    getInformation();
                }
            }
            Exp3_StudentZZ s = new Exp3_StudentZZ(idStr, name, gradeStr);
            students[i] = s;
        }
        File filePath = new File("Student.txt"); //����һ���ļ�����file
        writeFile(filePath, students);
        readFile(filePath);
    }

    public static int getNum() { //��ȡ¼��ѧ����Ϣ������
        try {
            Scanner sc = new Scanner(System.in);
            int stuNum = sc.nextInt();
            if (stuNum < 0) {
                System.out.println("��������������");
                return getNum();
            }
            return stuNum;
        } catch (InputMismatchException e) {
            System.out.println("������������");
            return getNum();
        }
    }

    public static void getInformation() {  //��ȡ��Ϣ
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("������ѧ�ţ�");
            int id = sc.nextInt();
            System.out.print("�������꼶��");
            int grade = sc.nextInt();
            System.out.print("������������");
            name = sc.next();
            Pattern patternName = Pattern.compile(".*\\d+.*");
/*
            ƥ�������ַ���.��ʾƥ�����ⵥ���ַ���*��ʾƥ��ǰ����ַ�����Σ���
            Ȼ��ƥ������һ�����֣�\d+��ʾƥ��һ���������֣���
            �����ƥ�������ַ���.*��ʾƥ��ǰ����ַ�����Σ���
            ��ˣ����������ʽ��������ƥ���������һ�����ֵ������ַ�����
*/
            idStr = String.valueOf(id); //int����ת��ΪString����
            gradeStr = String.valueOf(grade);
            if (patternName.matcher(name).matches()) {
                System.out.println("���ֲ���Ϊ���֣����������룡");
                getInformation();
            }
        } catch (InputMismatchException e) {
            System.out.println("����Ƿ������������룡");
            getInformation();
        }
    }

    public static void writeFile(File filePath, Exp3_StudentZZ[] students) throws IOException { //д���ļ�
        FileWriter fw = new FileWriter(filePath, false); //Ҫ����֮ǰ�����ݣ�ѡ��false
        BufferedWriter bw = new BufferedWriter(fw);
        for (Exp3_StudentZZ s : students) {
            bw.write(s.toString());
            bw.newLine(); //д��һ��ѧ������Ϣ����
        }
        bw.close();
        fw.close();
    }

    public static void readFile(File filePath) throws IOException {  //��ȡ�ļ�
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s); //���д�ӡ�����printf��Ϊ�����\t
        }
        br.close();
        fr.close();
    }
}

