package NNH; //히스토그램
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        int[] numbers = readNumbers();
        int[] histogram = createHistogram(numbers);
        printHistogram(histogram);
    }

    public static int[] readNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("숫자를 10개를 입력하세요.");

        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        return numbers;
    }

    public static int[] createHistogram(int[] numbers) {
        // 범위는 최대 100까지라고 가정하였습니다.
        // 필요에 따라 범위를 조정해주시면 됩니다.

        int[] histogram = new int[10]; // 각 인덱스는 해당 숫자의 빈도수를 저장합니다.

        for (int number : numbers) {
            if (number >= 0 && number <= 100) { // 숫자 범위를 확인합니다.
                histogram[number / 10]++; // 각 구간에 해당하는 히스토그램 값 증가
            }
        }

        return histogram;
    }

    public static void printHistogram(int[] histogram) {
        System.out.println("<히스토그램>");

        for (int i = 0; i < histogram.length; i++) {
            int start = i * 10;
            int end = start + 9;

            System.out.print(start + "~" + end + ": ");

            for (int j = 0; j < histogram[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
