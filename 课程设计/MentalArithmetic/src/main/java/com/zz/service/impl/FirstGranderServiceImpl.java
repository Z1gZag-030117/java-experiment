package com.zz.service.impl;

import com.zz.pojo.Subject;
import com.zz.service.FirstGranderService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service("first")
public class FirstGranderServiceImpl implements FirstGranderService {
    private static Random random = new Random();


    @Override
    public Subject subject1() {
        int num1, num2, operator1;
        do {
            num1 = random.nextInt(10) + 1; // 生成1-10之间的随机数
            num2 = random.nextInt(10) + 1; // 生成1-10之间的随机数
            operator1 = random.nextInt(2); // 生成0或1，用于表示加法或减法
        } while ((num1 + num2 > 10 && operator1 == 0));
        Subject subject = new Subject();
        if (operator1 == 0) {   //加法
            subject.setNum1(num1);
            subject.setOperator1(operator1);
            subject.setNum2(num2);
            subject.setAnswer(num1 + num2);
        } else {
            if (num1 < num2) { // 确保结果不为负数
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            subject.setNum1(num1);
            subject.setOperator1(operator1);
            subject.setNum2(num2);
            subject.setAnswer(num1 - num2);
        }
        return subject;
    }

    @Override
    public Subject subject2() {
        Subject subject = new Subject();
        Random rand = new Random();
        int num1,num2,num3,op1,op2,answer;
        do {
            num1 = rand.nextInt(11); // 生成0-10的随机数
            num2 = rand.nextInt(11 - num1); // 生成0-10-a的随机数，确保结果不大于10
            num3 = rand.nextInt(11 - num1 - num2); // 生成0-10-a-b的随机数，确保结果不大于10
            op1 = rand.nextInt(2); // 第一步操作符，0表示加法，1表示减法
            op2 = rand.nextInt(2); // 第二步操作符，0表示加法，1表示减法
            if (op1 == 0) {
                answer = num1 + num2;
            } else {
                answer = num1 - num2;
            }
            if (op2 == 0) {
                answer = answer + num3;
            } else {
                answer = answer - num3;
            }
        } while (num3 == 0 || answer < 0);
        subject.setNum1(num1);
        subject.setNum2(num2);
        subject.setNum3(num3);
        subject.setOperator1(op1);
        subject.setOperator2(op2);
        if (op1 == 0) {
            answer = num1 + num2;
        } else {
            answer = num1 - num2;
        }
        if (op2 == 0) {
            answer = answer + num3;
        } else {
            answer = answer - num3;
        }
        subject.setAnswer(answer);
        return subject;
}

    @Override
    public Subject subject3() {
        int num1, num2, operator1;
        do {
            num1 = random.nextInt(20) + 1; // 生成1-10之间的随机数
            num2 = random.nextInt(20) + 1; // 生成1-10之间的随机数
            operator1 = random.nextInt(2); // 生成0或1，用于表示加法或减法
        } while ((num1 + num2 > 20 && operator1 == 0)||(num1 + num2 < 10 && operator1 == 0)||(num1 - num2 < 10 && operator1 == 1));
        Subject subject = new Subject();
        if (operator1 == 0) {   //加法
            subject.setNum1(num1);
            subject.setOperator1(operator1);
            subject.setNum2(num2);
            subject.setAnswer(num1 + num2);
        } else {
            if (num1 < num2) { // 确保结果不为负数
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            subject.setNum1(num1);
            subject.setOperator1(operator1);
            subject.setNum2(num2);
            subject.setAnswer(num1 - num2);
        }
        return subject;
    }

    @Override
    public Subject subject4() {
        int i = new Random().nextInt(4) + 1;
        if (i==1){
            return this.subject1();
        }else if (i==2){
            return this.subject2();
        }else {
            return this.subject3();
        }
    }

}
