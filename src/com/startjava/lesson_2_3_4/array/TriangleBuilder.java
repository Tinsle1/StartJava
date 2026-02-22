package com.startjava.lesson_2_3_4.array;

public class TriangleBuilder {
    public static void main(String[] args) {
        char[][] segmentBoundariesSet = {
                {'0', '9'},
                {'/', '!'},
                {'A', 'J'}
        };

        boolean[] sortTypesSet = {true, false, false};

        for (int i = 0; i < segmentBoundariesSet.length; i++) {
            char lowerBound = segmentBoundariesSet[i][0];
            char upperBound = segmentBoundariesSet[i][1];

            if (lowerBound > upperBound) {
                System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n",
                        (int) lowerBound,
                        (int) upperBound);
                continue;
            }
            char[] charSet = makeCharSet(segmentBoundariesSet[i], sortTypesSet[i]);
            System.out.println(buildTriangle(charSet));
        }
    }

    private static char[] makeCharSet(char[] segmentBoundaries, boolean sortType) {
        int length = segmentBoundaries[1] - segmentBoundaries[0] + 1;
        char[] charSet = new char[length];

        for (int i = 0; i < charSet.length; i++) {
            if (sortType) {
                charSet[i] = (char) (segmentBoundaries[0] + i);
            } else {
                charSet[i] = (char) (segmentBoundaries[1] - i);
            }
        }
        return charSet;
    }

    private static String buildTriangle(char[] charSet) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charSet.length; i++) {
            result
                    .append(" ".repeat(charSet.length - (i + 1)))
                    .append(String.valueOf(charSet[i]).repeat((i * 2) + 1))
                    .append('\n');
        }
        return result.toString();
    }
}