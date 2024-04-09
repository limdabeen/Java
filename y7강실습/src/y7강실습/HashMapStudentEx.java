package y7강실습;
import java.util.*;

class Student {
    int id;
    String tel;

    public Student(int id, String tel) {
        this.id = id;
        this.tel = tel;
    }
    
    public int getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }
}

public class HashMapStudentEx {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("학생 이름 입력 (exit로 종료): ");
            String name = scanner.nextLine();

            if (name.equals("exit")) {
                break;
            }

            System.out.print("학생 전화번호 입력: ");
            String tel = scanner.nextLine();

            // 학생 정보를 HashMap에 저장
            map.put(name, new Student(map.size() + 1, tel));
        }

        while (true) {
            System.out.print("검색할 이름 (exit로 종료): ");
            String name = scanner.nextLine();

            if (name.equals("exit")) {
                break;
            }

            Student student = map.get(name);
            if (student == null) {
                System.out.println(name + "은(는) 등록되지 않은 학생입니다.");
            } else {
                System.out.println("id:" + student.getId() + ", 전화:" + student.getTel());
            }
        }

        scanner.close();
    }
}
