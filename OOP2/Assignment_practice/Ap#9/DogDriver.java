package firstProject;
import java.util.*;

class Pet{
	String name=new String();
	int age=1;
	Pet(String name,int age){
		this.name = name;
		this.age = age;
	}
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
}
class Dog extends Pet{
	boolean isInoculation=false;
	String kind = new String();
	Dog(String name, int age, String kind) {
		super(name,age);
		this.isInoculation = false;
		this.kind = kind;
	}
	String getInoculation() {
		if(isInoculation)return"예방주사를 맞았다.\n";
		else return "예방주사를 맞지 않았다.\n";
	}
	void getAllInfo() {
		System.out.print("\n이름: "+name+"\n나이: "+age+"\n품종: "+kind+"\n"+getInoculation());
	}
	void changeKind(String kind) {
		this.kind = kind;
	}
	void changeIno(boolean Ino) {
		this.isInoculation = Ino;
	}
	
}

public class DogDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dog[] Dogs = new Dog[5];
		
		Dog D1 = new Dog("하루",3,"진돗개");
		D1.changeIno(true);
		Dogs[0] = D1;
		
		System.out.print("개의 이름을 입력하세요: ");
		String name = sc.next();
		System.out.print("\n개의 나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.print("\n개의 품종을 입력하세요: ");
		String kind = sc.next();
		System.out.print("\n예방주사를 맞았나요?(예 혹은 아니오): ");
		String isIno = sc.next();
		
		Dog D2 = new Dog(name,age,kind);
		D2.changeIno(isIno.equals("예"));
		Dogs[1] = D2;
		
		for(int i=0;Dogs[i]!=null;i++) {
			Dogs[i].getAllInfo();
		}
		System.out.println("다음 개들은 두 살이 넘었으나 예방주사를 맞지 않았다:\n");
		for(int i=0;Dogs[i]!=null;i++) {
			if(Dogs[i].getAge()>=2 && !Dogs[i].isInoculation) {
				System.out.println("이름:"+Dogs[i].getName() + " 나이: " + Dogs[i].getAge());
			}
		}
		
	}

}
