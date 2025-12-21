package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Nullification {

    private static final int arraySize = 15;

    public static void main(String[] args) {

        double[] originalNumbers = addDoubleNumbers();

        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            double[] changedNumbers = changeNumbers(index, originalNumbers);
            printNumbers(index, originalNumbers, changedNumbers);
        }
    }

    private static double[] addDoubleNumbers() {
        double[] numbers = new double[arraySize];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextDouble();
        }
        return numbers;
    }

    private static double[] changeNumbers(int index, double[] numbers) {

        double[] copyNumbers = new double[numbers.length];
        System.arraycopy(numbers, 0, copyNumbers, 0, numbers.length);

        if (index < 0 || index >= numbers.length) {
            return copyNumbers;
        }

        double value = copyNumbers[index];

        for (int i = 0; i < copyNumbers.length; i++) {
            if (copyNumbers[i] > value) {
                copyNumbers[i] = 0;
            }
        }
        return copyNumbers;
    }

    private static void printNumbers(int index,
                                     double[] originalNumbers,
                                     double[] changedNumbers) {

        System.out.println("\nОРИГИНАЛЬНЫЙ МАССИВ");
        printArray(originalNumbers);

        System.out.println("\nИзмененный массив");
        printArray(changedNumbers);

        if (index < 0 || index >= originalNumbers.length) {
            System.out.printf(
                    "Ошибка: индекс %d выходит за допустимые пределы [0; %d]%n",
                    index, originalNumbers.length - 1);
        } else {
            System.out.printf(
                    "Значение по индексу %d в исходном массиве = %.3f%n" +
                            "Значение по индексу %d в измененном массиве = %.3f%n",
                    index, originalNumbers[index],
                    index, changedNumbers[index]);
        }
    }

    private static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);

            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}