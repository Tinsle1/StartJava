package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        char[][] passwords = {
                "123456".toCharArray(),
                genPassword(),
                genPassword()
        };

        for (char[] password : passwords) {
            showSpinner();
            boolean isWeak = isWeakPassword(password);
            printPasswordStatus(password, isWeak);
        }
    }

    private static char[] genPassword() {
        Random random = new Random();
        char[] password = new char[random.nextInt(6, 13)];
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 127);
        }
        return password;
    }

    private static void showSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};

        for (int i = 0; i < 12; i++) { // 12 = 3 "оборота" по 4 символа
            char c = spins[i % spins.length];
            System.out.print("\rCracking password: " + c);
            Thread.sleep(100);
        }

        System.out.print("\r   \r");
    }

    public static boolean isWeakPassword(char[] password) {
        if (isEmpty(password)) return true;
        if (isInBlacklist(password)) return true;
        if (isNotLongEnough(password)) return true;
        if (hasDigitsOnly(password)) return true;
        if (hasLettersOnly(password)) return true;
        if (hasSpecCharsOnly(password)) return true;
        if (hasNoSpecChars(password)) return true;
        return hasNoUpperAndLowerCase(password);
    }

    private static boolean isInBlacklist(char[] password) {
        char[][] blacklist = {
                "admin".toCharArray(),
                "qwerty".toCharArray(),
                "123456".toCharArray()
        };

        for (char[] blacklistValue : blacklist) {
            if (Arrays.equals(password, blacklistValue)) {
                System.out.println("Не используйте пароли из списка популярных:" +
                        "\nhttps://nordpass.com/most-common-passwords-list");
                return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println("Пароль не может быть пустым");
            return true;
        }
        return false;
    }

    private static boolean isNotLongEnough(char[] password) {
        if (password.length < 8) {
            System.out.println("Пароль должен быть не менее 8 символов");
            return true;
        }
        return false;
    }

    private static boolean hasDigitsOnly(char[] password) {
        for (char symbol : password) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        System.out.println("Пароль содержит только цифры");
        return true;
    }

    private static boolean hasLettersOnly(char[] password) {
        for (char symbol : password) {
            if (!Character.isLetter(symbol)) {
                return false;
            }
        }
        System.out.println("Пароль содержит только буквы");
        return true;
    }

    private static boolean hasSpecCharsOnly(char[] password) {
        for (char symbol : password) {
            if (Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        System.out.println("Пароль содержит только спец. символы");
        return true;
    }

    private static boolean hasNoSpecChars(char[] password) {
        for (char symbol : password) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        System.out.println("Пароль не содержит спец. символы");
        return true;
    }

    private static boolean hasNoUpperAndLowerCase(char[] password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char symbol : password) {
            if (Character.isLowerCase(symbol)) {
                hasLowerCase = true;
            }

            if (Character.isUpperCase(symbol)) {
                hasUpperCase = true;
            }
        }

        if (!hasUpperCase || !hasLowerCase) {
            System.out.println("Пароль должен содержать и верхний, и нижний регистр");
            return true;
        }
        return false;
    }

    private static void printPasswordStatus(char[] password, boolean isWeak) {
        System.out.printf(
                (isWeak ? ANSI_RED + "✓ Password cracked: %s%n%n"
                        : ANSI_GREEN + "✗ Strong password: %s%n%n") +
                        ANSI_RESET, new String(password));
    }
}
