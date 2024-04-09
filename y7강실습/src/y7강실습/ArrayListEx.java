package y7강실습;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        // 문자열만 삽입 가능한 ArrayList 컬렉션 생성
        ArrayList<String> names = new ArrayList<>();
        // 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("이름을 입력하세요>> ");
            String name = scanner.next(); // 키보드로부터 이름 입력
            names.add(name); // ArrayList 컬렉션에 삽입
        }

        // ArrayList에 들어 있는 모든 이름 출력
        System.out.print("입력된 이름들: ");
        for (String name : names) {
            System.out.print(name + " ");
        }

        // 가장 긴 이름 및 가장 짧은 이름 출력
        String shortestName = names.get(0);
        String longestName = names.get(0);
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
            if (name.length() < shortestName.length()) {
                shortestName = name;
            }
        }
        System.out.println("\n가장 긴 이름은: " + longestName);
        System.out.println("가장 짧은 이름은: " + shortestName);

        // 스캐너 닫기
        scanner.close();
    }
}
