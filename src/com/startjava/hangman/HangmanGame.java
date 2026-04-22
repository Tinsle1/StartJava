package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static final String ANSI_RED = "[31m";
    public static final String ANSI_RESET = "[0m";

    private static final String[] GUESSED_WORDS = {
            "картошка",
            "борщ",
            "небо",
            "кальмар",
            "грач"
    };

    private static final String[] GALLOWS = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
            };

    private final StringBuilder wrongLetters = new StringBuilder();
    private final Scanner console = new Scanner(System.in);
    private final String guessedWord;
    private final char[] mask;

    private int mistakes;

    public HangmanGame() {
        Random random = new Random();
        guessedWord = GUESSED_WORDS[random.nextInt(GUESSED_WORDS.length)];
        mask = "*".repeat(guessedWord.length()).toCharArray();
    }

    public void start() {
        System.out.println("Угадайте слово: " + String.valueOf(mask));

        do {
            inputLetter();
        } while (!isGuessed());

        System.out.println("Игра окончена!");
        System.out.printf("Загаданное слово: %s%n", guessedWord);
    }

    private boolean isGuessed() {
        if (mistakes == GALLOWS.length) {
            System.out.println("\nВы проиграли!");
            return true;
        }

        if (String.valueOf(mask).toLowerCase().equals(guessedWord)) {
            System.out.println("\nВы выиграли!");
            return true;
        }

        return false;
    }

    private void inputLetter() {
        char letter;
        do {
            System.out.print("Введите букву: ");
            letter = Character.toUpperCase(console.next().charAt(0));
        } while (!isCyrillic(letter) || isRepeated(letter));
        validateWord(letter);
    }

    private boolean hasLetter(char letter) {
        boolean hasLetter = false;

        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == Character.toLowerCase(letter)) {
                mask[i] = Character.toUpperCase(letter);
                hasLetter = true;
            }
        }
        return hasLetter;
    }

    private void validateWord(char letter) {
        boolean hasLetter = hasLetter(letter);

        if (hasLetter) {
            if (mistakes > 0) {
                mistakes--;
            }
        } else {
            addWrongLetters(letter);
            mistakes++;
        }

        printGallows();
        printGameStatus();
    }

    private boolean isCyrillic(char letter) {
        if (!String.valueOf(letter).matches("[А-Я]")) {
            System.out.println("!Вводите только буквы кириллицы");
            return false;
        }
        return true;
    }

    private boolean isRepeated(char letter) {
        if (wrongLetters.indexOf(String.valueOf(letter)) > -1 || String.valueOf(mask).indexOf(letter) > -1) {
            System.out.println("!Вы уже вводили эту букву");
            return true;
        }
        return false;
    }

    private void printGallows() {
        for (int i = 0; i < mistakes; i++) {
            System.out.println(ANSI_RED + GALLOWS[i] + ANSI_RESET);
        }
    }

    private void addWrongLetters(char letter) {
        if (!wrongLetters.toString().contains(letter + "")) {
            letter = Character.toUpperCase(letter);
            wrongLetters.append(letter).append(" ");
        }
    }

    private void printGameStatus() {
        System.out.println("\rСлово: " + String.valueOf(mask));

        System.out.printf("Осталось попыток: %d%n", GALLOWS.length - mistakes);

        if (!(wrongLetters.toString()).isEmpty()) {
            System.out.printf("Все ошибочные буквы: %s%n%n", ANSI_RED + wrongLetters + ANSI_RESET);
        }
    }
}