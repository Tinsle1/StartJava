package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String ANSI_RED = "\u001B[31m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
    public static final String ANSI_GREEN = "\u001B[32m";
    @SuppressWarnings("checkstyle:AvoidEscapedUnicodeCharacters")
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

        for (int i = 0; i < spins.length * 3; i++) { // 12 = 3 "оборота" по 4 символа
            char c = spins[i % spins.length];
            System.out.print("\rCracking password: " + c);
            Thread.sleep(100);
        }

        System.out.print("\r   \r");
    }

    private static boolean isWeakPassword(char[] password) {
        if (isEmpty(password)) return true;
        if (isInBlacklist(password)) return true;
        if (isNotLongEnough(password)) return true;
        if (!hasDigit(password)) return true;
        if (!hasLetter(password)) return true;
        if (!hasSpecChar(password)) return true;
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

    private static boolean hasDigit(char[] password) {
        for (char symbol : password) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        System.out.println("Пароль не содержит ни одной цифры");
        return false;
    }

    private static boolean hasLetter(char[] password) {
        for (char symbol : password) {
            if (Character.isLetter(symbol)) {
                return true;
            }
        }
        System.out.println("Пароль не содержит ни одной буквы");
        return false;
    }

    private static boolean hasSpecChar(char[] password) {
        for (char symbol : password) {
            if (!Character.isLetterOrDigit(symbol)) {
                return true;
            }
        }
        System.out.println("Пароль не содержит ни одного спец. символа");
        return false;
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
