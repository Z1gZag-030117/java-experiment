import java.util.Arrays;
import java.util.Random;

public class Exp2 {
    public static void main(String[] args) {
        int[] original = new int[20];
        for (int i = 0; i < 20; i++) {
            original[i] = i + 1;
        }
        System.out.println("原数组：" + Arrays.toString(original));

        int[] shuffled = shuffle(original);
        System.out.println("乱序后的数组：" + Arrays.toString(shuffled));
    }

    public static int[] shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
