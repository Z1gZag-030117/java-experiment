package com.zz.service.impl;

import com.zz.pojo.Subject;
import com.zz.service.SecondGranderService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service("second")
public class SecondGranderServiceImpl implements SecondGranderService {
    Random rand = new Random();

    @Override
    public Subject subject1() {
        Subject subject = new Subject();
        int a = rand.nextInt(90) + 10; // 生成10-99的随机数
        int b = rand.nextInt(100 - a) + 1; // 生成1-100-a的随机数，确保不进位
        int answer = a + b;
        subject.setNum1(a);
        subject.setOperator1(0);
        subject.setNum2(b);
        subject.setAnswer(answer);
        return subject;
    }

    @Override
    public Subject subject2() {
        Subject subject = new Subject();
        Random rand = new Random();
        int a = rand.nextInt(90) + 10; // 生成10-99的随机数
        int b = rand.nextInt(a % 10 + 1) + 10 * rand.nextInt(a / 10); // 生成0到a个位数之间的随机数，确保不退位
        int answer = a - b;
        subject.setNum1(a);
        subject.setOperator1(1);
        subject.setNum2(b);
        subject.setAnswer(answer);
        return subject;
    }

    @Override
    public Subject subject3() {
        Subject subject = new Subject();
        Random rand = new Random();
        int a = rand.nextInt(80) + 10; // 生成10-99的随机数
        int b = rand.nextInt(100 - a) / 10 * 10 + rand.nextInt(10 - a % 10) + 10 - a % 10; // 生成0到100-a的随机数
        int answer = a + b;
        subject.setNum1(a);
        subject.setOperator1(0);
        subject.setNum2(b);
        subject.setAnswer(answer);
        return subject;
    }

    @Override
    public Subject subject4() {
        Subject subject = new Subject();
        Random rand = new Random();
        int a = rand.nextInt(90) + 10; // 生成10-99的随机数
        int b = rand.nextInt(a / 10) * 10 + rand.nextInt(10 - a % 10) + a % 10; // 生成0到100-a的随机数
        int answer = a - b;
        subject.setNum1(a);
        subject.setOperator1(1);
        subject.setNum2(b);
        subject.setAnswer(answer);
        return subject;
    }

    @Override
    public Subject subject5() {
        return null;
    }

    @Override
    public Subject subject6() {
        int i = new Random().nextInt(6) + 1;
        if (i == 1) {
            return this.subject1();
        } else if (i == 2) {
            return this.subject2();
        } else if (i == 3) {
            return this.subject3();
        } else if (i == 4) {
            return this.subject4();
        } else {
            return this.subject5();
        }
    }
}
