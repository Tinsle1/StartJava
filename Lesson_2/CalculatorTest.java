import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String userAnswer;
        do {
            System.out.print("Введите первое число: ");
            calculator.setFirstOperand(console.nextInt());
            console.nextLine();
            int firstOperand = calculator.getFirstOperand();

            char mathSign;
            do {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                mathSign = console.next().charAt(0);
            } while (!calculator.setMathSign(mathSign));
        
            System.out.print("Введите второе число: ");
            calculator.setSecondOperand(console.nextInt());
            console.nextLine();
            int secondOperand = calculator.getSecondOperand();

            calculator.calculate();

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                userAnswer = console.nextLine();
            } while (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no"));
        } while (userAnswer.equalsIgnoreCase("yes"));
    }
}