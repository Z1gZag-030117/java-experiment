/**
 * @author �솴
 * @version 1.0
 */
public class Exp24_ComputerAverZZ {

    public void giveAver(double [] b) {
        double sum = 0;
        for (double v : b) {
            sum += v;
        }
        double aver = sum/b.length;
        System.out.println("ѡ�����÷�Ϊ��"+aver);
    }
}
