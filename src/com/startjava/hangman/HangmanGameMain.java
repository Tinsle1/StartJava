package com.startjava.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String answer;

        do {
            game.start();

            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = console.next();
            } while (!answer.equalsIgnoreCase("no") &&
                    !answer.equalsIgnoreCase("yes"));
        } while (!answer.equalsIgnoreCase("no"));
    }
}