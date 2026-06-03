package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private static final int MAX_ATTEMPTS_AMOUNT = 10;
    private final int[] playerNumbers = new int[MAX_ATTEMPTS_AMOUNT ];

    private int currentTry;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя игрока не должно быть пустым.\n" +
                            "Введите корректное имя:\r"
            );
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNumber(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException(
                    "Число должно входить в отрезок [1, 100].\n" +
                            "Попробуйте еще раз:"
            );
        }

        playerNumbers[currentTry++] = number;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(playerNumbers, currentTry);
    }
}