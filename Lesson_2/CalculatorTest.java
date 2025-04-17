
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.print("Введите первое число: ");
        int calcFirstOperand = calculator.getFirstOperand();

        char calcMathSign;
        boolean calcIsTrueMathSign;
        boolean isDivideByZero;
        int calcSecondOperand;
        String calcUserAnswer;

        // здесь на поняла, как делать через do while или просто while 
        do {
            do {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                calcMathSign = calculator.getMathSign();
                calcIsTrueMathSign = calculator.getIsTrueMathSign();
            } while (!calcIsTrueMathSign);

            do {
                System.out.print("Введите второе число: ");
                calcSecondOperand = calculator.getSecondOperand();
                isDivideByZero = calculator.getIsTrueMathSign();
            } while (!isDivideByZero);
          
            int calcResult = calculator.getResult(calcFirstOperand, calcMathSign, calcSecondOperand);
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            calcUserAnswer = calculator.getUserAnswer();
        } while (calcUserAnswer.equalsIgnoreCase("no"));
    }
}