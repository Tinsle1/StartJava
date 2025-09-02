import java.util.Scanner;

public class Calculator {
    Scanner console = new Scanner(System.in);
    private int firstOperand;
    private char mathSign;
    private int secondOperand;

    // геттер для operand
    public int getOperand(int count) {
        int operand = console.nextInt();
        if (count == 1) {
            firstOperand = operand;
        } else if (count == 2) {
            secondOperand = operand;
        }
        return operand;
    }

    // геттер для mathSign
    public char getMathSign() {
        mathSign = console.next().charAt(0);
        return mathSign;
    }

    // метод для вычисления и вывода результата
    public int calculate(int firstOperand, char mathSign, int secondOperand) {
        this.firstOperand = firstOperand;
        this.mathSign = mathSign;
        this.secondOperand = secondOperand;
        int result = 0;

        switch (mathSign) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '%':
                result = firstOperand % secondOperand;
                break;
            case '/':
                if (secondOperand == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return 0;
                } else {
                    result = firstOperand / secondOperand;
                    break;
                }
            default:
                System.out.println("Ошибка: операция " + "'" + mathSign + "'" +
                        " не поддерживается");
                return 0;
        }
        System.out.printf("%d %c %d = %d%n", firstOperand, mathSign, secondOperand, result);

        return result;
    }
}