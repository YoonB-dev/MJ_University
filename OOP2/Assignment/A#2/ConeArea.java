package firstProject;
import java.util.Scanner;

public class ConeArea {

	public static void main(String[] args) {
		double r,h,volume,area;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("원뿔 밑의 원의 반지름을 입력하세요: ");
		r = scan.nextFloat();
		System.out.print("원뿔의 높이를 입력하세요: ");
		h = scan.nextFloat();
		
		volume = 1f/3f * Math.PI * Math.pow(r, 2)*h;
		area = Math.PI * r * Math.sqrt(Math.pow(r, 2)+Math.pow(h,2)) + Math.PI*Math.pow(r,2);
		
		System.out.print("\n원뿔 밑의 원의 반지름: "+r);
		System.out.print("\n원뿔의 높이: "+h);
		System.out.print("\n원뿔의 부피 : "+volume);
		System.out.print("\n원뿔의 표면적 : "+area);
	}

}
