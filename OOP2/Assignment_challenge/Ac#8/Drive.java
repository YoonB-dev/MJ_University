package firstProject;
import java.util.*;

class Menu{
	String name = new String();
	int price;
	Menu(String name,int price) {
		this.name = name;
		this.price = price;
	}
	String getName() {
		return name;
	}
	int getPrice() {
		return price;
	}
}
class Order{
	String menuName = new String();
	int price;
	Order(String menuName,int price) {
		this.menuName = menuName;
		this.price = price;
	}
	String getName() {
		return menuName;
	}
	int getPrice() {
		return price;
	}
}

public class Drive {
	static Menu[] mList = new Menu[3];
	static int mListSize = -1;
	static Order[] oList = new Order[10];
	static int oListSize = -1;
	static void setMenu() {
		mList[0] = new Menu("스파게티",8000);
		mList[1] = new Menu("피자",12000);
		mList[2] = new Menu("샐러드",6000);
		mListSize=3;
	}
	static void showMenu() {
		System.out.println("메뉴: ");
		for(int i=0;i<mListSize;i++) {
			System.out.println(i+".	"+mList[i].getName() + "	: " + mList[i].getPrice());
		}
	}
	static int getOrder() {
		Scanner sc = new Scanner(System.in);
		int getNum=0;
		System.out.print("\n주문할 메뉴 번호를 입력하세요(종료는 0): ");
		getNum = sc.nextInt();
		if(getNum>3 || getNum<0) {System.out.println("잘못된 입력입니다. 다시 시도해주세요.");}
		else if(getNum==0) {
			return -1;
		}
		else {
			oListSize++;
			oList[oListSize] = new Order(mList[getNum-1].getName(),mList[getNum-1].getPrice());
			System.out.println(mList[getNum-1].getName()+"을 주문하셨습니다.");
			currOrderList();
		}
		return getNum;
	}
	static void currOrderList() {
		System.out.println("\n현재 주문 내역:");
		for(int i=0;i<=oListSize;i++) {
			System.out.println((i+1)+". "+oList[i].getName()+" "+oList[i].getPrice());}
	}
	static int sumOfList() {
		int sum=0;
		for(int i=0;i<=oListSize;i++) {
			sum+=oList[i].getPrice();}
		return sum;
	}
	
	public static void main(String[] args) {
		setMenu();
		showMenu();
		int isCon=0;
		do {
			isCon = getOrder();
			System.out.println("총 가격: "+sumOfList());
		}while(isCon!=-1);
		System.out.println("주문 완료!!");
	}

}
