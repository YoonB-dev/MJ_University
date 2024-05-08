package firstProject;
import java.util.*;

class Student{
	String name;
	int num,subjectNum,maxNum;
	String[] subjectList;
	Student(int num,String name){
		this.num = num;
		this.name = name;
		maxNum = 10;
		subjectNum=0;
		subjectList = new String[maxNum];
	}
	String ShowList() {
		String answer ="";
		for(int i=0;i<subjectNum;i++) {
			answer += subjectList[i]+"	";
		}
		return answer;
	}
	void AddSub(String name) {
		if(maxNum<=subjectNum)return;
		subjectList[subjectNum] = name;
		subjectNum++;
	}
}

class Professor{
	String name,type,subject;
	Professor(String name, String type, String subject){
		this.name = name;
		this.type=type;
		this.subject = subject;
	}
	String returnName() {
		return name;
	}
	String returnType() {
		return type;
	}
	String returnSubject() {
		return subject;
	}
}

public class Driver {
	static Professor[] Ps = new Professor[10];
	static Student[] Ss = new Student[10];
	static Scanner sc = new Scanner(System.in);
	static int pSize=0,sSize=0;
	static void InputProfInfo() {
		String name,type,subject,isCon = new String();
		do {
			System.out.print("교수 이름을 입력하세요: ");
			name = sc.next();
			System.out.print("\n학과명을 입력하세요: ");
			type = sc.next();
			System.out.print("\n교과목명을 입력하세요: ");
			subject = sc.next();
			Professor P = new Professor(name,type,subject);
			Ps[pSize++] = P;
			System.out.print("\n추가할 교수가 더 있나요?(Yes or No): ");
			isCon = sc.next();
		}while(isCon.equals("Yes"));
	}
	static void InputStudInfo() {
		String name,isCon;
		int num;
		do {
			System.out.print("\n학생 이름을 입력하세요: ");
			name = sc.next();
			System.out.print("\n학번을 입력하세요: ");
			num = sc.nextInt();
			Student S = new Student(num,name);
			Ss[sSize++] = S;
			System.out.print("추가할 학생이 더 있나요?(Yes or No): ");
			isCon = sc.next();
		}while(isCon.equals("Yes"));
	}
	static void registerCourse() {
		int i=0;
		String isCon;
		while(Ss[i]!=null && i<10) {
			do {
				System.out.print("\n"+Ss[i].name+"이 수강 신청할 교과목명을 입력하세요: ");
				String sub = sc.next();
				Ss[i].AddSub(sub);
				System.out.print("\n추가할 교과목명이 더 있나요?(Yes or No): ");
				isCon = sc.next();
			}while(isCon.equals("Yes"));
			i++;
		}
	}
	static void printResult() {
		System.out.println("이름	학번	수강과목들");
		for(int i=0;Ss[i]!=null;i++) {
			System.out.print(Ss[i].name+"	"+Ss[i].num+"	");
			for(int k=0;k<Ss[i].subjectNum;k++) {
				System.out.print(Ss[i].subjectList[k]+"  ");
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		InputProfInfo();
		InputStudInfo();
		registerCourse();
		printResult();
	}

}
