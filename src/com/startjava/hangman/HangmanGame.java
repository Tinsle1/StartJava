package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String ANSI_RED = "[31m";
    private static final String ANSI_RESET = "[0m";

    private static final String[] GUESSED_WORDS = {
            "картошка",
            "борщ",
            "небо",
            "кальмар",
            "грач",
            "булочка"
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
    private final StringBuilder mask;

    private int attempts;

    public HangmanGame() {
        Random random = new Random();
        guessedWord = GUESSED_WORDS[random.nextInt(GUESSED_WORDS.length)].toUpperCase();
        mask = new StringBuilder("*".repeat(guessedWord.length()));
    }

    public void start() {
        System.out.println("Угадайте слово: " + mask.toString());

        do {
            inputLetter();
        } while (!isGuessed());

        System.out.println("Игра окончена!");
        System.out.printf("Загаданное слово: %s%n", guessedWord);
    }

    private void inputLetter() {
        char letter;
        do {
            System.out.print("Введите букву: ");
            letter = Character.toUpperCase(console.next().charAt(0));
        } while (!isCyrillic(letter) || isRepeated(letter));
        validateWord(letter);
    }

    private boolean isCyrillic(char letter) {
        if (!String.valueOf(letter).matches("[А-Я]")) {
            System.out.println("!Вводите только буквы кириллицы");
            return false;
        }
        return true;
    }

    private boolean isRepeated(char letter) {
        if (wrongLetters.indexOf(String.valueOf(letter)) > -1 || mask.toString().indexOf(letter) > -1) {
            System.out.println("!Вы уже вводили эту букву");
            return true;
        }
        return false;
    }

    private void validateWord(char letter) {
        boolean hasLetter = hasLetter(letter);

        if (hasLetter) {
            if (attempts > 0) {
                attempts--;
            }
        } else {
            addWrongLetters(letter);
            attempts++;
        }

        printGallows();
        printGameStatus();
    }

    private boolean hasLetter(char letter) {
        boolean hasLetter = false;

        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == letter) {
                mask.setCharAt(i, letter);
                hasLetter = true;
            }
        }
        return hasLetter;
    }

    private boolean isGuessed() {
        if (attempts == GALLOWS.length) {
            System.out.println("\nВы проиграли!");
            return true;
        }

        if (mask.toString().equals(guessedWord)) {
            System.out.println("\nВы выиграли!");
            return true;
        }

        return false;
    }

    private void addWrongLetters(char letter) {
        if (!wrongLetters.toString().contains(letter + "")) {
            wrongLetters.append(letter).append(" ");
        }
    }

    private void printGallows() {
        for (int i = 0; i < attempts; i++) {
            System.out.println(ANSI_RED + GALLOWS[i] + ANSI_RESET);
        }
    }

    private void printGameStatus() {
        System.out.println("\rСлово: " + mask.toString());

        System.out.printf("Осталось попыток: %d%n", GALLOWS.length - attempts);

        if (!(wrongLetters.toString()).isEmpty()) {
            System.out.printf("Ошибки: %s%n%n", ANSI_RED + wrongLetters + ANSI_RESET);
        }
    }
}