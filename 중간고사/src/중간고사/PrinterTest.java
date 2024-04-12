package 중간고사;

class Printer {
	private int nunOfPapers = 0;
	int num;
	int lack;
	
	public Printer(int num){
		this.nunOfPapers = num;
	}
	
	
	void print(int amount) {
		if(amount < nunOfPapers) {
			
			nunOfPapers=nunOfPapers-amount;
			System.out.print(amount + "장 출력했습니다 현재 " +nunOfPapers+ "장 남았습니다 ");
		}
		else if(nunOfPapers == 0) {
			System.out.print("용지 x");
		}
		
		else if(amount > nunOfPapers) {
			lack = amount-nunOfPapers;
			
			System.out.print( "모두 출력하려면 용지가 " +lack+ "부족 "+ nunOfPapers+"만 출력 ");
			nunOfPapers=0;
			
			
		}
		
		
		
	}
}

public class PrinterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	// TODO Auto-generated method stub
	Printer p = new Printer(10);
	p.print(2);
	p.print(20);
	p.print(10);



	}

}
