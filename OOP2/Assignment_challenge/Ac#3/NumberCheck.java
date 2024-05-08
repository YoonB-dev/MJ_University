package firstProject;
import java.util.Scanner;
import java.lang.Integer;

public class NumberCheck {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		String number = new String();
		int front,year,type,num,length;
		
		System.out.print("학번은? : ");
		number = scan.next();
		length = number.length();
		front = Integer.parseInt(number.substring(0,2));
		year = Integer.parseInt(number.substring(2,4));
		type = Integer.parseInt(number.substring(4,5));
		num = Integer.parseInt(number.substring(5));
		
		System.out.print("입학 연도 : " + year);
		System.out.print("\n입학 유형 : " + type);
		System.out.print("\n입학 순번 : " + num);
		
		int check=0;
		if(length!=8) {
			System.out.print("\n틀린 이유: 길이가 8이 아니다.");
			check++;
		}
		if(front!=60) {
			System.out.print("\n틀린 이유: 60으로 시작하지 않는다.");
			check++;
		}
		if(type!=2 && type!=5) {
			System.out.print("\n틀린 이유: 입학 유형");
			check++;
		}
		if(num>=999 || num<1) {
			System.out.print("\n틀린 이유: 입학 순번");
			check++;
		}
		if(check==0) {
			System.out.print("\n학번이 맞다.");
		}
		
		
	
		

	}

}
