package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReversedTransactionsPrinter {
    public static void main(String[] args) {
        int[][] transactions = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };

        for (int[] currentTransaction : transactions) {
            if (currentTransaction == null) {
                System.out.println("Ошибка в данных\n");
                continue;
            }

            if (currentTransaction.length == 0) {
                System.out.println("Нет данных для вычисления\n");
                continue;
            }

            int[] reverseTransactions = reverseTransactions(currentTransaction);
            printTransactions("Исходные транзакции: ", currentTransaction);
            printTransactions(" В обратном порядке: ", reverseTransactions);
            System.out.println();
        }
    }

    private static int[] reverseTransactions(int[] transactions) {
        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int reversedTransaction : transactions) {
            reversedTransactions[--length] = reversedTransaction;
        }
        return reversedTransactions;
    }

    private static void printTransactions(String text, int[] transactions) {
        System.out.println(text + Arrays.toString(transactions));
    }
}




