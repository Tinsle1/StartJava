package com.startjava.lesson_1.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Имя первого игрока: ");
        Player player1 = new Player(console.nextLine());
        System.out.print("Имя второго игрока: ");
        Player player2 = new Player(console.nextLine());

        GuessNumber game = new GuessNumber(player1, player2);

        String playerAnswer;
        do {
            game.play();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                playerAnswer = console.next();
            } while (!playerAnswer.equals("yes") && !playerAnswer.equals("no"));
        } while (playerAnswer.equals("yes"));

        System.out.println("Игра завершена!");
    }
} 

