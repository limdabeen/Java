//자료구조(6007) 과제 #4 (60231222 임다빈)
package 자료구조;

import java.util.Stack;

public class Paranthesis {

    public static void main(String[] args) {
        System.out.println("<< 자료구조(6007) 과제 #4 (60231222 임다빈) >>");

        String str = "{{(){()}}}";
        System.out.println(str);
        checkPaired(str);

        str = "{{(){()})()}";
        System.out.println("\n" + str);
        checkPaired(str);

        str = "({{}}()){({{}})()})";
        System.out.println("\n" + str);
        checkPaired(str);
    }

    private static void checkPaired(String s) {
        Stack<Character> stack = new Stack<>();
        int unmatchedIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ')') {
                if (stack.isEmpty()) {
                    unmatchedIndex = i;
                    break;
                }
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(')) {
                    unmatchedIndex = i;
                    break;
                }
            }
        }

        if (!stack.isEmpty() || unmatchedIndex != -1) {
            int printIndex = (unmatchedIndex == -1) ? s.length() : unmatchedIndex;
            System.out.println(s.substring(0, printIndex) + "^^^부터 괄호 쌍이 맞지 않습니다.");
        } else {
            System.out.println("괄호 쌍이 맞습니다.");
        }
    }
}
