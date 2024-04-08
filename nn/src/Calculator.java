import java.util.Scanner; 

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char operator;
        double operand1, operand2, result;
        boolean continueCalculations = true;

        while (continueCalculations) {
            System.out.println(" 연산자와 피연산자를 입력하세요 ");
            
            if (scanner.hasNextDouble()) {
                operand1 = scanner.nextDouble();
                operator = scanner.next().charAt(0);
                operand2 = scanner.nextDouble();

                switch (operator) {
                    case '+':
                        result = operand1 + operand2;
                        System.out.println("결과: " + result);
                        break;
                    case '-':
                        result = operand1 - operand2;
                        System.out.println("결과: " + result);
                        break;
                    case '*':
                        result = operand1 * operand2;
                        System.out.println("결과: " + result);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                        } else {
                            result = operand1 / operand2;
                            System.out.println("결과: " + result);
                        }
                        break;
                    case '%':
                        if (operand2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                        } else {
                            result = operand1 % operand2;
                            System.out.println("결과: " + result);
                        }
                        break;
                    case '?':
                        if (operand2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                        } else {
                            result = (int) operand1 / (int) operand2;
                            System.out.println("결과: " + result);
                        }
                        break;
                    default:
                        System.out.println("잘못된 연산자입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 실수를 입력하세요.");
                scanner.nextLine(); 
            }

            System.out.print(">>계속 하시겠습니까? (y/n): ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("y")) {
                continueCalculations = false;
            }
        }

    
        scanner.close();
    }
}
