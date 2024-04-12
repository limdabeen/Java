package 중간고사;
import java.util.Scanner;

public class sum짝수 {
	

	public static void main(String[] args) {
	
		
		int sum = 0;
		boolean k = true;
	
	while(k) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수를 입력하세요 ");
		int q = sc.nextInt();
		
		if (q%2 ==0) {
			sum +=q;
		}
		else if ( q ==-1) {
			k = false; 
		}
	
	}
	System.out.print("입력한 양의 정수 중에서 짝수의 합은?"+ sum);
	}

	
}
