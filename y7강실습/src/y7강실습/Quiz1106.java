package y7강실습;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Quiz1106 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("** 포인트 관리 프로그램입니다 **");
        HashMap<String, Integer> hm = new HashMap<>();

        while (true) {
            System.out.print("이름과 포인트 입력 >> ");
            String name = sc.next();
            if (name.equals("exit")) break;
            
            int score = sc.nextInt();

            if (hm.containsKey(name)) {
                hm.put(name, score + hm.get(name));
            } else {
                hm.put(name, score);
            }

            Set<String> keySet = hm.keySet();
            Iterator<String> it = keySet.iterator();

            while (it.hasNext()) {
                String str = it.next();
                System.out.print("(" + str + "," + hm.get(str) + ")");
            }
            System.out.println();
        }
        sc.close();
    }
}
