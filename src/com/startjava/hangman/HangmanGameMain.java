package com.startjava.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String answer = "yes";

        do {
            if (answer.equalsIgnoreCase("yes")) {
                HangmanGame game = new HangmanGame();
                game.start();
            }
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = console.next().toLowerCase();
        } while (!answer.equalsIgnoreCase("no"));
    }
}