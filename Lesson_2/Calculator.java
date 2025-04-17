import java.util.Scanner;

public class Calculator {
    Scanner console = new Scanner(System.in);
    private int firstOperand;
    private char mathSign;
    private int secondOperand;
    private int result;
    private String userAnswer;
    private boolean isTrueMathSign;
    private boolean isDivideByZero;
    private boolean isExit;

    // геттер для firstOperand
    public int getFirstOperand() {
        firstOperand = console.nextInt();
        return firstOperand;
    }

    // геттер для getMathSign с проверкой знака
    public char getMathSign() {
        mathSign = console.next().charAt(0);
        isTrueMathSign = true;

        switch (mathSign) {
            case '+':
                return mathSign;

            case '-':
                return mathSign;

            case '*':
                return mathSign;

            case '/':
                return mathSign;

            case '%':
                return mathSign;

            case '^':
                return mathSign;

            default:
                System.out.println("Ошибка: операция " + "'" + mathSign + "'" +
                        " не поддерживается");
                isTrueMathSign = false;
                break;
        }
        return mathSign;
    }

    // геттер для статуса знака
    public boolean getIsTrueMathSign() {
        return isTrueMathSign;
    }

    // геттер для secondOperand
    public int getSecondOperand() {
        secondOperand = console.nextInt(); 
        return secondOperand;
    }

    // геттер для результата вычислений result
    public int getResult(int firstOperand, char mathSign, int secondOperand) {
        this.firstOperand = firstOperand;
        this.mathSign = mathSign;
        this.secondOperand = secondOperand;
        isDivideByZero = false;

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

            case '/':
                if (secondOperand == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    isDivideByZero = true;
                } else {
                    result = firstOperand / secondOperand;
                }
                break;

            case '%':
                result = firstOperand % secondOperand;
                break;

            default:
        }

        System.out.println(firstOperand + " " + mathSign + " " +
                secondOperand + " = " + result);
        return result;
    }

    // геттер для статуса операции деления на ноль
    public boolean getIsDivideByZero() {
        return isDivideByZero;
    }

    // геттер для значения ответа пользователя userAnswer
    public String getUserAnswer() {
        userAnswer = console.nextLine();
        return userAnswer;
    } 
}