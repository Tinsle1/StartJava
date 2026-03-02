package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        int[][] boundsWithCount = {
                {-30, -10, 23},
                {10, 50, 10},
                {-34, -34, 1},
                {-1, 2, -3},
                {5, -8, 2}
        };

        for (int[] numbers : boundsWithCount) {
            int lowerBound = numbers[0];
            int upperBound = numbers[1];
            int numbersPerLine = numbers[2];

            if (numbersPerLine < 1) {
                System.out.printf(
                        "Ошибка: количество чисел в строке не должно быть < 1 (%d)%n",
                        numbersPerLine);
                continue;
            }

            if (lowerBound > upperBound) {
                System.out.printf(
                        "Ошибка: левая граница (%d) > правой (%d)%n",
                        lowerBound, upperBound);
                continue;
            }

            int[] uniqueRandomNumbers = createSortedUniqueRandomNumbers(lowerBound, upperBound);
            System.out.println(printAscendingNumbers(uniqueRandomNumbers, numbersPerLine));
        }
    }

    private static int[] createSortedUniqueRandomNumbers(int lowerBound, int upperBound) {
        int segmentLength = upperBound - lowerBound + 1;
        int length = (int) (segmentLength * 0.75);

        int[] uniqueNumbers = new int[length];

        if (length == 0) {
            System.out.printf(
                    "Ошибка: длина массива должна быть > 0 (%d)", length);
            return new int[0];
        }

        Random random = new Random();

        for (int i = 0; i < uniqueNumbers.length; i++) {
            boolean isUnique = false;

            while (!isUnique) {
                int randomNumber = random.nextInt(lowerBound, upperBound + 1);
                isUnique = true;

                for (int j = 0; j < i; j++) {
                    if (uniqueNumbers[j] == randomNumber) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    uniqueNumbers[i] = randomNumber;
                }
            }
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static String printAscendingNumbers(int[] numbers, int numbersPerLine) {
        StringBuilder lineConstructor = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            lineConstructor.append(numbers[i]).append(" ");
            if ((i + 1) % numbersPerLine == 0) {
                lineConstructor.append("\n");
            }
        }
        return lineConstructor.toString();
    }
}