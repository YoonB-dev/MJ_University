package firstProject;
import java.util.*;

class CheckCardAmount{
	String name = new String();
	int accountNum;
	String maturityDate = new String();
	int balance=0;
	boolean Vertification(String name,int accountNum,String maturityDate){
		if(this.name.equals(name) && this.accountNum==accountNum && this.maturityDate.equals(maturityDate)) {
			return true;
		}
		return false;
	}
	public CheckCardAmount(String name,int accountNum, String maturityDate) {
		this.name = name;
		this.accountNum = accountNum;
		this.maturityDate = maturityDate;
	}
	
	void BuyItem() {
		Scanner sc = new Scanner(System.in);
		int billingAmount,accountNum;
		String name = new String();
		String maturityDate = new String();
		String con = new String();
		System.out.print("상품을 구매한다.\n청구 금액을 입력하세요: ");
		billingAmount = sc.nextInt();
		System.out.print("\n고객 이름을 입력하세요: ");
		name = sc.next();
		System.out.print("\n고객 번호를 입력하세요: ");
		accountNum = sc.nextInt();
		System.out.print("\n카드 만기연월을 입력하세요: ");
		maturityDate = sc.next();
		
		if(this.Vertification(name,accountNum,maturityDate)) {
			System.out.print("\n신원 확인 성공");
			
			System.out.print("\n계속하시겠습니까?(true혹은 false): ");
			con = sc.next();
			
			if(this.balance>=billingAmount)this.balance-=billingAmount;
			
			
			if(con.equals("True") || con.equals("true")) {
				this.BuyItem();
			}
		}
		else {
			System.out.print("\n신원이 일치하지 않습니다.");
		}
		
		
	}
	void Deposit(int amount) {
		if(amount>0) {
			this.balance+=amount;
			System.out.println(amount+"원을 입금한다.");
		}
		else System.out.println("입금액이 올바르지 않습니다.");
	}
	
	void Withdraw(int amount) {
		if(amount<=this.balance && amount>0) {
			System.out.println(amount+"원을 출금합니다");
			this.balance-=amount;
		}else {
			System.out.println("잔고 초과");
		}
	}
	String ShowInfo() {
		return "예금주 이름: "+this.name + "\n계좌번호: "+this.accountNum + "\n만기연월: "+this.maturityDate + "\n잔고: "+ this.balance;
	}
}

public class Driver {
	public static void main(String[] args) {
		CheckCardAmount user = new CheckCardAmount("선남",1001,"0912");
		user.Deposit(100000);
		user.BuyItem();
		user.Withdraw(20000);
		System.out.print(user.ShowInfo());
	}
}
