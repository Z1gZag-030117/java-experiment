import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author �솴
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
                System.out.println("��������ί������");
                count = new Scanner(System.in).nextInt();
                f = true;
            } catch (InputMismatchException e) {
                System.out.println("������������");
                f = false;
            }
        }
        System.out.println("�����������ί�ķ�����");
        double[] a = new double[count];
        for (int i = 0; i < count; i++) {
            a[i] = new Scanner(System.in).nextDouble();
        }
        del.doDelete(a);
    }

}
