package nn;

public class ScoreAverage {

    public static void main(String[] args) {
        double score[][] =  {
            {3.3, 3.4},
            {3.5, 3.6},
            {3.7, 4.0},
            {4.1, 4.2}
        };

        double sum = 0;
        double max = score[0][0];

        for (int year = 0; year < score.length; year++) {
            for (int term = 0; term < score[year].length; term++) {
                sum += score[year][term];
                if (score[year][term] > max) {
                    max = score[year][term];
                }
            }
        }

        int n = score.length;
        int m = score[0].length;

        System.out.println("4년 전체 평점 평균은 " + sum / (n * m));
        System.out.println("가장 큰 학점은 " + max + "입니다");
    }
}
