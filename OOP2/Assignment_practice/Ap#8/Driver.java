import java.util.*;

class Item{
	String name;
	int price,quantity;
	Item(String name,int price,int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	String PrintAll() {
		return this.name + "		" + this.price + "		" + this.quantity + "		" + getTotalPrice();
	}
	int getTotalPrice() {
		return price*quantity;
	}
}

class ShoppingCart{
	int totalPrice,size,maxNum;
	Item[] items;
	ShoppingCart(){
		this.totalPrice = 0;
		this.size = 0;
		items = new Item[5];
		this.maxNum = items.length;
	}
	void addItem(Item item) {
		items[size++] = item;
		totalPrice+=item.getTotalPrice();
	}
	String printAll() {
		String answer = "장바구니 \n"+"상품		가격		수량		총액\n";
		for(int i=0;i<size;i++) {
			answer+=items[i].PrintAll()+"\n";
		}
		return answer;
	}
}

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart cart = new ShoppingCart();
		String name = new String();
		String isContinue = new String();
		int price,quantitiy;
		do {
			System.out.println("구매하려는 상품의 이름을 입력하세요: ");
			name = sc.next();
			System.out.println("구매하려는 상품의 가격을 입력하세요: ");
			price = sc.nextInt();
			System.out.println("구매하려는 상품의 수량을 입력하세요: ");
			quantitiy = sc.nextInt();
			Item item = new Item(name,price,quantitiy);
			cart.addItem(item);
			
			System.out.println(cart.printAll());
			
			System.out.println("총 구매금액 : "+cart.totalPrice + "\n쇼핑을 계속 하시겠습니까?<예 혹은 아니오>");
			isContinue = sc.next();
		}while(isContinue.equals("예"));
		
		System.out.println("결제하세요 \n총 결제액: "+cart.totalPrice);
	}
}
