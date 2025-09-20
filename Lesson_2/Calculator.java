public class Calculator {
    private int firstOperand;
    private char mathSign;
    private int secondOperand;

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public boolean setMathSign(char mathSign) {
        if (mathSign == '+' || mathSign == '-' || mathSign == '*' ||
                mathSign == '/' || mathSign == '%' || mathSign == '^') {
            this.mathSign = mathSign;
            return true;
        } else {
            System.out.println("Ошибка: операция '" + mathSign + "' не поддерживается");
            return false;
        }
    }

    public void calculate() {
        int result = 0;
        double negativePowerResult = 1;
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
            case '^':
                result = 1;
                for (int i = Math.abs(secondOperand); i > 0; i--) {
                    result *= firstOperand;
                }
                
                if (secondOperand < 0) {
                    negativePowerResult /= result;
                }
                break;
            case '/':
                if (secondOperand == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                } else {
                    result = firstOperand / secondOperand;
                    break;
                }
        }
        if (mathSign == '^' && secondOperand < 0) {
            System.out.printf("%d %c %d = %f%n", firstOperand, mathSign, secondOperand, negativePowerResult);
        } else {
            System.out.printf("%d %c %d = %d%n", firstOperand, mathSign, secondOperand, result);
        }
    }
}