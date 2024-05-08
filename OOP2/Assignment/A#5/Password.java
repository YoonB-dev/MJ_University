package firstProject;
import java.util.*;

public class Password {
	
	static int CheckNumberCount(String pass) {
		int count=0;
		if(pass==null)return count;
		
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)>='0' && pass.charAt(i)<='9') {
				count++;
			}
		}
		
		return count;
	}
	
	static int CheckCharCount(String pass) {
		int count=0;
		if(pass==null)return count;
		
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)>='A' && pass.charAt(i)<='z') {
				count++;
			}
		}
		
		return count;
	}
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String password = new String();
		
		while(true) {
			System.out.print("\n암호를 입력하세요: ");
			int check1=0,check2=0;
			password=sc.next();
			check1 = CheckNumberCount(password);
			check2 = CheckCharCount(password);
			
			if(password.length()>=10 && check1>0 && check2>0) {
				System.out.print("\n암호가 유효하다.");
				break;
			}
			else {
				System.out.print("\n암호가 유효하지 않다.");
				if(password.length()<10)System.out.print("\n이유: 암호의 길이가 10보다 작다.");
				if(check1==0)System.out.print("\n이유: 암호 내에 숫자가 없다.");
				if(check2==0)System.out.print("\n이유: 암호 내에 영문자가 없다.");
			}
		}
	}

}
