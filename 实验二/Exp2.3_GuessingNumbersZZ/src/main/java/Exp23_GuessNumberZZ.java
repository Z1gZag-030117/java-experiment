import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exp23_GuessNumberZZ {
    public static int choice;
    public static int point = 0;

    //�ж������Ƿ�Ϊ1��2
    public void judge() {
        try {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1: break;
                case 2: System.exit(0);
                default: {
                    System.out.println("������1 or 2��");
                    judge();
                }
            }
        }
        catch (InputMismatchException e) {   //������(С�����ַ�)�ᱻ����
            System.out.println("����������(1 or 2)!");
            judge();
        }
    }

    //����÷�
    public int point(int count) { //count����cancel���ݵĴ���
        if (count == 1) {  //һ�β��е�3��
            point += 3;
            return point;
        } else if (count == 2) {  //�ڶ��β��е�2��
            point += 2;
            return point;
        } else if (count == 3) {  //�����ε�1��
            point += 1;
            return point;
        } else {              //����û�в��п�2��
            point -= 2;
            return point;
        }
    }

    //��Ϸ����
    public int start(int num, int count) {
        try {
            Scanner sc = new Scanner(System.in);
            int inputNumber;
            System.out.println("��������µ���(0-99)��");
            inputNumber = sc.nextInt();
            if (inputNumber < 0 || inputNumber > 99) {   //�����������ֵķ�Χ
                System.out.println("������[0,99]���ڵ�����!");
                return start(num, count);
            } else {
                if (inputNumber < num) {
                    count++;
                    if (count == 3) {   //countΪ3ʱ����������������ȷ����
                        System.out.println("���ζ�û�в��У���Ϸ������");
                        System.out.println("��ȷ���֣�"+num);
                        count++;
                        return count;
                    }
                    System.out.println("̫С�ˣ����������룺");
                    return start(num, count);
                } else if (inputNumber > num) {
                    count++;
                    if (count == 3) {
                        System.out.println("���ζ�û�в��У���Ϸ������");
                        System.out.println("��ȷ���֣�"+num);
                        count++;
                        return count;
                    }
                    System.out.println("̫���ˣ����������룺");
                    return start(num, count);
                } else {
                    count++;
                    System.out.println("��ϲ�㣬�¶��ˣ�");
                    return count;
                }
            }
        } catch (InputMismatchException | NegativeArraySizeException e) {
            System.out.println("������������!");
            count = start(num, count);
            return count;
        }
    }

    //�����Ĳ�������
    public void guess(int num) {
        int count = 0;
        count = start(num, count);
        point = point(count);
        System.out.println("��ǰ�÷�: "+point);
    }

    public static void main(String[] args) {
        System.out.println("1.��ʼ 2.�˳�");
        System.out.println("��ʼ������"+point);
        Exp23_GuessNumberZZ begin = new Exp23_GuessNumberZZ();
        begin.judge();
        int num;
        num = new Random().nextInt(99);
        //System.out.println(num);
        begin.guess(num);
        do {
            System.out.println("1.����һ�� 2.�˳�");
            begin.judge();
            num = new Random().nextInt(99);
            begin.guess(num);
        }while (choice != 2);
    }
}

