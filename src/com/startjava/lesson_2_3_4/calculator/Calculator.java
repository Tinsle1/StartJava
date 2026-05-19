package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;

public class Calculator {
    private static final int ARGUMENTS_COUNT = 3;
    private static final DecimalFormat DF = new DecimalFormat("#.###");

    public static double calculate(String expression) {
        String[] tokens = tokenize(expression);

        checkArgumentsCount(tokens);

        int firstOperand = parseOperand(tokens[0]);
        int secondOperand = parseOperand(tokens[2]);
        String mathSign = tokens[1];

        return calculate(firstOperand, mathSign, secondOperand);
    }

    private static double calculate(int firstOperand, String mathSign, int secondOperand) {
        return switch (mathSign) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "%" -> {
                checkDivisionByZero(secondOperand);
                yield Math.floorMod(firstOperand, secondOperand);
            }
            case "^" -> Math.pow(firstOperand, secondOperand);
            case "/" -> {
                checkDivisionByZero(secondOperand);
                yield (double) firstOperand / secondOperand;
            }
            default ->
                throw new UnsupportedOperationException(
                        "Ошибка: " + "операция " + mathSign +
                                " не поддерживается");
        };
    }

    private static int parseOperand(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "Ошибка: " + value + " не является целым числом");
        }
    }

    private static String[] tokenize(String expression) {
        return expression.trim().split("\\s+");
    }

    private static void checkArgumentsCount(String[] tokens) {
        if (tokens.length != ARGUMENTS_COUNT) {
            throw new IllegalArgumentException(
                    "Ошибка: неверный формат выражения"
            );
        }
    }

    private static void checkDivisionByZero(int secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException(
                    "Деление на ноль запрещено"
            );
        }
    }

    public static void printResult(String expression, double result) {
        System.out.printf("%s = %s%n", String.join(" ", tokenize(expression)), DF.format(result));
    }
}