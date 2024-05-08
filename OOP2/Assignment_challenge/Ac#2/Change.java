package firstProject;
import java.util.Scanner;
import java.lang.Integer;
public class Change {

	public static void main(String[] args) {
		int change;
		String num = new String();
		Scanner scan = new Scanner(System.in);
		System.out.print("12 비트(bit)의 이진수를 입하세요: ");
		num = scan.next();
		
		change = Integer.parseInt(num,2);
		System.out.print("이진수 "+num+"에 대응하는 8진수는 "+ Integer.toOctalString(change));
		
		
	}

}
