package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int secretNumber;
    private Scanner console = new Scanner(System.in);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        secretNumber = new Random().nextInt(101); 
        System.out.println("Компьютер загадал число от 0 до 100. Попробуйте угадать!");

        boolean isGameOn = false;

        while (!isGameOn) {
            System.out.print("Ход " + player1.getName() + ": ");
            int player1Number = console.nextInt();
            isGameOn = isGuessed(player1Number, player1);
            if (isGameOn) break;

            System.out.print("Ход " + player2.getName() + ": ");
            int player2Number = console.nextInt();
            isGameOn = isGuessed(player2Number, player2);
        }
    }

    private boolean isGuessed(int playerNumber, Player currentPlayer) {
        if (secretNumber == playerNumber) {
            System.out.println(playerNumber + " = " + secretNumber);
            System.out.println("Победил " + currentPlayer.getName() + "!");
            return true;  
        }
        if (secretNumber < playerNumber) {
            System.out.println(playerNumber + " больше того, что загадал компьютер");
        } else {
            System.out.println(playerNumber + " меньше того, что загадал компьютер");
        }

        return false; 
    }
}