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

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("학생 이름을 입력하세요 (종료를 원하시면 'Null' 입력): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("Null")) {
                break;
            }

            System.out.print("전화번호를 입력하세요: ");
            String tel = scanner.nextLine();

            map.put(name, new Student(map.size() + 1, tel)); 

            System.out.println("학생 정보가 등록되었습니다.");
        }

        while (true) {
            System.out.print("검색할 이름? ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            Student student = map.get(name);
            if (student == null)
                System.out.println(name + "은(는) 없는 학생입니다.");
            else
                System.out.println("ID: " + student.getId() + ", 전화번호: " + student.getTel());
        }
        scanner.close();
    }
}
