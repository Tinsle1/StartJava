package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10:");
                String expression = console.nextLine();
                Calculator calculator = new Calculator();
                double result = calculator.calc(expression);

                if (!Double.isNaN(result)) {
                    System.out.printf("%s = %s%n", expression, df.format(result));
                }
            } else {
                System.out.println("Введите корректный ответ [yes / no]");
            }

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = console.nextLine().toLowerCase();
        } while (!answer.equals("no"));
    }
}