package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                HangmanGame game = new HangmanGame();
                game.start();

                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = console.next().toLowerCase();
        } while (!answer.equals("no"));
    }
}