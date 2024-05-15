import java.util.*;

class TestQuestion{
    String question;
    int questionNum;
    void readQuestion(){}
    void showQuestion(){}
}
class Essay extends TestQuestion{
    int blankNum;
    void readQuestion(){
        Scanner sc = new Scanner(System.in);
        blankNum = sc.nextInt();sc.nextLine();
        question = sc.nextLine();
    }
    void showQuestion(){
        System.out.println(questionNum+". "+question);
    }
}
class MultipleChoice extends TestQuestion{
    String[] answers;
    void readQuestion(){
        Scanner sc = new Scanner(System.in);
        int answerNum = sc.nextInt();sc.nextLine();
        question = sc.nextLine();
        answers = new String[answerNum];
        for(int i=0;i<answerNum;i++){
            answers[i] = sc.nextLine();
        }
    }
    void showQuestion(){
        System.out.println(questionNum+". "+question);
        for(int i=0;i<answers.length;i++){
            System.out.println(answers[i]);
        }
    }
}

public class Driver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int questinoNum = sc.nextInt();
        TestQuestion[] Ts = new TestQuestion[questinoNum];
        for(int i=0;i<questinoNum;i++){
            String type = sc.next();
            if(type.equals("e")){
                Essay E = new Essay();
                E.readQuestion();
                E.questionNum = i+1;
                Ts[i] = E;
            }
            else if(type.equals("m")){
                MultipleChoice M = new MultipleChoice();
                M.readQuestion();
                M.questionNum = i+1;
                Ts[i] = M;
            }
        }
        sc.close();
        System.out.println("\n\n<문제>");
        for(int i=0;i<questinoNum;i++){
            Ts[i].showQuestion();
        }
    }
}


