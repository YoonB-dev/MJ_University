package firstProject;
import java.util.*;

public class FindZ {
	
	static int RecursionFungtion(int num,int count) {
		if(num==0)return count;
		
		if(num%10==0) {
			count++;
		}
		num=num/10;
		
		return RecursionFungtion(num,count);
	}
	
	static int RepeatFungtion(int num) {
		int count=0;
		
		while(num!=0) {
			if(num%10==0) {
				count++;
			}
			num = num/10;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num,answer1,answer2;
		System.out.print("양의 정수를 입력하세요: ");
		num = sc.nextInt();
		answer1 = RepeatFungtion(num);
		answer2 = RecursionFungtion(num,0);
		System.out.print("반복 결과: "+ answer1 +"\n재귀 결과: " + RecursionFungtion(num,0));
		
	}

}
