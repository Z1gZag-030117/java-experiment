import java.util.Arrays;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Exp24_DelScoreZZ {

    Exp24_ComputerAverZZ computerAver;
    public Exp24_DelScoreZZ(Exp24_ComputerAverZZ computerAver) {
        this.computerAver=computerAver;
    }

    public void doDelete(double [] a) {
        Arrays.sort(a);
        System.out.println("去掉一个最高分："+a[a.length-1]+",");
        System.out.println("去掉一个最低分："+a[0]+"。");
        double [] b = new double[a.length-2];
        b=Arrays.copyOfRange(a,1,a.length-1);
        computerAver.giveAver(b);
    }


}
