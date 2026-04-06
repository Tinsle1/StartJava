package com.startjava.hangman;

import java.util.Arrays;
import java.util.Random;

public class HangmanGame {
    private final String[] guessedWords = {
            "картошка",
            "борщ",
            "небо",
            "кальмар",
            "грач"
    };

    String[] hangman = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    String[][] hangmanSteps = {
            {
                    "_______",
                    "|     |",
                    "|",
                    "|",
                    "|",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|",
                    "|",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|     |",
                    "|",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|    /|",
                    "|",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|    /|\\",
                    "|",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|    /|\\",
                    "|    /",
                    "|"
            },
            {
                    "_______",
                    "|     |",
                    "|     @",
                    "|    /|\\",
                    "|    / \\",
                    "| GAME OVER!"
            }
    };

    private String guessedWord;
    private char[] mask;
    private int mistake = 0;

    public void startGame() {
        chooseRandomWord();
        mask = turnWordToMask(guessedWord);
        System.out.println("Угадайте слово: " + new String(mask));
    }

    private void chooseRandomWord() {
        Random random = new Random();
        guessedWord = guessedWords[random.nextInt(0, guessedWords.length)];
    }

    private char[] turnWordToMask(String word) {
        return "*".repeat(word.length()).toCharArray();
    }

    public boolean hasLetter(char letter) {
        boolean hasLetter = false;

        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == Character.toLowerCase(letter)) {
                mask[i] = Character.toUpperCase(letter);
                hasLetter = true;
            }
        }
        return hasLetter;
    }

    public void validateWord(char letter) {
        boolean hasLetter = hasLetter(letter);

        if (hasLetter) {
            System.out.println("\rСлово: " + new String(mask));
            if (mistake > 0) {
                for (String step : hangmanSteps[mistake - 1]) {
                    System.out.println(step);
                }
                mistake--;
            }
        } else {
            for (String step : hangmanSteps[mistake]) {
                System.out.println(step);
            }
            mistake++;
        }
    }

    public boolean isGameOver() {
        return mistake == hangmanSteps.length;
    }

    public boolean continueGame(String answer) {
        return answer.equalsIgnoreCase("yes");
    }

    public boolean isCorrectAnswer(String answer) {
        return (answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("no"));
    }
}