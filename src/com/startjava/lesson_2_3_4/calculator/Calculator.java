package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_RESET = "[0m";
    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final char[] VALID_SIGNS = {
            '+', '-', '*', '/', '%', '^'};
    DecimalFormat df = new DecimalFormat("#.###");

    public void calc() {
        while (true) {
            String expression = inputExpression();
            String[] tokens = tokenize(expression);

            if (!isArgumentsEnough(tokens)) {
                continue;
            }

            int firstOperand = Integer.parseInt(tokens[0]);
            int secondOperand = Integer.parseInt(tokens[2]);
            char mathSign = tokens[1].charAt(0);

            if (!isMathSign(mathSign)) {
                continue;
            }

            double result = calculate(firstOperand, mathSign, secondOperand);
            printResult(firstOperand, mathSign, secondOperand, result);

            break;
        }
    }

    private String inputExpression() {
        System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10:");
        return CONSOLE.nextLine();
    }

    private String[] tokenize(String expression) {
        return expression.trim().split("\\s+");
    }

    private boolean isArgumentsEnough(String[] tokens) {
        if (tokens.length != 3) {
            System.out.println(ANSI_RED + "Ошибка: неверный формат" + ANSI_RESET);
            return false;
        }
        return true;
    }

    private boolean isMathSign(char mathSign) {
        for (char sign : VALID_SIGNS) {
            if (mathSign == sign) {
                return true;
            }
        }
        System.out.println(ANSI_RED + "Ошибка: операция '" + mathSign + "' не поддерживается\n" + ANSI_RESET);
        return false;
    }

    private double calculate(int firstOperand, char mathSign, int secondOperand) {
        double result = 0.0;
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
                result = Math.floorMod(firstOperand, secondOperand);
                break;
            case '^':
                result = Math.pow(firstOperand, secondOperand);
                break;
            case '/':
                if (secondOperand == 0) {
                    return Double.NaN;
                } else {
                    result = (double) firstOperand / secondOperand;
                    break;
                }
            default:
                break;
        }
        return result;
    }

    private void printResult(int firstOperand, char mathSign, int secondOperand, double result) {
        if (Double.isNaN(result)) {
            System.out.println(ANSI_RED + "Ошибка: математически некорректная операция" + ANSI_RESET);
            return;
        }

        System.out.printf("%d %c %d = %s%n", firstOperand, mathSign, secondOperand, df.format(result));
    }
}