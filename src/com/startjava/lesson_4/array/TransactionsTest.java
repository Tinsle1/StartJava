package com.startjava.lesson_4.array;

public class TransactionsTest {
    public static void main(String[] args) {
        TransactionsLog transactionsLog = new TransactionsLog();
        for (int i = 0; i < transactionsLog.transactions.length; i++) {
            int[] currentTransaction = transactionsLog.transactions[i];
            TransactionsCheck.checkTransactions(currentTransaction);
        }
    }
}
