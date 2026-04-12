package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] guessedWords = {
            "картошка",
            "борщ",
            "небо",
            "кальмар",
            "грач"
    };

    private final String[] hangman = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
            };

    private String guessedWord;
    private char[] mask;
    private int mistake = 0;
    private final StringBuilder wrongLetters = new StringBuilder();
    private final Scanner console = new Scanner(System.in);
    private char letter;
    private String answer;
    boolean validAnswer = false;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void start() {
        do {
            chooseRandomWord();
            mask = turnWordToMask(guessedWord);
            System.out.println("Угадайте слово: " + new String(mask));

            while (!isGameOver()) {
                do {
                    askForLetter();
                } while (!isCyrillic(letter) || isRepeatedLetter(letter));
                validateWord(letter);
            }
            System.out.println("Игра окончена!");
            System.out.printf("Загаданное слово: %s%n", guessedWord);

            while (!validAnswer) {
                isAnswer();
            }
        } while (continueGame(answer));
    }

    private void chooseRandomWord() {
        Random random = new Random();
        guessedWord = guessedWords[random.nextInt(0, guessedWords.length)];
    }

    private char[] turnWordToMask(String word) {
        return "*".repeat(word.length()).toCharArray();
    }

    public void askForLetter() {
        System.out.print("Введите букву: ");
        letter = console.next().charAt(0);
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

    public boolean isCyrillic(char letter) {
        boolean isCyrillic = Character.UnicodeBlock.of(letter) ==
                Character.UnicodeBlock.CYRILLIC;
        if (!isCyrillic) {
            System.out.println("!Вводите только буквы кириллицы");
        }
        return isCyrillic;
    }

    public boolean isRepeatedLetter(char letter) {
        letter = Character.toUpperCase(letter);
        boolean isRepeatedLetter = wrongLetters.toString().contains(letter + "") ||
                new String(mask).contains(letter + "");
        if (isRepeatedLetter) {
            System.out.println("!Вы уже вводили эту букву");
        }
        return isRepeatedLetter;
    }

    public void addWrongLetters(char letter) {
        if (!wrongLetters.toString().contains(letter + "")) {
            letter = Character.toUpperCase(letter);
            wrongLetters.append(letter).append(" ");
        }
    }

    public void validateWord(char letter) {
        boolean hasLetter = hasLetter(letter);

        System.out.println("\rСлово: " + new String(mask));
        if (hasLetter) {
            if (mistake > 0) {
                mistake--;
            }
        } else {
            addWrongLetters(letter);
            mistake++;
        }

        printHangman();

        System.out.printf("Осталось попыток: %d%n", hangman.length - mistake);

        if (!(wrongLetters.toString()).isEmpty()) {
            System.out.printf("Все ошибочные буквы: %s%n%n", ANSI_RED + wrongLetters + ANSI_RESET);
        }
    }

    public void printHangman() {
        if (mistake > 0) {
            for (int i = 0; i < mistake; i++) {
                System.out.println(ANSI_RED + hangman[i] + ANSI_RESET);
            }
        } else {
            System.out.print("");
        }
    }

    public boolean isGameOver() {
        boolean isGameOver = false;
        if (mistake == hangman.length) {
            System.out.println("\nВы проиграли!");
            isGameOver = true;
        } else if (new String(mask).toLowerCase().equals(guessedWord)) {
            System.out.println("\nВы выиграли!");
            isGameOver = true;
        }
        return isGameOver;
    }

    public boolean continueGame(String answer) {
        return answer.equalsIgnoreCase("yes");
    }

    public void isAnswer() {
        System.out.print("Хотите продолжить игру? [yes/no]: ");
        answer = console.next();
        validAnswer = answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("no");
    }
}