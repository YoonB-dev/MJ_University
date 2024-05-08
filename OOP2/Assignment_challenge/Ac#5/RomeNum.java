package firstProject;
import java.util.*;

public class RomeNum {
	
	static int RomeNumToInt(char N) {
		int num=-1;
		if(N=='I')num=1;
		if(N=='V')num=5;
		if(N=='X')num=10;
		if(N=='L')num=50;
		if(N=='C')num=100;
		if(N=='D')num=500;
		if(N=='M')num=1000;
		return num;
	}
	
	static int RomeNumToDec(String romeYear) {
		int sum = 0;
		for(int i=0;i<romeYear.length();i++) {
			sum+=RomeNumToInt(romeYear.charAt(i));
			if(i>1 && (romeYear.charAt(i)=='V' || romeYear.charAt(i)=='X') && romeYear.charAt(i-1)=='I')sum-=2;
			if(i>1 && (romeYear.charAt(i)=='L' || romeYear.charAt(i)=='C') && romeYear.charAt(i-1)=='X')sum-=20;
			if(i>1 && (romeYear.charAt(i)=='D' || romeYear.charAt(i)=='M') && romeYear.charAt(i-1)=='C')sum-=200;
		}
		return sum; 
	}
	
	static String DecToOct(int num) {
		if(num<=0)return "";
		else {
			return DecToOct(num/8) + num%8;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String romeYear = new String();
		int numDec=0;
		while(true) {
			System.out.print("\n로마 숫자를 입력하세요: ");
			romeYear = sc.next();
			numDec = RomeNumToDec(romeYear);
			if(numDec>=1 && numDec<5000)break;
			else {
				System.out.print("\n잘못입력된 로마 숫자");
			}
		}
		String numOct = DecToOct(numDec);
		System.out.print("\n10진수로 변환한 숫자: "+numDec);
		System.out.print("\n8진수로 변환한 숫자: "+numOct);

	}

}
