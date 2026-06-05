package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS_AMOUNT = 10;

    private final Scanner console = new Scanner(System.in);
    private final Player[] players;
    private final int secretNumber;

    private int currentAttempt;

    public GuessNumber(Player player1, Player player2) {
        players = new Player[] {
                player1,
                player2
        };

        secretNumber = new Random().nextInt(Player.MAX_GUESSED_NUMBER + 1);
    }

    public void play() {
        System.out.printf("\nИгра началась! У каждого игрока по %d попыток", MAX_ATTEMPTS_AMOUNT);

        currentAttempt = 1;
        int outOfAttemptPlayersAmount = 0;

        boolean isGameOn = false;

        while (!isGameOn) {
            System.out.println("\nПопытка " + currentAttempt);

            for (Player player : players) {
                System.out.print("Число вводит " + player.getName() + ": ");
                int playerNumber = inputNumber(player);

                isGameOn = isGuessed(playerNumber, player);
                if (isGameOn) break;

                if (isNoAttemptsLeft()) {
                    System.out.printf(AnsiColor.RED + "У %s закончились попытки!%n%n" +
                            AnsiColor.RESET, player.getName());
                    outOfAttemptPlayersAmount++;
                }
            }
            if (isLost(outOfAttemptPlayersAmount)) {
                System.out.printf(AnsiColor.RED +
                        "Ни один из игроков не угадал число %d%n%n" + AnsiColor.RESET, secretNumber);
                break;
            }
            currentAttempt++;
        }
        printPlayersNumbers();
    }

    private int inputNumber(Player player) {
        while (true) {
            try {
                int playerNumber = console.nextInt();

                for (int number : player.getNumbers()) {
                    if (number == playerNumber) {
                        throw new IllegalArgumentException(
                                AnsiColor.YELLOW + "Вы уже вводили это число.\n" +
                                        "Попробуйте еще раз:" + AnsiColor.RESET);
                    }
                }

                player.addNumber(playerNumber);
                return playerNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(AnsiColor.RED + e.getMessage() + AnsiColor.RESET);
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
        System.out.printf(AnsiColor.GREEN + "%s угадал число %d с %d-й попытки%n%n" +
                AnsiColor.RESET, currentPlayer.getName(), secretNumber, currentAttempt);
    }

    public void printHint(int playerNumber) {
        String hint = secretNumber > playerNumber ? "больше" : "меньше";
        System.out.printf(AnsiColor.YELLOW + "Загаданное число %s %d%n" +
                AnsiColor.RESET, hint, playerNumber);
    }

    private boolean isNoAttemptsLeft() {
        return currentAttempt == MAX_ATTEMPTS_AMOUNT;
    }

    private boolean isLost(int outOfAttemptPlayersAmount) {
        return outOfAttemptPlayersAmount == players.length;
    }

    public void printPlayersNumbers() {
        for (Player player : players) {
            String playerAttempts = Arrays.toString(player.getNumbers())
                        .replace("[", "")
                        .replace("]", "");

            System.out.printf("Все попытки игрока %s: %s%n", player.getName(), playerAttempts);
        }
    }
}
