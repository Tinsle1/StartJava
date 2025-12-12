package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialCalculator {
    public static void main(String[] args) {

        int[][] numberSet = {
                {},
                null,
                {-5},
                {21, 0, 7},
                {1, 20, 5, -3}
        };

        for (int[] numbers : numberSet) {
            printFactorials(numbers);
        }
    }

    private static long[] calculateFactorials(int[] numbers) {
        long[] factorials = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number < 0 || number > 20) {
                continue;
            }

            long factorial = 1;

            for (int j = 2; j <= number; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void printFactorials (int[] numbers) {
        System.out.println(Arrays.toString(numbers));

        if (numbers == null) {
            System.out.println("Ошибка в данных\n");
            return;
        }

        if (numbers.length == 0) {
            System.out.println("Нет данных для вычисления\n");
            return;
        }

        long[] factorials =  calculateFactorials(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            long factorial = factorials[i];

            if (number < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", number);
                continue;
            }

            if (number > 20) {
                System.out.printf("Ошибка: факториал %d! не определен%n", number);
                continue;
            }

            StringBuilder factorialExpression = new StringBuilder ();

            for (int j = 1; j <= number; j++) {
                factorialExpression.append(j < number ? j + " * ": j );
            }

            String expression = (number == 0 || number == 1) ?
                    number + "! = 1":
                    number + "! = " + factorialExpression + " = " + factorial;

            System.out.println(expression);
        }
        System.out.println();
    }
}