package com.startjava.lesson_4.array;

public class Transactions {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        int[] transactions2 = null;
        int[] transactions3 = {5};
        int[] transactions4 = {6, 8, 9, 1};
        int[] transactions5 = {13, 8, 5, 3, 2, 1, 1};
        int[][] transactions = {transactions1, transactions2, transactions3,
                transactions4, transactions5};

        for (int i = 0; i < transactions.length; i++) {
            int[] currentTransaction = transactions[i];
            checkTransactions(currentTransaction);
        }
    }

    public static void checkTransactions(int[] transactionsLog) {
        if (transactionsLog == null) {
            System.out.println("Ошибка в данных\n");
            return;
        }

        int length = transactionsLog.length;
        if (length == 0) {
            System.out.println("Данных о транзакциях нет\n");
            return;
        }

        System.out.print("Исходные транзакции: ");
        for (int i = 0; i < length; i++) {
            System.out.print(transactionsLog[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
            System.out.println();

        System.out.print(" В обратном порядке: ");
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(transactionsLog[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }
}

