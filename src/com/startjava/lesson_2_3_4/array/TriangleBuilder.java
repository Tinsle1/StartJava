package com.startjava.lesson_2_3_4.array;

public class TriangleBuilder {
    public static void main(String[] args) {
        char[][] charBounds = {
                {'0', '9'},
                {'/', '!'},
                {'A', 'J'}
        };

        boolean[] sortTypes = {true, false, false};

        for (int i = 0; i < charBounds.length; i++) {
            char lowerBound = charBounds[i][0];
            char upperBound = charBounds[i][1];

            if (lowerBound > upperBound) {
                System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n",
                        (int) lowerBound,
                        (int) upperBound);
                continue;
            }
            char[] charRange = createCharRange(charBounds[i], sortTypes[i]);
            String triangle = buildTriangle(charRange);
            printTriangle(triangle);
        }
    }

    private static char[] createCharRange(char[] segmentBoundaries, boolean ascending) {
        int length = segmentBoundaries[1] - segmentBoundaries[0] + 1;
        char[] charRange = new char[length];

        for (int i = 0; i < charRange.length; i++) {
            if (ascending) {
                charRange[i] = (char) (segmentBoundaries[0] + i);
            } else {
                charRange[i] = (char) (segmentBoundaries[1] - i);
            }
        }
        return charRange;
    }

    private static String buildTriangle(char[] charRange) {
        StringBuilder triangle = new StringBuilder();

        for (int i = 0; i < charRange.length; i++) {
            triangle
                    .append(" ".repeat(charRange.length - (i + 1)))
                    .append(String.valueOf(charRange[i]).repeat((i * 2) + 1))
                    .append('\n');
        }
        return triangle.toString();
    }

    private static void printTriangle(String string) {
        System.out.println(string);
    }
}