package firstProject;


import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		String subject = new String(); // 과목 이름
		String score = new String(); // 과목 학점
		String isCon = new String(); // 반목문 확인
		int attendance,homework,testScore,count=0; // 출석, 과제, 시험, 과목 개수
		double sum,sumScore=0; // 총점 , 총점 다 더하기
		Scanner sc = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("과목 이름을 출력하세요: ");
			subject = sc.next();
			System.out.print("출석 점수를 입력하세요: ");
			attendance = sc.nextInt();
			System.out.print("과제 점수를 입력하세요: ");
			homework = sc.nextInt();
			System.out.print("시험 점수를 입력하세요: ");
			testScore = sc.nextInt();
			sum = 0.1*attendance + 0.4*homework + 0.5*testScore;
			System.out.print("과목"+ subject+"의 총점: " + sum);
			
			if(sum>=90) {score = "A";sumScore+=4;}
			else if(sum>=80) {score = "B";sumScore+=3;}
			else if(sum>=70) {score = "C";sumScore+=2;}
			else if(sum>=60) {score = "D";sumScore+=1;}
			else score = "F";
			
			System.out.print("\n과목" + subject + "의 학점 : " + score);
			System.out.print("\n계속하기를 원하세요? 그렇다면 y를 아니면 n을 입력하세요: ");
			isCon = sc.next();
			
		}while(isCon.equals("Y") || isCon.equals("y"));
		
		System.out.print("평점: " + sumScore/count);

	}

}
