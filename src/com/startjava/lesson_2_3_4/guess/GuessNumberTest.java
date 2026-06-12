package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner console = new Scanner(System.in);
        String playerAnswer = "yes";

        do {
            if (playerAnswer.equals("yes")) {
                printGameInfo();
                Player[] players = createPlayer(console);
                GuessNumber game = new GuessNumber(players);
                game.play();
                System.out.print("%nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = console.nextLine().toLowerCase();
        } while (!playerAnswer.equals("no"));

        System.out.println("Игра завершена!");
    }

    public static void printGameInfo() {
        System.out.printf("%nКомпьютер загадал число от %d до %d. Попробуйте угадать!%n",
                Player.MIN_GUESSED_NUMBER, Player.MAX_GUESSED_NUMBER);
    }

    private static Player[] createPlayer(Scanner console) {
        System.out.print("Введите количество игроков: ");
        int playersAmount = console.nextInt();
        console.nextLine();

        Player[] players = new Player[playersAmount];

        for (int i = 1; i <= playersAmount; i++) {
            System.out.printf("Имя %d-го игрока: ", i);
            while (true) {
                try {
                    players[i - 1] = new Player(console.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(AnsiColor.RED + e.getMessage() + AnsiColor.RESET);
                }
            }
        }
        return players;
    }
}

