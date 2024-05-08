package firstProject;
import java.util.Scanner;

public class ScoreCheck {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String cheat = new String();
		int join,totalScore;
		String ave = new String();
		System.out.print("부정행위 여부(true 혹은 false): ");
		cheat = scan.next();
		System.out.print("출석(0~100사이의 정수값): ");
		join = scan.nextInt();
		System.out.print("총점(0~ 100사이의 정수값): ");
		totalScore = scan.nextInt();
	
		
		if(cheat.equals("true") || join<80) {
			ave = "F";
		}
		else{
			if(totalScore>=90) {
				ave = "A";
			}
			else if(totalScore>=80) {
				ave = "B";
			}
			else if(totalScore>=70) {
				ave = "C";
			}
			else if(totalScore>=60) {
				ave = "D";
			}
			else {
				ave = "F";
			}
		}
		System.out.print("학점 = " + ave);
		
		

	}

}
