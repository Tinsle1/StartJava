package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_RESET = "[0m";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10:");
                String expression = console.nextLine();
                try {
                    double result = Calculator.calculate(expression);
                    Calculator.printResult(expression, result);
                } catch (Exception e) {
                    System.out.println(ANSI_RED +
                            "Ошибка: " + e.getMessage() +
                            ANSI_RESET);
                }

                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = console.nextLine().toLowerCase();
        } while (!answer.equals("no"));
    }
}
