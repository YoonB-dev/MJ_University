package firstProject;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double money;
		double inter;
		int i;
		
		System.out.print("원금을 입력하세요: ");
		money = sc.nextLong();
		System.out.print("연 이율을 입력하세요: ");
		inter = sc.nextDouble();
		
		System.out.print("\n연도수 원리금\n");
		double moneyDouble = money * 2;
		for(i=1;money<moneyDouble;i++) {
			money = money * ((inter/100) + 1);
			System.out.print("\n"+i +"	"+money);
		}
		System.out.print("\n필요한 연도수 = " +(i-1));
	}

}
