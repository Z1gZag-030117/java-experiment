import java.util.Arrays;

/**
 * @author 朱喆
 * @version 1.0
 */
public class DelScore {

    ComputerAver computerAver;
    public DelScore(ComputerAver computerAver) {
        this.computerAver=computerAver;
    }

    public void doDelete(double [] a) {
        Arrays.sort(a);//数组a从小到大排列
        System.out.println("去掉一个最高分："+a[a.length-1]+",");
        System.out.println("去掉一个最低分："+a[0]+"。");
        double [] b = new double[a.length-2];
        for (int i = 1; i < a.length-1; i++) {
            b[i-1]=a[i];
        }
        computerAver.giveAver(b);
    }


}
