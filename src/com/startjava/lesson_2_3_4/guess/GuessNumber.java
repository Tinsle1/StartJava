package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS_AMOUNT = 10;

    private static final Random RANDOM = new Random();
    private static final int ROUNDS = 3;

    private final Scanner console = new Scanner(System.in);
    private final Player[] players;

    private int secretNumber;
    private int currentRoundAttempt;

    public GuessNumber(Player player1, Player player2, Player player3) {
        players = new Player[] {
                player1,
                player2,
                player3
        };
    }

    public void play() throws InterruptedException {
        castLots();
        System.out.printf("\nИгра началась! У каждого игрока по %d попыток\n", MAX_ATTEMPTS_AMOUNT);

        for (int i = 1; i <= ROUNDS; i++) {
            announceRound(i);
            startRound();
            int outOfAttemptPlayersAmount = 0;

            boolean isRoundOn = false;

            while (!isRoundOn) {
                System.out.println("Попытка " + currentRoundAttempt);

                for (Player player : players) {
                    System.out.print("Число вводит " + player.getName() + ": ");
                    int playerNumber = inputNumber(player);

                    isRoundOn = isGuessed(playerNumber, player);
                    if (isRoundOn) {
                        player.addScore(1);
                        break;
                    }
                    if (isNoAttemptsLeft()) {
                        player.addScore(0);
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
                currentRoundAttempt++;
            }
            printRoundScores(i);
            printPlayersNumbers();
        }
        printGameWinner();
    }

    private void castLots() throws InterruptedException {
        System.out.println("\nБросаем жребий, чтобы определить порядок угадывания:");

        for (int i = players.length - 1; i >= 0; i--) {
            showSpinner();

            int j = RANDOM.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;

            System.out.printf("Игрок %s ходит под номером %d%n", players[i].getName(), i + 1);
        }
    }

    private static void showSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};

        for (int i = 0; i < spins.length * 3; i++) {
            char c = spins[i % spins.length];
            System.out.print("\r " + c);
            Thread.sleep(100);
        }

        System.out.print("\r   \r");
    }

    private void announceRound(int round) {
        System.out.printf("""
                --------
                РАУНД %d
                --------
                %n""", round);
    }

    private void startRound() {
        secretNumber = RANDOM.nextInt(1, Player.MAX_GUESSED_NUMBER + 1);
        currentRoundAttempt = 1;
        clearNumbers();
    }

    public void clearNumbers() {
        for (Player player : players) {
            player.clearNumbers();
        }
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
            } catch (InputMismatchException e) {
                System.out.println(AnsiColor.RED + "Введите число" + AnsiColor.RESET);
                console.nextLine();
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
                AnsiColor.RESET, currentPlayer.getName(), secretNumber, currentRoundAttempt);
    }

    public void printHint(int playerNumber) {
        String hint = secretNumber > playerNumber ? "больше" : "меньше";
        System.out.printf(AnsiColor.YELLOW + "Загаданное число %s %d%n" +
                AnsiColor.RESET, hint, playerNumber);
    }

    private boolean isNoAttemptsLeft() {
        return currentRoundAttempt == MAX_ATTEMPTS_AMOUNT;
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
        System.out.println();
    }

    public void printRoundScores(int round) {
        System.out.printf("Счет после раунда %d:\n", round);

        for (Player player : players) {
            System.out.printf("Игрок %s: %d очков\n", player.getName(), player.getScores());
        }
        System.out.println();
    }

    private void printGameWinner() {
        int maxScore = 0;

        for (Player player : players) {
            if (player.getScores() > maxScore) {
                maxScore = player.getScores();
            }
        }

        int winnersCount = 0;

        for (Player player : players) {
            if (player.getScores() == maxScore) {
                winnersCount++;
            }
        }

        if (winnersCount == 1) {
            for (Player player : players) {
                if (player.getScores() == maxScore) {
                    System.out.printf(
                            AnsiColor.GREEN +
                                    "Победитель игры: %s (%d очков)%n" +
                                    AnsiColor.RESET,
                            player.getName(),
                            maxScore
                    );
                    return;
                }
            }
        }

        System.out.print(AnsiColor.YELLOW + "Ничья между игроками: ");

        for (Player player : players) {
            if (player.getScores() == maxScore) {
                System.out.print(player.getName() + " ");
            }
        }

        System.out.printf("(%d очков)%n" + AnsiColor.RESET, maxScore);
    }
}
