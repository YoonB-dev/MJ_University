import java.util.*;

class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("0혹은 0 에 아주 가까운 값으로 나누려고 시도하여 프로그램이 중단되었습니다.");
    }
    public DivideByZeroException(String message) {
        super(message);
    }
}
class UnknownOpException extends Exception {
    public UnknownOpException() {
        super("허용되지 않는 연산자로 인한 예외");
    }
    public UnknownOpException(char op) {
        super(op + "는 허용되지 않는 연산자이다.");
    }
    public UnknownOpException(String message) {
        super(message);
    }
}
class Calculator {
    private double result;
    public Calculator() {
        this.result = 0;
    }
    public double returnResult() {
        return result;
    }
    public void changeResult(double result) {
        this.result = result;
    }
    public void doCalculation() {
        Scanner sc = new Scanner(System.in);
        String num;
        char operator;
        double operand;

        System.out.println("계산기 시작합니다.\n연산식을 나타내는 각 라인(line)의 포맷:연산자 숫자\n예:+3\n끝내려면 e(혹은 E)를 입력하세요.");
        
        while (true) {
            num = sc.nextLine();
            if (num.equalsIgnoreCase("e")) break;

            operator = num.charAt(0);
            operand = Double.parseDouble(num.substring(2));
            
            try {
                performOperation(operator, operand);
            } catch (DivideByZeroException | UnknownOpException e) {
                System.out.println(e.getMessage());
                if (e instanceof DivideByZeroException) {
                    System.exit(0);
                } else {
                    doCalculation();
                    return;
                }
            }
        }
        System.out.println("계산기 프로그램을 종료합니다.");
    }

    private void performOperation(char op, double operand) throws DivideByZeroException, UnknownOpException {
        switch (op) {
            case '+':
                result += operand;
                break;
            case '-':
                result -= operand;
                break;
            case '*':
                result *= operand;
                break;
            case '/':
                if (Math.abs(operand) < 0.0001) {
                    throw new DivideByZeroException();
                }
                result /= operand;
                break;
            default:
                throw new UnknownOpException(op);
        }
        System.out.println("result " + op + " " +operand + " = "+ result +"\n갱신된 result = " + result);
    }   
}

public class Driver {
    static public void main(String[] args){
        Calculator calc = new Calculator();
        calc.doCalculation();
    }
}
