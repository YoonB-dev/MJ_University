package firstProject;
import java.util.*;

class Television{
	String name = new String();
	boolean onoff = false;
	int chNum=1,volume=0;
	
	public void ShowInfo() {
		System.out.print("브랜드 이름: " + name + "\n전원 상태:" + onoff + "\n채널 정보: " + chNum + "\n볼륨: " + volume +"\n\n");
	}
	
	public void SwitchChNum(int num) {
		if(!onoff)return;
		if(num>=1 && num<=99) chNum = num;
		else System.out.print("\n오류: 새 채널 번호는 유효한 범위 안에 있어야 한다.");
	}
	public void UpCh() {
		if(!onoff)return;
		if(chNum+1<=99)SwitchChNum(chNum+1);
		else SwitchChNum(1);
	}
	public void DownCh() {
		if(!onoff)return;
		if(chNum-1>=1)SwitchChNum(chNum-1);
		else SwitchChNum(99);
	}
	public void UpVol() {
		if(!onoff)return;
		volume++;
		if(volume>12) volume = 12;		
	}
	public void DownVol() {
		if(!onoff)return;
		volume--;
		if(volume<0) volume = 0;
	}
	
}

public class Driver {

	public static void main(String[] args) {
		Television T1 = new Television();
		T1.name = "삼성";
		T1.onoff = true;
		T1.chNum =1;
		T1.volume = 6;
		T1.ShowInfo();
		T1.UpVol();
		T1.ShowInfo();
		
		Television T2 = new Television();
		T2.name = "엘지";
		T2.onoff = true;
		T2.chNum = 98;
		T2.volume = 12;
		T2.ShowInfo();
		T2.UpCh();
		T2.UpVol();
		T2.ShowInfo();
	}

}
