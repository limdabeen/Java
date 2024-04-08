//수업참여0312임다빈60231222


import java.util.Comparator;

public class Student {

  protected int id;
  String name;
  protected String dept;
  protected int grade;

  public Student(int id, String name, String dept, int grade) {
    this.id = id;
    this.name = name;
    this.dept = dept;
    this.grade = grade;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDept() {
    return dept;
  }

  public int getGrade() {
    return grade;
  }

  Collections.sort(studentList, StudentComparator.nameComparator);
  System.out.println("이름으로 비교 :");
  for (Student student : studentList) {
    System.out.println(student.getId() + " " + student.getName() + " " + student.getDept() + " " + student.getGrade());
  }


  Collections.sort(studentList, StudentComparator.deptComparator);
  System.out.println("학과로 비교 :");
  for (Student student : studentList) {
    System.out.println(student.getId() + " " + student.getName() + " " + student.getDept() + " " + student.getGrade());
  }

  // 학년으로 정렬
  Collections.sort(studentList, StudentComparator.gradeComparator);
  System.out.println("학년으로 비교 :");
  for (Student student : studentList) {
    System.out.println(student.getId() + " " + student.getName() + " " + student.getDept() + " " + student.getGrade());
  }
}
}
