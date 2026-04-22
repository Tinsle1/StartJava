package com.startjava.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;

        do {
            HangmanGame game = new HangmanGame();
            game.start();

            while (true) {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = console.next().toLowerCase();

                if (answer.equals("yes") || answer.equals("no")) {
                    break;
                }

                System.out.println("Введите корректный ответ [yes / no]");
            }
        } while (!answer.equals("no"));
    }
}