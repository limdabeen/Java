////자료구조(6007) 과제 1(60231222 임다빈)
package arcktect;
import java.util.Scanner;

public class DigitCheck {

    public static int countDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countDigits(n / 10);
    }

    public static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("정수를 입력하세요: ");
        int number = scanner.nextInt();
        

        int digits = countDigits(number);
        int sum = sumDigits(number);
        
        System.out.println(number + "의 자릿수: " + digits);
        System.out.println(number + "의 각 자릿수의 합: " + sum);
    }
}
