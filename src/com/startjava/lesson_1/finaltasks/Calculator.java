package com.startjava.lesson_1.finaltasks;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите числа: ");
        int firstOperand = console.nextInt();
        char mathSign = console.next().charAt(0);
        int secondOperand = console.nextInt();
        int result = firstOperand + secondOperand;
      
        if (mathSign == '-') {
            result = firstOperand - secondOperand;
        } else if (mathSign == '*') {
            result = firstOperand * secondOperand;
        } else if (mathSign == '/') {
            result = firstOperand / secondOperand;
        } else if (mathSign == '%') {
            result = firstOperand % secondOperand;
        } else if (mathSign == '^') {
            result = 1;
            for (int i = 0; i < secondOperand; i++) {
                result *= firstOperand;
            }
        }
        System.out.println(firstOperand + " " + mathSign + " " +
                secondOperand + " = " + result);
    } 
}

