import java.util.*;

class Bank{
	String name;
	int num,data;
	double r,principalinterest;	
	public Bank(String name, int num, int data, double r){
		this.name = name;
		this.num = num;
		this.data = data;
		this.r = r;
	}
	public void Calculation(){}
}

class Simpledeposit extends Bank{
	int principal;
	public Simpledeposit(String name, int num, int n, double r, int p){
		super(name, num, n, r);
		this.principal = p;
	}
	public void Calculation(){
		principalinterest = principal * (1 + r/12 * data);
	}
}

class Compounddeposit extends Bank{
	int principal;
	public Compounddeposit(String name, int num, int n, double r, int p){
		super(name, num, n, r);
		this.principal = p;
	}
	public void Calculation(){
		principalinterest = principal * Math.pow((1 + r/12), data);
	}
}

class Savings extends Bank{
	int mp;
	public Savings(String name, int num, int n, double r, int m){
		super(name, num, n, r);
		this.mp = m;
	}
	public void Calculation(){
		principalinterest = mp * data + mp * r / 12 * data*(data+1) / 2;
	}
}

public class Driver{
   public static void main(String[] args){
	   Simpledeposit sd = new Simpledeposit("선남", 100, 12, 0.05, 10000000);
	   sd.Calculation();
	   System.out.println("정기예금(단리)\n예금주 이름:"+sd.name+"\n계좌번호: "+sd.num+"\n계약기간: "+sd.data+"\n연이율: "+sd.r+"\n원금: "+sd.principal+"\n원리금: "+(long)sd.principalinterest);
	   
	   Compounddeposit cd = new Compounddeposit("선녀", 200, 12, 0.05, 10000000);
	   cd.Calculation();
	   System.out.println("\n정기예금(복리)\n에금주 이름: "+cd.name+"\n계좌번호: "+cd.num+"\n계약기간: "+cd.data+"\n연이율: "+cd.r+"\n원금: "+cd.principal+"\n원리금: "+(long)cd.principalinterest);
	   
	   Savings is = new Savings("길동", 300, 12, 0.05, 100000);
	   is.Calculation();
	   System.out.println("\n정기적금\n예금주 이름: "+is.name+"\n계좌번호: "+is.num+"\n계약기간: "+is.data+"\n연이율: "+is.r+"\n월불입액: "+is.mp+"\n원리금: "+(long)is.principalinterest);
   }
}
