package firstProject;

import java.util.*;

public class Rome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=1;
		String romeYear = new String();
		do {
		if(year!=1)System.out.print("잘못 입력된 연도\n");
		System.out.print("연도를 입력하세요: ");
		year = sc.nextInt();
		}while(year<1 || year >=5000);
		
		int[] rome = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romeNum = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};		
		
		for(int i=0;i<rome.length;i++) {
			while(year>=rome[i]) {
				romeYear+=romeNum[i];
				year-=rome[i];
			}
		}	
		System.out.print(romeYear);		
		
	}
}
