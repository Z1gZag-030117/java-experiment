import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exp23_GuessNumberZZ {
    public static int choice;
    public static int point = 0;


    public void judge1or2() {
        try {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1: break;
                case 2: System.exit(0);
                default: {
                    System.out.println("请输入1 or 2：");
                    judge1or2();
                }
            }
        }
        catch (InputMismatchException e) {   //非整数(小数、字符)会被捕获
            System.out.println("请输入整数(1 or 2)!");
            judge1or2();
        }
    }

    //计算得分
    public int point(int count) { //count计算cancel数据的次数
        if (count == 1) {  //一次猜中得3分
            point += 3;
            return point;
        } else if (count == 2) {  //第二次猜中得2分
            point += 2;
            return point;
        } else if (count == 3) {  //其三次得1分
            point += 1;
            return point;
        } else {              //三次没有猜中扣2分
            point -= 2;
            return point;
        }
    }

    //游戏部分
    public int start(int num, int count) {
        try {
            Scanner sc = new Scanner(System.in);
            int inputNumber;
            System.out.println("请输入你猜的数(0-99)：");
            inputNumber = sc.nextInt();
            if (inputNumber < 0 || inputNumber > 99) {   //控制输入数字的范围
                System.out.println("请输入[0,99]以内的整数!");
                return start(num, count);
            }
            else {
                if (inputNumber < num) {
                    count++;
                    if (count == 3) {   //count为3时结束猜数并公布正确数字
                        System.out.println("三次都没有猜中，游戏结束！");
                        System.out.println("正确数字："+num);
                        count++;
                        return count;
                    }
                    System.out.println("太小了，请重新输入：");
                    return start(num, count);
                }
                else if (inputNumber > num) {
                    count++;
                    if (count == 3) {
                        System.out.println("三次都没有猜中，游戏结束！");
                        System.out.println("正确数字："+num);
                        count++;
                        return count;
                    }
                    System.out.println("太大了，请重新输入：");
                    return start(num, count);
                }
                else {
                    count++;
                    System.out.println("恭喜你，猜对了！");
                    return count;
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("请输入整数!");
            count = start(num, count);
            return count;
        }
    }

    //完整的猜数流程
    public void guess(int num) {
        int count = 0;
        count = start(num, count);
        point = point(count);
        System.out.println("当前得分: "+point);
    }

    public static void main(String[] args) {
        System.out.println("1.开始 2.退出");
        System.out.println("初始分数："+point);
        Exp23_GuessNumberZZ begin = new Exp23_GuessNumberZZ();
        begin.judge1or2();
        int num;
        num = new Random().nextInt(99); //创建0-99的随机数
//        System.out.println("生成的随机数(测试)："+num);
        begin.guess(num);
        do {
            System.out.println("1.再来一次 2.退出");
            begin.judge1or2();
            num = new Random().nextInt(99);
//            System.out.println("生成的随机数(测试)："+num);
            begin.guess(num);
        }while (choice != 2);
    }
}

