import com.zz.pojo.Subject;

import java.util.Random;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test5 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            test5 test5 = new test5();
            Subject subject = test5.subject1();
            System.out.println(subject.toString());
        }
    }

    private static Random random = new Random();

    public Subject subject1() {
        Subject subject = new Subject();
        Random rand = new Random();
        int a;
        int b;
        int c;
        int op1;
        int op2;
        int answer;
        do {
            a = rand.nextInt(11); // 生成0-10的随机数
            b = rand.nextInt(11 - a); // 生成0-10-a的随机数，确保结果不大于10
            c = rand.nextInt(11 - a - b); // 生成0-10-a-b的随机数，确保结果不大于10
            op1 = rand.nextInt(2); // 第一步操作符，0表示加法，1表示减法
            op2 = rand.nextInt(2); // 第二步操作符，0表示加法，1表示减法
            if (op1 == 0) {
                answer = a + b;
            } else {
                answer = a - b;
            }
            if (op2 == 0) {
                answer = answer + c;
            } else {
                answer = answer - c;
            }
        } while (c == 0 || answer < 0);
        subject.setNum1(a);
        subject.setNum2(b);
        subject.setNum3(c);
        subject.setOperator1(op1);
        subject.setOperator2(op2);
        if (op1 == 0) {
            answer = a + b;
        } else {
            answer = a - b;
        }
        if (op2 == 0) {
            answer = answer + c;
        } else {
            answer = answer - c;
        }
        subject.setAnswer(answer);
        return subject;
    }
}
