package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_TOKENS_COUNT = 3;

    public static double calculate(String expression) {
        String[] tokens = tokenize(expression);

        throwIfInvalidTokensCount(tokens);
        throwIfDivByZero(tokens);

        int firstOperand = parseOperand(tokens[0]);
        int secondOperand = parseOperand(tokens[2]);
        String mathSign = tokens[1];

        return evaluate(firstOperand, mathSign, secondOperand);
    }

    private static String[] tokenize(String expression) {
        return expression.trim().split("\\s+");
    }

    private static void throwIfInvalidTokensCount(String[] tokens) {
        if (tokens.length != EXPRESSION_TOKENS_COUNT) {
            throw new IllegalArgumentException(
                    "неверный формат выражения"
            );
        }
    }

    private static void throwIfDivByZero(String[] tokens) {
        if ("0".equals(tokens[2]) && ("%".equals(tokens[1]) ||
                "/".equals(tokens[1]))) {
            throw new ArithmeticException(
                    "Деление на ноль запрещено"
            );
        }
    }

    private static int parseOperand(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    value + " не является целым числом");
        }
    }

    private static double evaluate(int firstOperand, String mathSign, int secondOperand) {
        return switch (mathSign) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "%", "/" ->
                    calculateDivOrMod(firstOperand,
                            mathSign, secondOperand);

            case "^" -> Math.pow(firstOperand, secondOperand);
            default ->
                throw new UnsupportedOperationException(
                        "операция " + mathSign +
                                " не поддерживается");
        };
    }

    private static double calculateDivOrMod(int firstOperand,
                                                    String mathSign, int secondOperand) {
        if ("%".equals(mathSign)) {
            return Math.floorMod(firstOperand, secondOperand);
        }
        return (double) firstOperand / secondOperand;
    }
}