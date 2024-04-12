package 중간고사;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        int a[] = new int[10];
        int[] counts = new int[10]; // 각 범위(0~9, 10~19, ..., 90~99)의 개수를 저장할 배열
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 10개 입력하세요 (0부터 99 사이): ");

        for (int i = 0; i < 10; ) {
            int k = scanner.nextInt();
            if (k >= 0 && k <= 99) {
                a[i] = k;
                i++;
            } else {
                System.out.println("0부터 99 사이의 숫자만 입력하세요.");
            }
        }

        // 각 숫자의 범위에 따른 개수 세기
        for (int num : a) {
            int range = num / 10; // 숫자를 10으로 나누어 범위 구하기
            counts[range]++;
        }

        // 결과 출력
        for (int j = 0; j < 10; j++) {
            System.out.print(j * 10 + " ~ " + (j * 10 + 9) + ": ");
            for (int star = 0; star < counts[j]; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
