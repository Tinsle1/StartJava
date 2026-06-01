package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String playerAnswer = "yes";
        Player player1;
        Player player2;

        do {
            if (playerAnswer.equals("yes")) {
                System.out.println("\nКомпьютер загадал число от 0 до 100. " +
                        "Попробуйте угадать!");

                player1 = createPlayer(console, "первого");
                player2 = createPlayer(console, "второго");

                GuessNumber game = new GuessNumber(player1, player2);
                System.out.println("\nИгра началась! У каждого игрока по 10 попыток");
                game.play();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = console.nextLine().toLowerCase();
        } while (!playerAnswer.equals("no"));

        System.out.println("Игра завершена!");
    }

    private static Player createPlayer(Scanner console, String playerNumber) {
        System.out.print("Имя " + playerNumber + " игрока: ");
        while (true) {
            try {
                return new Player(console.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
} 

