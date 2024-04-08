package NNH;
import java.util.Scanner;

public class pr1 {
    public static void main(String[] args) {
        String text = readString();
        int[] histogram = createHistogram(text);
        printHistogram(histogram);
    }

    public static String readString() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.trim().equals(";")) // ; 문자를 입력하면 종료
                break;

            sb.append(line);
        }

        return sb.toString();
    }

    public static int[] createHistogram(String text) {
        int[] histogram = new int[26];

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercaseChar = Character.toLowerCase(c);
                histogram[lowercaseChar - 'a']++;
            }
        }

        return histogram;
    }

    public static void printHistogram(int[] histogram) {
        System.out.println("<히스토그램>");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + ": " + histogram[c - 'a'] + "-");
            for (int i = 0; i < histogram[c - 'a']; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
