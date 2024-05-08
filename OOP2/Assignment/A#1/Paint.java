package firstProject;
import java.util.Scanner;

public class Paint {

	public static void main(String[] args) {
		final int paintTong = 500;
		double wid,len,hei,area;
		Scanner scan = new Scanner(System.in);
		System.out.print("사무실의 가로 길이를 입력하세요:");
		wid = scan.nextDouble();
		System.out.print("사무실의 세로 길이를 입력하세요:");
		len = scan.nextDouble();
		System.out.print("사무실의 높이를 입력하세요:");
		hei = scan.nextDouble();
		
		area = (wid*len)+(wid*hei*2)+(len*hei*2);
		System.out.print("가로:"+ wid+ "\n세로:"+ len + "\n높이:"+ hei +  "\n사무실 총 면적:"+area);
		double num = area / paintTong;
		
		System.out.print("\n필요한 페인트 통의 수:"+num);
	}

}
