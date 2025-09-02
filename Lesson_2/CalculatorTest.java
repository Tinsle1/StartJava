import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String calcUserAnswer = "yes";
        boolean calcIsTrueMathSign;
        char calcMathSign;
        int calcFirstOperand;
        int calcSecondOperand;

        do {
            System.out.print("Введите первое число: ");
            calcFirstOperand = calculator.getOperand(1);

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calcMathSign = calculator.getMathSign();

            System.out.print("Введите второе число: ");
            calcSecondOperand = calculator.getOperand(2);
            calculator.calculate(calcFirstOperand, calcMathSign, calcSecondOperand);

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            calcUserAnswer = console.nextLine();
        } while (!calcUserAnswer.equalsIgnoreCase("no"));
    }
}