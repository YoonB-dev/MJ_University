package firstProject;
import java.util.Scanner;

public class Exchange {

	public static void main(String[] args) {
		int amount,changeMoney;
		int[] M = {500,100,50,10,5,1};
		Scanner scan = new Scanner(System.in);
		System.out.print("물건의 가격<1000원 이하>을 입력하세요:");
		amount = scan.nextInt();
		changeMoney = 1000-amount;
		System.out.print(amount+"원 짜리 물건을 샀고, 1000원을 내셨습니다.\n"+
		"거스름돈은"+changeMoney+"입니다.\n거스름돈의 내역은 다음과 같습니다.\n");
		int i=0;
		//거스름돈 계산
		while(i<6) {
			System.out.print(M[i]+"원 짜리 동전 갯수 = "+changeMoney/M[i]+"\n");
			changeMoney = changeMoney%M[i];
			i++;
		}
		scan.close();
	}

}
