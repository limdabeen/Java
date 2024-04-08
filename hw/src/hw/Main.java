//자료구조(6007) 과제 #3 (60231222)
package hw;
public class Main {
    public static void main(String[] args) {
        DList<String> s1 = new DList<String>();
        DList<String> s2 = new DList<String>();

        System.out.println("<<자료구조(6007) 과제3 임다빈 60231222>>");
        System.out.println("---------------------\n");

        System.out.println("1> s1: 4개 원소 삽입");
        s1.addFirst("mango");
        s1.addLast("apple");
        s1.addLast("peach");
        s1.addLast("melon");
        System.out.println(s1);

        System.out.println("\n2> s1: apple 뒤에 cherry 삽입");
        s1.insertAfter(s1.search("apple"), "cherry");
        System.out.println(s1);

        System.out.println("\n3> s1: peach 앞에 banana 삽입");
        s1.insertBefore(s1.search("peach"), "banana");
        System.out.println(s1);

        System.out.println("\n4> s1: apple, banana 삭제");
        s1.deleteItem("apple");
        System.out.println(s1);
        s1.deleteItem("banana");
        System.out.println(s1);

        System.out.println("\n5> s1: peach, melon 삭제");
        s1.deleteItem("peach");
        System.out.println(s1);
        s1.deleteItem("melon");
        System.out.println(s1);

        System.out.println("\n6> s2: 3개 원소 삽입");
        s2.addFirst("pear");
        s2.addLast("kiwi");
        s2.addLast("blueberry");
        System.out.println(s2);

        System.out.println("\n7> s1 뒤에 s2 연결");
        s1.concat(s2);
        System.out.println(s1);
    }
}