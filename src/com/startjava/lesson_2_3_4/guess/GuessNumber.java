package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final String ANSI_YELLOW = "[0;33m";
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_GREEN = "[32m";
    private static final String ANSI_RESET = "[0m";

    private static final int MAX_ATTEMPTS_AMOUNT = 10;

    private final Scanner console = new Scanner(System.in);
    private final Player[] players;

    private int secretNumber;
    private int attempt;

    public GuessNumber(Player player1, Player player2) {
        players = new Player[] {
                player1,
                player2
        };
    }

    public void play() {
        secretNumber = new Random().nextInt(101);
        attempt = 1;
        int outOfAttemptPlayersAmount = 0;

        boolean isGameOn = false;

        while (!isGameOn) {
            System.out.println("\nПопытка " + attempt);

            for (Player player : players) {
                System.out.print("Число вводит " + player.getName() + ": ");
                int playerNumber = inputNumber(player);

                isGameOn = isGuessed(playerNumber, player);
                if (isGameOn) break;

                if (attempt == MAX_ATTEMPTS_AMOUNT) {
                    System.out.printf(ANSI_RED + "У %s закончились попытки!%n%n" +
                            ANSI_RESET, player.getName());
                    outOfAttemptPlayersAmount++;
                }
            }
            if (isLost(outOfAttemptPlayersAmount)) {
                System.out.printf(ANSI_RED +
                        "Ни один из игроков не угадал число %d%n%n" +
                        ANSI_RESET, secretNumber);
                break;
            }
            attempt++;
        }
        printPlayersNumbers();
    }

    private int inputNumber(Player player) {
        while (true) {
            try {
                int playerNumber = console.nextInt();
                player.addNumber(playerNumber);
                return playerNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isGuessed(int playerNumber, Player currentPlayer) {
        if (secretNumber == playerNumber) {
            printWinnerInfo(currentPlayer);
            return true;
        }
        printHint(playerNumber);
        return false;
    }

    public void printWinnerInfo(Player currentPlayer) {
        System.out.printf(ANSI_GREEN + "%s угадал число %d с %d-й попытки%n%n" +
                ANSI_RESET, currentPlayer.getName(), secretNumber, attempt);
    }

    public void printHint(int playerNumber) {
        String hint = secretNumber > playerNumber ?
                "больше" : "меньше";
        System.out.printf(ANSI_YELLOW + "Загаданное число %s %d%n" + ANSI_RESET, hint, playerNumber);
    }

    private boolean isLost(int outOfAttemptPlayersAmount) {
        return outOfAttemptPlayersAmount == players.length;
    }

    public void printPlayersNumbers() {
        for (Player player : players) {
            String playerAttempts = Arrays.toString(player.getNumbers())
                            .replace("[", "")
                                    .replace("]", "");

            System.out.printf("Все попытки игрока %s: %s%n", player.getName(),
                    playerAttempts);
        }
    }
}
