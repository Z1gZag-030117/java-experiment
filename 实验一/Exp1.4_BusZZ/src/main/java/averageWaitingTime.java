import java.util.Random;

public class averageWaitingTime {
    public static void main(String[] args) {
        int numSimulations = 1000000;//测试1000000人的等待时间
        int totalWaitingTime = 0;
        Random random = new Random();
        for (int i = 0; i < numSimulations; i++) {
            int arrivalTime = 10 * 60 + random.nextInt(31); // 随机生成乘客到站时间 (10:00 to 10:30)
            int busScheduledTime = arrivalTime - arrivalTime % 60; // 公交车计划到站的小时数
            int delay = random.nextInt(31); // 随机生成公交车延迟到站的时间
            int busActualTime = busScheduledTime + 40 + delay; // 实际公交车到站时间

            if (busActualTime > arrivalTime) {
                totalWaitingTime += busActualTime - arrivalTime;
            } else {
                totalWaitingTime += 60 - (arrivalTime - busActualTime);
            }
        }
        double averageWaitingTime = (double) totalWaitingTime / numSimulations;
        System.out.printf("乘客平均等待时间为" + averageWaitingTime + "分钟");
    }
}