//0312수업참여-임다빈60231222

import java.util.Arrays;
import java.util.Comparator; // Comparator 인터페이스를 사용하기 위한 import

public class Main {
  public static void main(String[] args) {
    Student[] studs = {
        new Student(14042, "김융소 ", "컴퓨터", 2),
        new Student(62028, "김경영 ", "전자", 3),
        new Student(49064, "김바둑", "기계", 4),
        new Student(14055, "을철학", "컴퓨터", 2),
        new Student(31076, "김사학 ", "산업", 3),
        new Student(29010, "신행정", "화학", 1),
        new Student(67034, "김국문", "전자", 4),
        new Student(14020, "장일문 ", "화학", 1),
        new Student(14007, "김영문", "컴퓨터", 2),
        new Student(51061, "김아지", "산업", 3)
    };

    // 학번으로 정렬
    Arrays.sort(studs);
    print(studs, "학번");

    // 이름으로 정렬
    Arrays.sort(studs, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
      }
    });
    print(studs, "이름");

    // 학과로 정렬
    Arrays.sort(studs, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s1.getDept().compareTo(s2.getDept());
      }
    });
    print(studs, "학과");

    // 학년으로 정렬
    Arrays.sort(studs, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getGrade(), s2.getGrade());
      }
    });
    print(studs, "학년");
  }

  public static void print(Student[] studs, String key) {
    System.out.println();
    System.out.println(key + "(으)로 정렬");
