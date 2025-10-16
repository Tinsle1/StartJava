package com.startjava.lesson_4.array;

public class TransactionsCheck {
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

