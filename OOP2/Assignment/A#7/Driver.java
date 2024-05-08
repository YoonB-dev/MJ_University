package firstProject;
import java.util.*;

class Course{
	String courseName = new String();
	int maxStudent,currStudent=0,score;
	static int courseNum;
	
	Course(String name,int maxS,int score) {
		courseName = name;
		maxStudent = maxS;
		this.score = score;
		currStudent=0;
		courseNum++;
	}
	String ReturnName() {
		return courseName;
	}
	int ReturnMaxStudent() {
		return maxStudent;
	}
	int ReturnCurrStudent() {
		return currStudent;
	}
	int ReturnScore() {
		return score;
	}
	int ReturnCourseNum() {
		return courseNum;
	}
	String ReturnAll() {
		return courseName+"		"+maxStudent+"		"+currStudent+"\n";
	}
	void ChangeName(String name) {
		this.courseName = name;
	}
	void ChangeMaxStudent(int mS) {
		this.maxStudent = mS;
	}
	void ChangeScore(int score) {
		this.score = score;
	}
	void AddMaxStudent(int amount) {
		this.maxStudent+=amount;
	}
}
class Student{
	String name = new String();
	int StudentNum,maxScore,currScore;
	Student(int num,String name,int maxScore){
		this.StudentNum = num;
		this.name = name;
		this.maxScore = maxScore;
		this.currScore=0;
	}
	int ReturnNum() {
		return this.StudentNum;
	}
	String ReturnName() {
		return this.name;
	}
	int ReturnMaxScore() {
		return this.maxScore;
	}
	int ReturnCurrScore() {
		return this.currScore;
	}
	String ReturnAll() {
		return StudentNum +"		"+ name +"		"+currScore+"\n"; 
	}
	void ChangeNum(int num) {
		this.StudentNum = num;
	}
	void ChangeName(String name) {
		this.name = name;
	}
	void ChangeMax(int num) {
		this.maxScore = num;
	}
}
class Register{
	Student student;
	Course course;
	Register(Student s,Course c){
		this.student = s;
		this.course = c;
		
		if(c.maxStudent>c.currStudent) {
			if(s.maxScore>=s.currScore+c.score) {
				s.currScore+=c.score;
				c.currStudent++;
			}
			else {
				System.out.print("\n학점 초과로 수강 신청할 수 없다.");
			}
		}
		else {
			System.out.print("\n정원이 차서 수강 신청할 수 없다.");
		}
	}
	String ReturnInfo() {
		return "\n"+this.student.name + ": " + this.course.courseName + " 수강신청";
	}
}

public class Driver {

	public static void main(String[] args) {
		Course C1 = new Course("알고리즘",30,4);
		Course C2 = new Course("자료구조",25,3);
		System.out.print("수강 신청전\n교과목명		최대학생수		현재학생수\n");
		System.out.print(C1.ReturnAll());
		System.out.print(C2.ReturnAll());
		C1.AddMaxStudent(6);
		C2.AddMaxStudent(3);
		System.out.print("수강 인원 증원후\n교과목명		최대학생수		현재학생수\n");
		System.out.print(C1.ReturnAll());
		System.out.print(C2.ReturnAll());
		
		System.out.print("생성된 교과목들의 수: "+C1.courseNum);
		
		Student S1 = new Student(2101,"선남",18);
		Student S2 = new Student(2102,"선녀",21);
		Student S3 = new Student(2103,"길동",18);
		System.out.print("\n\n학번		이름		신청 학점수\n");
		System.out.print(S1.ReturnAll());
		System.out.print(S2.ReturnAll());
		System.out.print(S3.ReturnAll());
		
		Register R1 = new Register(S1,C1);
		Register R2 = new Register(S2,C1);
		Register R3 = new Register(S2,C2);
		Register R4 = new Register(S3,C1);
		Register R5 = new Register(S3,C2);

		System.out.print(R1.ReturnInfo());
		System.out.print(R2.ReturnInfo());
		System.out.print(R3.ReturnInfo());
		System.out.print(R4.ReturnInfo());
		System.out.print(R5.ReturnInfo());
		System.out.print("\n수강 신청후\n교과목명		최대학생수		현재학생수\n");
		System.out.print(C1.ReturnAll());
		System.out.print(C2.ReturnAll());System.out.print("\n학번		이름		신청 학점수\n");
		System.out.print(S1.ReturnAll());
		System.out.print(S2.ReturnAll());
		System.out.print(S3.ReturnAll());
	}

}
