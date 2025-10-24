package com.startjava.lesson_2_3_4.array;

public class ReversedTransactionsPrinter {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        int[] transactions2 = null;
        int[] transactions3 = {5};
        int[] transactions4 = {6, 8, 9, 1};
        int[] transactions5 = {13, 8, 5, 3, 2, 1, 1};
        int[][] transactions = {transactions1, transactions2, transactions3,
                transactions4, transactions5};

        for (int[] currentTransaction : transactions) {
            if (currentTransaction == null) {
                System.out.println("Ошибка в данных\n");
                continue;
            }

            if (currentTransaction.length == 0) {
                System.out.println("Данных о транзакциях нет\n");
                continue;
            }

            printTransactions("Исходные транзакции: ", currentTransaction);
            int[] reverseTransactions = reverseTransactions(currentTransaction);
            printTransactions(" В обратном порядке: ", reverseTransactions);
            System.out.println();
        }
    }

    private static void printTransactions(String text, int[] transactions) {
        System.out.print(text + "[");

        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i]);
            if (i < transactions.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] reverseTransactions(int[] transactions) {
        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int reversedTransaction : transactions) {
            reversedTransactions[--length] = reversedTransaction;
        }
        return reversedTransactions;
    }
}




