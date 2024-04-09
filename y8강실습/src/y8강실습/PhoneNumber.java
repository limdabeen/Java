package y8강실습;
import java.io.*;
import java.util.*;

public class PhoneNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> phone = new HashMap<String, String>();
		try {
			Scanner fScanner = new Scanner(new FileReader("//Users//imdabin//Desktop//javaTxt//hangul.txt"));
			while(fScanner.hasNext()) {
				String line = fScanner.nextLine();	//한 줄을 읽고
				String s[] = line.split(" ");	//이름과 전화번호 분리
				phone.put(s[0], s[1]);
			}
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
		
		System.out.println("총 " + phone.size() + "개의 전화번호를 읽었습니다.");
		while(true) {
			System.out.print("이름>>");
			String name = sc.next();
			if(name.equals("그만")) break;
			if(phone.containsKey(name))
				System.out.println(phone.get(name));
			else
				System.out.println("찾는 이름이 없습니다.");
		}
		sc.close();
	}
}