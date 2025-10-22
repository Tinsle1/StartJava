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

    public static void checkTransactions(int[] transactions) {
        if (transactions == null) {
            System.out.println("Ошибка в данных\n");
            return;
        }

        if (transactions.length == 0) {
            System.out.println("Данных о транзакциях нет\n");
            return;
        }

        printTransactions("Исходные транзакции:", transactions);
        int[] reverseTransactions = reverseTransactions(transactions);
        printTransactions("В обратном порядке:", reverseTransactions);
        System.out.println();
    }

    public static void printTransactions(String text, int[] transactions) {
        System.out.print(text + "[");

        for (int i = 0; i < transactions.length; i++) {
            System.out.print(transactions[i]);
            if (i < transactions.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] reverseTransactions(int[] transactions) {
        int length = transactions.length;
        int[] reversedTransactions = new int[length];
        int reversedTransactionsIndex = 0;
        for (int i = transactions.length - 1; i >= 0; i--) {
            reversedTransactions[reversedTransactionsIndex] = transactions[i];
            reversedTransactionsIndex++;
        }
        return reversedTransactions;
    }
}