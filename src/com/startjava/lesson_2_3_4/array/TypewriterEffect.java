package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String[] quotes = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                null,
                ""
        };

        for (String quote : quotes) {
            if (quote == null || quote.isEmpty()) {
                System.out.println("Нет данных для обработки");
                continue;
            }
            String[] words = splitWords(quote);
            String[] minAndMaxWord = findMinAndMaxWord(words);
            String upperCasedQuote = toUpperCase(quote, minAndMaxWord);
            printTypewriterEffect(upperCasedQuote);
        }
    }

    private static String[] splitWords(String text) {
        return text.split("[^a-zA-Zа-яА-Я]+");
    }

    private static String[] findMinAndMaxWord(String[] words) {
        String maxWord = words[0];
        String minWord = words[0];

        for (String word : words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
            if (word.length() < minWord.length()) {
                minWord = word;
            }
        }
        return new String[]{minWord, maxWord};
    }

    private static String toUpperCase(String quote, String[] minAndMaxWord) {
        StringBuilder quoteToUpperCase = new StringBuilder(quote);
        int minWordIndex = quote.indexOf(minAndMaxWord[0]);
        int maxWordIndex = quote.indexOf(minAndMaxWord[1]);
        if (minWordIndex > maxWordIndex) {
            int temp = minWordIndex;
            minWordIndex = maxWordIndex;
            maxWordIndex = temp;
        }

        quoteToUpperCase.replace(minWordIndex, maxWordIndex + minAndMaxWord[1].length(),
                quote.substring(minWordIndex, maxWordIndex + minAndMaxWord[1].length()).toUpperCase());
        quote = quoteToUpperCase.toString();
        return quote;
    }

    private static void printTypewriterEffect(String quote) throws InterruptedException {
        for (int i = 0; i < quote.length(); i++) {
            System.out.print(quote.charAt(i));
            Thread.sleep(100);
        }
        System.out.println();
    }
}
