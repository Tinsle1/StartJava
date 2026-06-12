package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner console = new Scanner(System.in);
        String playerAnswer = "yes";

        do {
            if (playerAnswer.equals("yes")) {
                printGameInfo();
                Player player1 = createPlayer(console, "первого");
                Player player2 = createPlayer(console, "второго");
                Player player3 = createPlayer(console, "третьего");
                GuessNumber game = new GuessNumber(player1, player2, player3);
                game.play();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = console.nextLine().toLowerCase();
        } while (!playerAnswer.equals("no"));

        System.out.println("Игра завершена!");
    }

    public static void printGameInfo() {
        System.out.printf("\nКомпьютер загадал число от %d до %d. Попробуйте угадать!\n",
                Player.MIN_GUESSED_NUMBER, Player.MAX_GUESSED_NUMBER);
    }

    private static Player createPlayer(Scanner console, String playerNumber) {
        System.out.print("Имя " + playerNumber + " игрока: ");
        while (true) {
            try {
                return new Player(console.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(AnsiColor.RED + e.getMessage() + AnsiColor.RESET);
            }
        }
    }
}

