/**
 * @author �솴
 * @version 1.0
 */
public class ComputerAver {

    public void giveAver(double [] b) {
        double sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        double aver = sum/b.length;
        System.out.println("ѡ�����÷�Ϊ��"+aver);
    }


}
