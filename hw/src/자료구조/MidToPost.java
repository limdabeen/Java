// 자료구조(6007) 과제 #5 (60231222 임다빈)
package 자료구조;

public class MidToPost {
    public static void main(String[] args) {
        System.out.println("<< 자료구조(6007) 과제 #5 (60231222 임다빈) >>");
        String str = "A-B+C/D";
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = "A/B-C*D";
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = "A-B*C+D/E-F";
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = "(A-B)*C-(D/(E+F))";
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");
    }

    private static String toPostExp(String s) {
        StringBuilder result = new StringBuilder();
        ListStack2 stack = new ListStack2();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // '(' 제거
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
