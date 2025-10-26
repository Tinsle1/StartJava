package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialCalculator {
    public static void main(String[] args) {
        calculateFactorials(
                new int[]{},
                null,
                new int[]{-5},
                new int[]{21, 0, 7},
                new int[]{1, 20, 5, -3}
        );
    }

    private static void calculateFactorials(int[]... numbersArrayList) {
        for (int[] numbersArray : numbersArrayList) {
            System.out.println(Arrays.toString(numbersArray));

            if (numbersArray == null) {
                System.out.println("Ошибка в данных\n");
                continue;
            }

            if (numbersArray.length == 0) {
                System.out.println("Нет данных для вычисления\n");
                continue;
            }

            long[] factorialArray = new long[numbersArray.length];

            for (int i = 0; i < numbersArray.length; i++) {
                int number = numbersArray[i];

                long factorial = 1;

                if (number == 0) {
                    factorialArray[i] = 1;
                } else if (number < 0) {
                    System.out.printf("Ошибка: факториал %d! не определен\n", number);
                    continue;
                } else if (number > 20) {
                    System.out.printf("Ошибка: факториал %d! слишком велик (максимум 20!)\n", number);
                    continue;
                }

                String factorialExpression = "";

                for (int j = 1; j <= number; j++) {
                    factorial *= j;
                    factorialExpression += (j == number) ? j : j + " * ";
                }
                factorialArray[i] = factorial;

                String factorialResult = (number == 0)
                        ? "0! = 1"
                        : number + "! = " + factorialExpression + " = " + factorial;

                System.out.println(factorialResult);
            }
            System.out.println();
        }
    }
}
