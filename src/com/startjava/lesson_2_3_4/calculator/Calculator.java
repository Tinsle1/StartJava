package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_RESET = "[0m";
    private static final int ARGUMENTS_COUNT = 3;

    public double calc(String expression) {
        String[] tokens = tokenize(expression);

        if (!hasValidArgumentsCount(tokens)) {
            return Double.NaN;
        }

        int firstOperand = Integer.parseInt(tokens[0]);
        int secondOperand = Integer.parseInt(tokens[2]);
        char mathSign = tokens[1].charAt(0);

        return calculate(firstOperand, mathSign, secondOperand);
    }

    private String[] tokenize(String expression) {
        return expression.trim().split("\\s+");
    }

    private boolean hasValidArgumentsCount(String[] tokens) {
        if (tokens.length != ARGUMENTS_COUNT) {
            System.out.println(ANSI_RED + "Ошибка: неверный формат" + ANSI_RESET);
            return false;
        }
        return true;
    }

    private double calculate(int firstOperand, char mathSign, int secondOperand) {
        return switch (mathSign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '%' -> {
                if (secondOperand == 0) {
                    System.out.println(ANSI_RED +
                            "Ошибка: деление на ноль запрещено" +
                            ANSI_RESET);

                    yield Double.NaN;
                }

                yield Math.floorMod(firstOperand, secondOperand);
            }
            case '^' -> Math.pow(firstOperand, secondOperand);
            case '/' -> {
                if (secondOperand == 0) {
                    System.out.println(ANSI_RED +
                            "Ошибка: деление на ноль запрещено" +
                            ANSI_RESET);
                    yield Double.NaN;
                }
                yield (double) firstOperand / secondOperand;
            }
            default -> {
                System.out.println(ANSI_RED + "Ошибка: операция '" +
                        mathSign + "' не поддерживается" + ANSI_RESET);
                yield Double.NaN;
            }
        };
    }
}