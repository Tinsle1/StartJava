package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String ANSI_RED = "\u001B[31m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String ANSI_RESET = "\u001B[0m";

    private static final String[] GUESSED_WORDS = {
            "картошка",
            "борщ",
            "небо",
            "кальмар",
            "грач"
    };

    private final String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
            };

    private final StringBuilder wrongLetters = new StringBuilder();
    private final Scanner console = new Scanner(System.in);

    private String guessedWord;
    private char[] mask;
    private int mistake;
    private char letter;

    public void start() {
        resetGameStatus();
        chooseRandomWord();
        mask = turnWordToMask(guessedWord);
        System.out.println("Угадайте слово: " + new String(mask));

        while (!isGuessed()) {
            inputLetter();
            validateWord(letter);
        }
        System.out.println("Игра окончена!");
        System.out.printf("Загаданное слово: %s%n", guessedWord);
    }

    private void resetGameStatus() {
        mistake = 0;
        wrongLetters.setLength(0);
    }

    private void chooseRandomWord() {
        Random random = new Random();
        guessedWord = GUESSED_WORDS[random.nextInt(GUESSED_WORDS.length)];
    }

    private char[] turnWordToMask(String word) {
        return "*".repeat(word.length()).toCharArray();
    }

    private boolean isGuessed() {
        if (mistake == gallows.length) {
            System.out.println("\nВы проиграли!");
            return true;
        }

        if (new String(mask).toLowerCase().equals(guessedWord)) {
            System.out.println("\nВы выиграли!");
            return true;
        }

        return false;
    }

    private void validateWord(char letter) {
        boolean hasLetter = hasLetter(letter);

        if (hasLetter) {
            if (mistake > 0) {
                mistake--;
            }
        } else {
            addWrongLetters(letter);
            mistake++;
        }

        printHangman();
        printGameStatus();
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

    private void inputLetter() {
        do {
            System.out.print("Введите букву: ");
            letter = Character.toUpperCase(console.next().charAt(0));
        } while (!isCyrillic(letter) || isRepeated(letter));
    }

    private boolean isCyrillic(char letter) {
        boolean isCyrillic = Character.UnicodeBlock.of(letter) ==
                Character.UnicodeBlock.CYRILLIC;
        if (!isCyrillic) {
            System.out.println("!Вводите только буквы кириллицы");
        }
        return isCyrillic;
    }

    private boolean isRepeated(char letter) {
        boolean isRepeatedLetter = wrongLetters.toString().contains(letter + "") ||
                new String(mask).contains(letter + "");
        if (isRepeatedLetter) {
            System.out.println("!Вы уже вводили эту букву");
        }
        return isRepeatedLetter;
    }

    private void printHangman() {
        if (mistake > 0) {
            for (int i = 0; i < mistake; i++) {
                System.out.println(ANSI_RED + gallows[i] + ANSI_RESET);
            }
        } else {
            System.out.print("");
        }
    }

    private void addWrongLetters(char letter) {
        if (!wrongLetters.toString().contains(letter + "")) {
            letter = Character.toUpperCase(letter);
            wrongLetters.append(letter).append(" ");
        }
    }

    private void printGameStatus() {
        System.out.println("\rСлово: " + new String(mask));

        System.out.printf("Осталось попыток: %d%n", gallows.length - mistake);

        if (!(wrongLetters.toString()).isEmpty()) {
            System.out.printf("Все ошибочные буквы: %s%n%n", ANSI_RED + wrongLetters + ANSI_RESET);
        }
    }
}