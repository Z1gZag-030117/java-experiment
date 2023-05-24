import com.zz.pojo.Subject;

import java.util.Random;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test7 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test7 test7 = new test7();
            Subject subject = test7.subject1();
            System.out.println(subject.toString());
        }
    }

    public Subject subject1() {
        Subject subject = new Subject();
        Random rand = new Random();
        int a = rand.nextInt(90) + 10; // 生成10-99的随机数
        int b = rand.nextInt(a/10)*10+rand.nextInt(10-a%10)+a%10; // 生成0到100-a的随机数
        int answer = a - b;
        subject.setNum1(a);
        subject.setOperator1(1);
        subject.setNum2(b);
        subject.setAnswer(answer);
        return subject;
    }



}
