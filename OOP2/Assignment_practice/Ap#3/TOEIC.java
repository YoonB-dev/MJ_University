package firstProject;
import java.util.Scanner;

public class TOEIC {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int toeic;
		float score;
		
		System.out.print("평점을 입력하세요:");
		score = scan.nextFloat();
		System.out.print("TOEIC 점수를 입력하세요:");
		toeic = scan.nextInt();
		
		if(toeic>=700) {
			if(score>=4.0f) {
				System.out.print("면접 대상자입니다.");
			}
			else if(score>=3.5f) {
				System.out.print("서류 전형 대상자입니다.");
			}
			else if(score>=3.0f) {
				System.out.print("필기 실험 대상자입니다.");
			}
			else {
				System.out.print("지원 할 수 없습니다.");
			}
		}
		else {
			System.out.print("지원 할 수 없습니다.");
		}
		
	}

}
