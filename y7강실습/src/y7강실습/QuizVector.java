package y7강실습;
import java.util.*;

class Nation {
	private String country, capital;
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	public String getCountry() {
		return country;
	}
	public String getCapital() {
		return capital;
	}
}

public class QuizVector {
	Scanner sc = new Scanner(System.in);
	Vector<Nation> v = new Vector<Nation>();
	
	public QuizVector() {
	v.add(new Nation("멕시코", "멕시코시티"));
	v.add(new Nation("스페인", "리스본"));
	v.add(new Nation("프랑스", "파리"));
	v.add(new Nation("영국", "런던"));
	v.add(new Nation("그리스", "아테네"));
	v.add(new Nation("독일", "베를린"));
	v.add(new Nation("일본", "동경"));
	v.add(new Nation("중국", "베이찡"));
	v.add(new Nation("러시아", "모스크바"));
	}
	
	private boolean contains(String country) {
		for(int i=0; i<v.size(); i++) {
			if(v.get(i).getCountry().equals(country)) { // 사용자가 입력한 나라가 이미 있다면
				return true;
			}
		}
		return false;
	}
	
	public void insert() {
		System.out.println("현재 " + v.size() + "개 나라와 수도가 입력되어 있습니다.");
		while(true) {
			System.out.print("나라와 수도 입력>>");
			String country = sc.next();
			if(country.equals("그만")) break;
			String capital = sc.next();
			
			if(contains(country)) { // 사용자가 입력한 나라가 이미 있다면
				System.out.println(country + "는 이미 있습니다!");
				continue;
			}
			
			v.add(new Nation(country, capital));	//벡터에 객체 추가
		}
	}
	
	public void play() {
		while(true) {
			// 나라 중에서 하나를 선택한다.
			int index = (int)(Math.random()*v.size()); // 랜덤한 위치 결정
			
			// 문제(나라)와 정답(수도)을 결정한다.
			Nation nation = v.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
			// 문제를 출력한다.
			System.out.print(question + "의 수도는? ");
			
			String capitalFromUser = sc.next(); // 사용자의 입력
			if(capitalFromUser.equals("그만")) {
				break;
			}
			if(capitalFromUser.equals(answer))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");				
		}	
	}
	
	public void run() {
		System.out.println("***수도 맞추기 게임을 시작합니다. ***");
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>>");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insert(); break;
			case 2:
				play(); break;
			case 3:
				sc.close();
				System.out.println("게임을 종료합니다.");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		QuizVector q = new QuizVector();
		q.run();
	}
}