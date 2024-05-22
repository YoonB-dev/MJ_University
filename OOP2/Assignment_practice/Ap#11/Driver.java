import java.util.*;

class Student{
    String name;
    int id;
    Student(String name,int num){
        this.name = name;
        this.id = num;
    }
    String returnInfo(){
        return "    "+id + "   "  + name;
    }
}
class TimeInUseException extends Exception{
    TimeInUseException(String e){
        System.out.println(e);
    }
}
class InvalidTimeException extends Exception{
    InvalidTimeException(String e){
        System.out.println(e);
    }
}
public class Driver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[7];
        System.out.println("상담 시간 예약하기\n가능한 상담 시간: 오후 1시, 2시, 3시, 4시, 5시, 6시");

        //입력
        for(int i=1;i<students.length;){
            System.out.print("학생의 학번을 입력하세요: ");
            int sNum = sc.nextInt();
            System.out.print("\n학생의 이름을 입력하세요: ");
            String sName = sc.next();
            
            System.out.print("\n원하는 상담 시간<1, 2, 3, 4, 5, 6 중 선택>: ");
            int sTime=0;
            try{
                sTime = sc.nextInt();
                
                if(sTime<7 && students[sTime]!=null)throw new TimeInUseException("선택한 시간은 이미 예약됨");
                if(sTime>=7 || sTime<1)throw new InvalidTimeException("선택한 시간이 범위 밖에 있음");
                
                students[sTime] = new Student(sName, sNum);
                System.out.println("인덱스:"+i);
                i++;
            }
            catch(TimeInUseException e){
                
            }
            catch(InvalidTimeException e){
                
            }
            catch(InputMismatchException e){
                System.out.println("예외 처리함: 시간은 정수여야합니다.");
                sc.next();
            }
        }
        //출력
        System.out.println("상담 시간   학번    이름");
        for(int i=1;i<students.length;i++){
            System.out.println( i+"  "+students[i].returnInfo());
        }
        sc.close();
    }
}
