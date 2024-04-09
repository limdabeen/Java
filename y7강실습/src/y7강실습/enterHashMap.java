package y7강실습;
import java.util.*;

public class enterHashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> javaScore = new HashMap<String, Integer>();

        Scanner scanner = new Scanner(System.in);

        // Get input from the user for student names and scores
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.next();

            System.out.print("Enter score for " + name + ": ");
            int score = scanner.nextInt();

            javaScore.put(name, score);
        }

        // Close the scanner after getting all input
        scanner.close();

        System.out.println("HashMap의 요소 개수 :" + javaScore.size());

        Set<String> keys = javaScore.keySet();
        Iterator<String> it = keys.iterator();
        int sum = 0;
        int min = Integer.MAX_VALUE; // 초기 최소값 설정
        int max = Integer.MIN_VALUE; // 초기 최대값 설정

        while (it.hasNext()) {
            String name = it.next();
            int score = javaScore.get(name);
            System.out.println(name + " : " + score);

            // 최소값과 최대값 갱신
            if (min > score) {
                min = score;
            }
            if (max < score) {
                max = score;
            }

            // 평균 계산을 위해 총 합 계산
            sum += score;
        }

        System.out.println("최소값은 " + min);
        System.out.println("최대값은 " + max);
        System.out.println("평균은 " + (double) sum / javaScore.size());
    }
}
