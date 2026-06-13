package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MIN_GUESSED_NUMBER = 1;
    public static final int MAX_GUESSED_NUMBER = 100;

    private final String name;
    private final int[] numbers = new int[GuessNumber.MAX_ATTEMPTS_AMOUNT];

    private int currentTry;
    private int scores = 0;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя игрока не должно быть пустым.\n" +
                    "Введите корректное имя: ");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentTry);
    }

    public void addNumber(int number) {
        if (number < MIN_GUESSED_NUMBER || number > MAX_GUESSED_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(
                            "Число должно входить в отрезок [%d, %d].%nПопробуйте еще раз: ",
                            MIN_GUESSED_NUMBER, MAX_GUESSED_NUMBER));
        }

        numbers[currentTry++] = number;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currentTry, 0);
        currentTry = 0;
    }

    public void addScore() {
        scores++;
    }

    public int getScores() {
        return scores;
    }
}