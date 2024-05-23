import java.util.*;

public class Driver {
    public static void main(String[] args){
        int hNum;
        Scanner sc = new Scanner(System.in);
        System.out.print("가구들의 수를 입력하세요: ");
        hNum = sc.nextInt();

        int[] hEarns = new int[hNum];
        boolean isError = false;
        System.out.print("\n각 가구의 가구 소득을 입력하세요: ");
        float maxNum=0;

        int errPos=0;
        for(int i=0;i<hNum;i++){
            try{
                hEarns[i] = sc.nextInt();
                if(maxNum<=hEarns[i])maxNum = hEarns[i];

                if(hEarns[i]<0)throw new IllegalArgumentException();
            }
            catch(InputMismatchException e){
                System.out.println((i+1)+"번째 가구 소득이 숫자가 아니다.");
                sc.next();
                isError = true;
                errPos = i;
                break;
            }
            catch(IllegalArgumentException e){
                System.out.println((i+1)+"번째 가구 소득이 음수이다.");
                sc.next();
                isError = true;
                errPos = i;
                break;
            }
        }
        if(!isError){
            int num =0;
            for(int i=0;i<hNum;i++){
                if(hEarns[i]<maxNum/10)num++;
            }
            System.out.println("최대 가구 소득: "+maxNum +"\n최대 가구 소득의 10%: "+maxNum/10 + "\n가구들의 수: "+num);
        }
        else{
            for(int i=0;i<errPos;i++){
                System.out.print(hEarns[i]+" ");
            }
        }
    }
}
