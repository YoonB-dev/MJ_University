import java.util.*;


class Member{
	public String name;
	public int age;
	public String email;
	
	public void ShowInfo() {
		System.out.print("\n이름: "+ name + "\n나이: " + age + "\n이메일: " + email);
	}
}

public class ShowMember {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member m1 = new Member();
		System.out.print("이름 입력: ");
		m1.name = sc.next();
		System.out.print("나이 입력: ");
		m1.age = sc.nextInt();
		System.out.print("E-Mail 입력: ");
		m1.email = sc.next();
		
		m1.ShowInfo();
		
		Member m2 = new Member();
		m2.name = "춘향";
		m2.age = 18;
		m2.email = "ch@naver.com";
		
		m2.ShowInfo();
		
		m2.age = 19;
		
		m2.ShowInfo();
		sc.close();
	}

}
