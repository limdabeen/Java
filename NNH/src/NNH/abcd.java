package NNH;

import java.util.Scanner;

public class abcd {
    public static String shuffleString(String input) {
        int length = input.length();
        StringBuilder shuffled = new StringBuilder();

        if (length % 2 == 0) {  // 짝수 길이의 문자열 처리
            int halfLength = length / 2;
            String firstHalf = input.substring(0, halfLength);
            String secondHalf = input.substring(halfLength);

            for (int i = 0; i < halfLength; i++) {
                shuffled.append(firstHalf.charAt(i));
                shuffled.append(secondHalf.charAt(i));
            }
        } else {  // 홀수 길이의 문자열 처리
            char lastChar = input.charAt(length - 1);
            String remainingChars = input.substring(0, length - 1);

            shuffled.append(lastChar);

            for (int i = remainingChars.length() - 1; i >= 0; i--) {
                shuffled.append(remainingChars.charAt(i));
            }
        }

        return shuffled.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요: ");
        String inputStr = scanner.nextLine();

        String shuffledStr = shuffleString(inputStr);
        System.out.println("섞인 문자열: " + shuffledStr);

        scanner.close();
    }
}
