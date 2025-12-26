package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class Nullification {
    private static final int ARRAY_SIZE = 15;

    public static void main(String[] args) {
        float[] originalNumbers = createRandomNumbers();
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            float[] changedNumbers = changeNumbers(index, originalNumbers);
            printNumbers(index, originalNumbers, changedNumbers);
        }
    }

    private static float[] createRandomNumbers() {
        float[] numbers = new float[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextFloat();
        }
        return numbers;
    }

    private static float[] changeNumbers(int index, float[] numbers) {
        float[] changedNumbers = Arrays.copyOf(numbers, numbers.length);

        if (index < 0 || index >= numbers.length) {
            return changedNumbers;
        }

        float changedNumber = changedNumbers[index];

        for (int i = 0; i < changedNumbers.length; i++) {
            if (changedNumbers[i] > changedNumber) {
                changedNumbers[i] = 0;
            }
        }
        return changedNumbers;
    }

    private static void printNumbers(int index, float[] originalNumbers, float[] changedNumbers) {
        if (index < 0 || index >= originalNumbers.length) {
            System.out.printf(
                    "Ошибка: индекс %d выходит за допустимые пределы [0; %d]%n",
                    index, originalNumbers.length - 1);
            return;
        }
        System.out.println("\nОригинальный массив");
        printArray(originalNumbers);

        System.out.println("\nИзмененный массив");
        printArray(changedNumbers);

        System.out.printf("\nЗначение из ячейки [%d]: %.3f%n", index, changedNumbers[index]);
    }

    private static void printArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);

            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}