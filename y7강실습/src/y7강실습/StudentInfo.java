package y7강실습;

import java.util.*;
 


class Student1 {
    private String name, major, sNumber;
    private double grade;

    public void Student(String name, String major, String sNumber, double grade) {
        this.name = name;
        this.major = major;
        this.sNumber = sNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getsNumber() {
        return sNumber;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> info = new ArrayList<Student>();

        System.out.println("학생 이름, 학과, 학번, 학점 평균을 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String text = sc.nextLine();
            StringTokenizer st = new StringTokenizer(text, ",");

            if (st.countTokens() != 4) {
                System.out.println("입력 형식이 잘못되었습니다. 다시 입력하세요.");
                i--;  // Decrement i to repeat the current iteration
                continue;
            }

            try {
                String name = st.nextToken().trim();
                String major = st.nextToken().trim();
                String sNumber = st.nextToken().trim();
                double grade = Double.parseDouble(st.nextToken().trim());

                Student s = new Student(name, major, sNumber, grade);
                info.add(s);
            } catch (NumberFormatException e) {
                System.out.println("학점은 숫자로 입력되어야 합니다. 다시 입력하세요.");
                i--;  // Decrement i to repeat the current iteration
            }
        }

        // Rest of your code remains unchanged
        // ...

        sc.close();
    }
}
