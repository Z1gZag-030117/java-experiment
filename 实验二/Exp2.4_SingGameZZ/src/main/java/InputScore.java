import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class InputScore {
    DelScore del;

    InputScore(DelScore del) {
        this.del = del;
    }

    public void inputScore() {
        int count = 0;
        boolean f = false;
        while (!f) {
            try {
                System.out.println("请输入评委数量：");
                count = new Scanner(System.in).nextInt();
                f = true;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数！");
                f = false;
            }
        }
        System.out.println("请输入各个评委的分数：");
        double[] a = new double[count];
        for (int i = 0; i < count; i++) {
            a[i] = new Scanner(System.in).nextDouble();
        }
        del.doDelete(a);
    }

}
