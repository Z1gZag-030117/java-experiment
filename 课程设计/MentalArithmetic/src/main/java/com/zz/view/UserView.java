package com.zz.view;

import com.zz.service.FirstGranderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserView {


    public UserView(String grader) {
        init(grader);
    }

    public void init(String grander) {
        System.out.println("输入想要训练的题数：");
        int num = new Scanner(System.in).nextInt();
        if (grander.equals("一年级")) {
            trainFirstGrade(num);
        } else {
            trainSecondGrade(num);
        }
    }

    private static void trainFirstGrade(int num) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FirstGranderService first = (FirstGranderService) context.getBean("first");
        System.out.println("请选择训练类型：");
        System.out.println("1. 10以内加减法：1步计算");
        System.out.println("2. 10以内加减法：2步计算");
        System.out.println("3. 10-20的加减法：1步计算");
        System.out.println("4. 10-20的加减法：2步计算");
        System.out.println("5. 综合训练（包括以上所有类型）");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        switch (type) {
            case 1: {

            }
            case 2: {

            }
            case 3: {

            }
            case 4: {

            }
            case 5: {

            }

        }
    }

    private static void trainSecondGrade(int num) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FirstGranderService second = (FirstGranderService) context.getBean("second");
        System.out.println("请选择训练类型：");
        System.out.println("1. 100以内不进位加法");
        System.out.println("2. 100以内不退位减法");
        System.out.println("3. 100以内进位加法");
        System.out.println("4. 100以内退位减法");
        System.out.println("5. 100 以内连加连减");
        System.out.println("6. 综合训练（包括以上所有类型）");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        switch (type) {
            case 1: {

            }
            case 2: {

            }
            case 3: {

            }
            case 4: {

            }
            case 5: {

            }

        }
    }

}
