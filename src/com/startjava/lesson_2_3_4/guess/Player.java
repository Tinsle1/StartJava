package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_RESET = "[0m";

    private final String name;
    private final int[] playerNumbers = new int[10];

    private int currentTry;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ANSI_RED + "Имя игрока не должно быть пустым.\n" +
                            "Введите корректное имя:\r" + ANSI_RESET
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
                    ANSI_RED + "Число должно входить в отрезок [1, 100].\n" +
                            "Попробуйте еще раз:" + ANSI_RESET
            );
        }

        for (int playerNumber : playerNumbers) {
            if (number == playerNumber) {
                throw new IllegalArgumentException(
                        ANSI_RED + "Вы уже вводили это число.\n" +
                                "Попробуйте еще раз:" + ANSI_RESET
                );
            }
        }

        playerNumbers[currentTry++] = number;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(playerNumbers, currentTry);
    }
}