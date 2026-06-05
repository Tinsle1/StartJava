package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MIN_GUESSED_NUMBER = 1;
    public static final int MAX_GUESSED_NUMBER = 100;

    private final String name;
    private final int[] playerNumbers = new int[GuessNumber.MAX_ATTEMPTS_AMOUNT ];

    private int currentTry;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя игрока не должно быть пустым.\n" +
                            "Введите корректное имя:\r");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(playerNumbers, currentTry);
    }

    public void addNumber(int number) {
        if (number < MIN_GUESSED_NUMBER || number > MAX_GUESSED_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(
                            "Число должно входить в отрезок [%d, %d].\nПопробуйте еще раз:",
                            MIN_GUESSED_NUMBER, MAX_GUESSED_NUMBER
                    ));
        }

        playerNumbers[currentTry++] = number;
    }
}