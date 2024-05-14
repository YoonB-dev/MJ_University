class taxpayer{
    String name;
    int num;
    float taxAmount;
    taxpayer(String name,int num){
        this.name = name;
        this.num = num;
    }
    String showTax(){
        return name + "의 세금: " + taxAmount;
    }
}
class wage extends taxpayer{
    int monthPay;
    wage(String name,int num,int monthPay){
        super(name,num);
        this.monthPay = monthPay;
        CalculateTax();
    }
    void CalculateTax(){
        int yearPay = monthPay*12;
        if(yearPay<=20000000)taxAmount = yearPay*0.05f;
        else if(yearPay<=40000000)taxAmount = yearPay*0.1f;
        else if(yearPay<=60000000)taxAmount = yearPay*0.15f;
        else if(yearPay<=80000000)taxAmount = yearPay*0.2f;
        else taxAmount = yearPay*0.3f;
    }
    String showInfo(){
        return "이름: " + name + "  번호: " + num + "   월급: " + monthPay;
    }
}
class business extends taxpayer{
    int totalSales,totalCost;
    business(String name,int num,int totalSales,int totalCost){
        super(name, num);
        this.totalSales = totalSales;
        this.totalCost = totalCost;
        CalculateTax();
    }
    void CalculateTax(){
        int amount = totalSales - totalCost;
        if(amount<=0)taxAmount=0;
        else if(amount<=40000000)taxAmount = amount*0.1f;
        else taxAmount = amount*0.2f;
    }
    String showInfo(){
        return "이름: " + name + "  번호: " + num + "   총매출액: " + totalSales + "    총 비용: "+totalCost;
    }
}
public class Driver {
    public static void main(String[] args){
        wage W1 = new wage("선남", 100, 3000000);
        System.out.println(W1.showInfo()+"\n"+W1.showTax());

        business B1 = new business("선녀", 200, 120000000, 75000000);
        System.out.println(B1.showInfo() + "\n" + B1.showTax());
    }
}
