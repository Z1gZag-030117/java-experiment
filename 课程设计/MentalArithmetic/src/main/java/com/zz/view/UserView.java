package com.zz.view;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.FirstGranderService;
import com.zz.service.SecondGranderService;
import com.zz.service.SubjectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * @author �솴
 * @version 1.0
 */

public class UserView {


    public UserView(User user) {
        init(user);
    }

    public void init(User user) {
        System.out.println("1.��ʼ����ѵ��      2.�鿴����");
        System.out.print("�������ѡ��");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1) {
            System.out.print("������Ҫѵ����������");
            int num = new Scanner(System.in).nextInt(); // ��Ŀ����
            if (user.getGander().equals("һ�꼶")) {
                trainFirstGrade(num, user);
            } else {
                trainSecondGrade(num, user);
            }
        } else {
            new MisSubjectView(user);
        }

    }

    private static void trainFirstGrade(int num, User user) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FirstGranderService first = (FirstGranderService) context.getBean("first");
        SubjectService subjectService = (SubjectService) context.getBean("subject");
        System.out.println("1. 10���ڼӼ�����1������");
        System.out.println("2. 10���ڼӼ�����2������");
        System.out.println("3. 10-20�ļӼ�����1�������2������");
        System.out.println("4. �ۺ�ѵ�������������������ͣ�");
        System.out.print("��ѡ��ѵ������:");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        int misNum = 0;
        Subject[] subject = new Subject[num]; //����num����Ŀ
        switch (type) {
            case 1: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = first.subject1();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject1(num, misNum, subject);
            }
            case 2: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = first.subject2();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject1(num, misNum, subject);
            }
            case 3: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = first.subject3();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject1(num, misNum, subject);
            }
            case 4: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = first.subject4();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject1(num, misNum, subject);
            }
        }
        new UserView(user);
    }

    private static void misSubject1(int num, int misNum, Subject[] subject) {
        System.out.println("---------------");
        System.out.println("һ������" + misNum + "��,�ֱ��ǣ�");
        for (int i = 0; i < num; i++) {
            if (subject[i].num != 0) {
                System.out.println(subject[i].showMis() + "=" + subject[i].misAnswer + " -->(" + subject[i].getAnswer() + ")");
            }
        }
    }


    private static void trainSecondGrade(int num, User user) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SecondGranderService second = (SecondGranderService) context.getBean("second");
        SubjectService subjectService = (SubjectService) context.getBean("subject");
        System.out.println("��ѡ��ѵ�����ͣ�");
        System.out.println("1. 100���ڲ���λ�ӷ�");
        System.out.println("2. 100���ڲ���λ����");
        System.out.println("3. 100���ڽ�λ�ӷ�");
        System.out.println("4. 100������λ����");
        System.out.println("5. �ۺ�ѵ�������������������ͣ�");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        Subject[] subject = new Subject[num]; //����num����Ŀ
        int misNum = 0;
        switch (type) {
            case 1: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject1();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject2(num, misNum, subject);
                new UserView(user);
            }
            case 2: {

                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject2();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject2(num, misNum, subject);
                new UserView(user);
            }
            case 3: {

                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject3();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject2(num, misNum, subject);
                new UserView(user);
            }
            case 4: {

                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject4();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject2(num, misNum, subject);
                new UserView(user);
            }
            case 5: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject5();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //���մ�
                    if (answer != subject[i].getAnswer()) {  //����
                        misNum++;
                        subject[i].num++;
                        subject[i].misAnswer = answer;
                        subject[i].setUserAccount(user.getAccount());
                        subjectService.save(subject[i], user);
                    }
                }
                misSubject2(num, misNum, subject);
                new UserView(user);
            }
        }
        new UserView(user);
    }

    private static void misSubject2(int num, int misNum, Subject[] subject) {
        System.out.println("---------------");
        System.out.println("һ������" + misNum + "��,�ֱ��ǣ�");
        for (int i = 0; i < num; i++) {
            if (subject[i].num != 0) {
                System.out.println(subject[i].showMis() + "=" + subject[i].misAnswer + " -->(" + subject[i].getAnswer() + ")");
            }
        }
    }

}


