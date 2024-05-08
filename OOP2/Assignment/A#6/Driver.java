package firstProject;

class ItemSales{
	public String name;
	public int sellNum,sellPrice,MegaSellNum,totalSellNum=0;
	public float totalSell=0,totalSale=0,MegaSale;
	public void Sell(int num) {
		sellNum = num;
		System.out.print(name+" "+sellNum+" 개를 팔았다.\n");
		if(MegaSellNum<=sellNum) {
			float price = sellPrice*sellNum*(1-MegaSale);
			System.out.print("할인률이 적용되어 판매 가격은 "+price+"원이다.");
			totalSell+=price;
			totalSale+=sellPrice*sellNum*MegaSale;
		}
		else {
			float price = sellPrice*sellNum;
			System.out.print("할인률이 적용되지 않아 판매 가격은 "+price+"원이다.");
			totalSell+=price;
		}
		totalSellNum+=sellNum;
		System.out.print("\n\n누적 판매 수량 = "+totalSellNum +" ,개 누적 판매금액 = "+totalSell+",원 누적 할인금액 = "+totalSale+"원\n\n");
	}
}


public class Driver {

	public static void main(String[] args) {
		ItemSales lunchBox = new ItemSales();
		lunchBox.name = "도시락";
		lunchBox.sellPrice = 1000;
		lunchBox.MegaSellNum = 10;
		lunchBox.MegaSale = 0.3f;
		
		lunchBox.Sell(1);
		lunchBox.Sell(9);
		lunchBox.Sell(10);
		lunchBox.Sell(50);
	}

}
