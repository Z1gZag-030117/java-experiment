import com.zz.pojo.Subject;

import java.util.Random;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test6 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test6 test6 = new test6();
            Subject subject = test6.subject1();
            System.out.println(subject.toString());
        }
    }

    private static Random random = new Random();

    public Subject subject1() {
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
}
