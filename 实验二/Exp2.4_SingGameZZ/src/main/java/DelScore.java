import java.util.Arrays;

/**
 * @author �솴
 * @version 1.0
 */
public class DelScore {

    ComputerAver computerAver;
    public DelScore(ComputerAver computerAver) {
        this.computerAver=computerAver;
    }

    public void doDelete(double [] a) {
        Arrays.sort(a);//����a��С��������
        System.out.println("ȥ��һ����߷֣�"+a[a.length-1]+",");
        System.out.println("ȥ��һ����ͷ֣�"+a[0]+"��");
        double [] b = new double[a.length-2];
        for (int i = 1; i < a.length-1; i++) {
            b[i-1]=a[i];
        }
        computerAver.giveAver(b);
    }


}
