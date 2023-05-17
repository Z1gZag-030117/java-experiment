import java.util.Random;

public class Exp3 {

    public static void main(String[] args) {
        int[][] array = new int[5][5];
        Random rand = new Random();
        int sumOuter = 0; //外圈数字之和
        int maxDiagonal = 0; //对角线最大数
        int maxDiagonalRow = 0; //x坐标
        int maxDiagonalCol = 0; //y坐标

        // 生成随机整数并存储到二维数组中
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = rand.nextInt(100);
                array[i][j] = num;
                if (i == 0 || i == 4 || j == 0 || j == 4) {  //判断这个数知否在外圈
                    sumOuter += num;
                }
                if (i == j && num > maxDiagonal) {  //当i==j时说明这个数字在对角线
                    maxDiagonal = num;
                    maxDiagonalRow = i;
                    maxDiagonalCol = j;
                }
            }
        }

        // 输出二维数组
        System.out.println("输出二维数组:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        // 输出最外一圈元素之和
        System.out.println("最外圈数字之和: " + sumOuter);

        // 输出主对角线中最大元素的值及其位置
        System.out.println("主对角线中最大元素: " + maxDiagonal);
        System.out.println("主对角线中最大元素的值及其位置: (" + maxDiagonalRow + ", " + maxDiagonalCol + ")");
    }
}