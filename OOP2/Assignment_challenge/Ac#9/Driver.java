class Course{
    String name,num;
    Course(String name,String num){
        this.name = name;
        this.num = num;
    }
    String getName(){
        return name;
    }
    String getNum(){
        return num;
    }
    void changeName(String name){
        this.name = name;
    }
    void changeNum(String num){
        this.num = num;
    }
    String getAllData(){
        return "";
    }
}
class GenEdu extends Course{
    String type;
    GenEdu(String name,String num,String type){
        super(name, num);
        this.type = type;
    }
    String getType(){
        return type;
    }
    String getAllData(){
        return "\n교과목명: "+name +"\n교과목 번호: " + num + "\n이수 구분: " + type + "\n";
    }
    void changeType(String type){
        this.type = type;
    }
}
class Major extends Course{
    String major,proced;
    Major(String name,String num,String major,String proced){
        super(name,num);
        this.major = major;
        this.proced = proced;
    }
    String getMajor(){
        return major;
    }
    String getProced(){
        return proced;
    }
    String getAllData(){
        return "\n교과목명: "+name +"\n교과목 번호: " + num + "\n전공: " + major + "\n선수 과목: "+ proced+"\n";
    }
}
class Elective extends Course{
    Elective(String name,String num){
        super(name, num);
    }
    String getAllData(){
        return "\n교과목명: "+name +"\n교과목 번호: "+num+"\n";
    }
}

public class Driver {
    public static void main(String[] args){
        Course[] Cs = new Course[10];
        Cs[0] = new Major("자바", "CS101", "컴퓨터공학", "C");
        Cs[1] = new Major("이산 수학", "CS215", "컴퓨터공학", "없음");
        Cs[2] = new GenEdu("물리학","PHS210","학문기초교양");
        Cs[3] = new GenEdu("영어 1","ENG101","공통 교양");
        Cs[4] = new Elective("테니스", "REC310");

        for(int i=0;i<4;i++){
            System.out.println(Cs[i].getAllData());
        }
        System.out.println("선택 과목: \n"+Cs[4].getAllData());
    }
}
