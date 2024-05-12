class BasicPayCalculator{
    int weekdayTime,weekdayPay;
    float pay=0;
    BasicPayCalculator(int weekdayPay){
        this.weekdayPay = weekdayPay;
        weekdayTime=0;
    }
    void AddWorkTime(int time){
        this.weekdayTime+=time;
    }
    void setWeekdayTime(int weekdayTime){
        this.weekdayTime = weekdayTime;
    }
    void setWeekdayPay(int weekdayPay){
        this.weekdayPay = weekdayPay;
    }
    void CalculatePay(){
        if(weekdayTime<=40)pay+=weekdayPay * weekdayTime;
        if(weekdayTime>40)pay+=weekdayPay*40+(weekdayTime-40)*(weekdayPay*1.5f);
    }
}
class OverPayCaclulator extends BasicPayCalculator{
    int saturdayTime,sundayTime;
    OverPayCaclulator(int weekdayPay){
        super(weekdayPay);
        weekdayTime = 0;
        saturdayTime = 0;
        sundayTime = 0;
    }
    void setSaturdayTime(int time){
        this.saturdayTime = time;
    }
    void setSundayTime(int time){
        this.sundayTime = time;
    }
    void CalculatePay(){
        pay+=saturdayTime*(weekdayPay*2);
        pay+=sundayTime*(weekdayPay*3);
        super.CalculatePay();
    }
}
class DangerPayCalculator extends BasicPayCalculator{
    int dangerTime;
    DangerPayCalculator(int weekdayPay){
        super(weekdayPay);
        weekdayTime=0;
        dangerTime=0;
    }
    void setDangerTime(int time){
        dangerTime = time;
    }
    void CalculatePay(){
        pay+=dangerTime*weekdayPay*5;
        super.CalculatePay();
    }
}
public class Driver {
    public static void main(String[] args){
        OverPayCaclulator Op1 = new OverPayCaclulator(8000);
        Op1.AddWorkTime(50);
        Op1.setSaturdayTime(6);
        Op1.setSundayTime(2);
        Op1.CalculatePay(); 
        System.out.println("주말 근무 직원의 주급: "+Op1.pay);

        DangerPayCalculator Dp1 = new DangerPayCalculator(10000);
        Dp1.AddWorkTime(36);
        Dp1.setDangerTime(6);
        Dp1.CalculatePay();
        System.out.println("위험 근무 직원의 주급: "+Dp1.pay);
    }
}
