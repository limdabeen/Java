package y8강실습; //뭔가나올냄새남  
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String, Integer> javaScore = new HashMap<String, Integer>();

        javaScore.put("김성동", 97);
        javaScore.put("황기태", 88);
        javaScore.put("김남윤", 98);
        javaScore.put("이재문", 70);
        javaScore.put("한원선", 99);

        System.out.println("HashMap의 요소 개수: " + javaScore.size());

        Set<String> keys = javaScore.keySet();

        Iterator<String> it = keys.iterator();
        int sum = 0;
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 
        
        while (it.hasNext()) {
            String name = it.next();
            int score = javaScore.get(name);
            System.out.println(name + " : " + score);

            if (max < score) {
                max = score;
            }
            if (min > score) {
                min = score;
            }

            sum += score;
        }

        System.out.println("최소값은 " + min);
        System.out.println("최대값은 " + max);
        System.out.println("평균은 " + (double) sum / javaScore.size());
    }
}
