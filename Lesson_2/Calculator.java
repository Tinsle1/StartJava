public class Calculator {
    private int firstOperand;
    private char mathSign;
    private int secondOperand;

    // геттер для firstOperand
    public int getFirstOperand() {
        return firstOperand;
    }

    // сеттер для firstOperand
    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    // геттер для secondOperand
    public int getSecondOperand() {
        return secondOperand;
    }

    // сеттер для secondOperand
    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    // геттер для mathSign
    public char getMathSign() {
        return mathSign;
    }

    // сеттер для mathSign
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

    // метод для вычисления и вывода результата
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