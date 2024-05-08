import java.util.Random;

public class PhoneNumber {

	public static void main(String[] args) {
		String number = new String();
		Random ran = new Random();
		number += "0";
		
		int num1 = ran.nextInt(6)+1;
		int num2 = ran.nextInt(8);
		number+=num1;
		number+=num2+"-";
		/*for(int i=0;i<7;i++) {
			int num = ran.nextInt(10);
			number+=num;
			if(i==2)number+="-";
		}*/
		number+=ran.nextInt(10);
		number+=ran.nextInt(10);
		number+=ran.nextInt(10);
		number+="-";
		number+=ran.nextInt(10);
		number+=ran.nextInt(10);
		number+=ran.nextInt(10);
		number+=ran.nextInt(10);
		
		System.out.println("생성된 임의의 전화번호: "+number);
	}

}
