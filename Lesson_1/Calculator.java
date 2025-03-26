import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите числа: ");
        int firstOperand = console.nextInt();
        char charOperator = console.next().charAt(0);
        int secondOperand = console.nextInt();
        int result = firstOperand + secondOperand;
      
        if (charOperator == '-') {
            result = firstOperand - secondOperand;
        } else if (charOperator == '*') {
            result = firstOperand * secondOperand;
        } else if (charOperator == '/') {
            result = firstOperand / secondOperand;
        } else if (charOperator == '%') {
            result = firstOperand % secondOperand;
        } else if (charOperator == '^') {
            result = 1;
            for (int i = 0; i < secondOperand; i++) {
                result = result * firstOperand;
            }
        }
        System.out.println(firstOperand + " " + charOperator + " " +
                secondOperand + " = " + result);
    } 
}

