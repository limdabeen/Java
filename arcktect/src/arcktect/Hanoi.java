//자료구조(6007) 과제 1(60231222 임다빈)
package arcktect;
public class Hanoi {
    
    public static void move(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move Disk " + a + " to " + c );
        } else {
            move(n-1, a, c, b); 
            System.out.println("Move Disk " + n + " to " + a + " to " + c );
            move(n-1, b, a, c); 
        }
    }

    public static void main(String[] args) {
        int n = 3; 
        System.out.println("원반이 3개인 경우 ");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서: 1 - 2 - 3)");
        move(n, 'A', 'B', 'C'); 

        System.out.println("\nn 원반이 4개인 경우");
        System.out.println("(원반 이름 크기가 작은 -> 큰 순서: 1 - 2 - 3 - 4)");
        n = 4; 
        move(n, 'A', 'B', 'C'); 
    }
}
