import java.util.Random;

public class WaitingTime {
    public static void main(String[] args) {
        int n = 100000; // 假设每天有100000位旅客到达本站
        int totalWaitTime = 0; // 总等待时间
        int count = 0; // 到达本站的旅客数

        for (int i = 0; i < n; i++) {
            // 随机生成旅客到达本站的时刻
            int minute = new Random().nextInt(30);
            int second = new Random().nextInt(60);
            int arrivalTime = 10 * 3600 + minute * 60 + second;

            // 计算等待时间
            int timeDiff = 0;
            for (int j = 6; j <= 17; j++) { // 遍历每一个发车时刻
                int departureTime = j * 3600;
                int waitTime = 0;
                if (arrivalTime < departureTime) { // 旅客到达时间在发车时间之前
                    waitTime = departureTime - arrivalTime - 40; // 等待时间为发车时间减去到达时间再减去40分钟
                } else { // 旅客到达时间在发车时间之后
                    waitTime = 24 * 3600 - arrivalTime + departureTime - 40; // 等待时间为第二天的发车时间减去到达时间再加上今天的发车时间再减去40分钟
                }
                if (waitTime > 70) { // 等待时间超过70分钟，说明车已经开走了，不需要再计算后面的发车时刻
                    break;
                }
                timeDiff = waitTime;
            }

            // 累加等待时间
            if (timeDiff > 0) {
                totalWaitTime += timeDiff;
                count++;
            }
        }

        // 计算平均等待时间
        double avgWaitTime = totalWaitTime / (double) count;

        System.out.println("平均等待时间为：" + avgWaitTime + "分钟");
    }
}