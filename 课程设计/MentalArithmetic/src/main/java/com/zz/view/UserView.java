package com.zz.view;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.FirstGranderService;
import com.zz.service.SecondGranderService;
import com.zz.service.SubjectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */

public class UserView {


    public UserView(User user) {
        init(user);
    }

    public void init(User user) {
        System.out.println("1.开始口算训练      2.查看错题");
        System.out.print("输入你的选择：");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1) {
            System.out.print("输入想要训练的题数：");
            int num = new Scanner(System.in).nextInt(); // 题目数量
            if (user.getGander().equals("一年级")) {
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
        System.out.println("1. 10以内加减法：1步计算");
        System.out.println("2. 10以内加减法：2步计算");
        System.out.println("3. 10-20的加减法：1步计算和2步计算");
        System.out.println("4. 综合训练（包括以上所有类型）");
        System.out.print("请选择训练类型:");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        int misNum = 0;
        Subject[] subject = new Subject[num]; //产生num道题目
        switch (type) {
            case 1: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = first.subject1();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
        System.out.println("一共错了" + misNum + "题,分别是：");
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
        System.out.println("请选择训练类型：");
        System.out.println("1. 100以内不进位加法");
        System.out.println("2. 100以内不退位减法");
        System.out.println("3. 100以内进位加法");
        System.out.println("4. 100以内退位减法");
        System.out.println("5. 综合训练（包括以上所有类型）");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        Subject[] subject = new Subject[num]; //产生num道题目
        int misNum = 0;
        switch (type) {
            case 1: {
                for (int i = 0; i < num; i++) {
                    System.out.print(i + 1 + ". ");
                    subject[i] = second.subject1();
                    System.out.print(subject[i].show());
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
                    int answer = scanner.nextInt(); //接收答案
                    if (answer != subject[i].getAnswer()) {  //错误
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
        System.out.println("一共错了" + misNum + "题,分别是：");
        for (int i = 0; i < num; i++) {
            if (subject[i].num != 0) {
                System.out.println(subject[i].showMis() + "=" + subject[i].misAnswer + " -->(" + subject[i].getAnswer() + ")");
            }
        }
    }

}


