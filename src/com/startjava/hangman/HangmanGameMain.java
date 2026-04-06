package com.startjava.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String answer;
        do {
            game.startGame();

            while (!game.isGameOver()) {
                System.out.print("Введите букву: ");
                game.validateWord(console.next().charAt(0));
            }

            System.out.print("Хотите продожить игру? [yes/no]: ");
            answer = console.next();
        } while (game.continueGame(answer));
        System.out.println("Игра окончена!");
    }
}
