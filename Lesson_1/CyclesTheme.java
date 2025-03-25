public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ПОДСЧЕТ СУММЫ ЧЕТНЫХ И НЕЧЕТНЫХ ЧИСЕЛ");
        int lineSegmentStart = -10;
        int lineSegmentEnd = 21;
        int counter = lineSegmentStart;
        int evenSum = 0;
        int oddSum = 0;

        do {
            if (counter % 2 == 0) {
                evenSum += counter;
            } else {
                oddSum += counter;
            }
            counter++;
        } while (counter <= lineSegmentEnd);

        System.out.println("В отрезке " + "[" + lineSegmentStart + "," + lineSegmentEnd + "]" +
                " сумма четных чисел = " + evenSum + ", а нечетных = " + oddSum);

        System.out.println("\n2. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
        int someNumA = 10;
        int someNumB = 5;
        int someNumC = -1;
        int maxNum = someNumA;
        int middleNum = someNumB;
        int minNum = someNumC;

        if (someNumB > someNumA && someNumB > someNumC) {
            maxNum = someNumB;
            if (someNumA > someNumC) {
                middleNum = someNumA;
            } else {
                middleNum = someNumC;
                minNum = someNumA;
            }
        } else if (someNumC > someNumA && someNumC > someNumB) {
            maxNum = someNumC;
            if (someNumA > someNumB) {
                middleNum = someNumA;
                minNum = someNumB;
            } else {
                minNum = someNumA;
            }
        } else if (someNumA > someNumB && someNumA > someNumC && someNumC > someNumB) {
            middleNum = someNumC;
            minNum = someNumB;
        }
        
        for (int i = --maxNum; i > minNum; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. ВЫВОД РЕВЕРСИВНОГО ЧИСЛА И СУММЫ ЕГО ЦИФР");
        int originalNum = 1234;
        int digitsSum = 0;
        System.out.print("Исходное число " + originalNum + " в обратном порядке = ");

        while (originalNum % 10 != 0) {
            int lastDigit = originalNum % 10;
            originalNum /= 10;
            digitsSum += lastDigit;
            System.out.print(lastDigit);
        }
        System.out.println();
        System.out.println("Сумма цифр выведенного выше числа = " + digitsSum);

        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int numberCount = 0;

        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%5d", i);
            numberCount++;

            if (numberCount % 5 == 0) {
                System.out.println();
            }
        }

        int zeroCount = 5 - (numberCount % 5);
        if (zeroCount < 5) {
            for (int i = 0; i < zeroCount; i++) {
                System.out.printf("%5d", 0);
            }
        }

        System.out.println("\n\n5. ПРОВЕРКА КОЛИЧЕСТВА ДВОЕК ЧИСЛА НА ЧЕТНОСТЬ/НЕЧЕТНОСТЬ");
        originalNum = 3242592;
        int currNum = originalNum;
        int twoCount = 0;

        while (currNum % 10 != 0) {
            if (currNum % 10 - 2 == 0) {
                int lastDigit = currNum % 10; 
                twoCount++;
            }
            currNum /= 10;
        }

        if (twoCount > 0) {
            if (twoCount % 2 == 0) {
                System.out.println("В " + originalNum + " четное " +
                        "(" + twoCount + ")" + " количество двоек");
            } else {
                System.out.println("В " + originalNum + " нечетное " +
                        "(" + twoCount + ")" + " количество двоек");
            }
        } else {
            System.out.println("В " + originalNum + " нет двоек");
        }

        System.out.println("\n6. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        char asterisk = '*';

        System.out.println("6.1 Прямоугольник");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(asterisk);
            }
            System.out.println();
        }

        System.out.println("\n6.2 Прямоугольный треугольник");
        char hash = '#';
        int triangleHeight = 5;
        while (triangleHeight > 0) {
            int triangleWidth = 0;
            while (triangleWidth < triangleHeight) {
                System.out.print(hash);
                triangleWidth++;
            }
            triangleHeight--;
            System.out.println();
        }

        System.out.println("6.3 Равнобедренный треугольник");
        // над этой еще туплю

        System.out.println("\n7. ВЫВОД ASCII-СИМВОЛОВ\n");

        System.out.printf("%-10s%-12s%s", "DECIMAL", "CHARACTER", "DESCRIPTION" + "\n");
        char asciiChar;

        for (int i = 0; i < 255; i++) {
            asciiChar = (char) i;
            if (Character.isDigit(asciiChar) == true) {
                break;
            } else if (i > 33 && i % 2 != 0 && Character.isLetterOrDigit(asciiChar) == false) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        System.out.printf("%4d", (int) asciiChar);
                    } else if (j == 1) {
                        System.out.printf("%11c", asciiChar);
                    } else {
                        int spaceCount = 12;
                        for (int k = 0; k < 12; k++) {
                            System.out.print(" ");
                        }
                        System.out.print(Character.getName(asciiChar));
                    }
                }
                System.out.println();
            }
        }

        for (int i = 0; i < 255; i++) {
            asciiChar = (char) i;
            if (i % 2 == 0 && asciiChar >= 'a' && asciiChar <= 'z') {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        System.out.printf("%4d", (int) asciiChar);
                    } else if (j == 1) {
                        System.out.printf("%11c", asciiChar);
                    } else {
                        for (int z = 0; z < 12; z++) {
                            System.out.print(" ");
                        }
                        System.out.print(Character.getName(asciiChar));
                    }
                }
                System.out.println();
            }
        }
            
        System.out.println("\n8. ПРОВЕРКА, ЯВЛЯЕТСЯ ЛИ ЧИСЛО ПАЛИНДРОМОМ");
        originalNum = 1234321;
        currNum = originalNum;
        int reversed = 0;

        while (currNum > 0) {
            reversed = reversed * 10 + currNum % 10;
            currNum /= 10;
        }

        if (originalNum == reversed) {
            System.out.println("Число " + originalNum + " - палиндром");
        } else {
            System.out.println("Число " + originalNum + " - не палиндром");
        }
        
        System.out.println("\n9. ПРОВЕРКА, ЯВЛЯЕТСЯ ЛИ ЧИСЛО СЧАСТЛИВЫМ");
        originalNum = 123321;
        currNum = originalNum;
        int firstHalfNum = 0;
        int firstHalfSum = 0;
        int secondHalfNum = 0;
        int secondHalfSum = 0;

        for (int i = 0; i < 2; i++) {
            int sum = 0;
            int num = 0;

            for (int j = 0; j < 3; j++) {
                reversed = currNum % 10;
                currNum /= 10;
                sum += reversed;
                num = num * 10 + reversed;
            }

            if (i == 1) {
                firstHalfNum = num;
                firstHalfSum = sum;
            } else {
                secondHalfNum = num;
                secondHalfSum = sum;
            }
        }
        System.out.print("Число " + originalNum);

        if (firstHalfSum == secondHalfSum) {
            System.out.println(" счастливое");
        } else {
            System.out.println(" не счастливое");
        }
        System.out.println("Сумма цифр " + secondHalfNum + " = " + secondHalfSum + "\n" +
                "Сумма цифр " + firstHalfNum + " = " + firstHalfSum);

        System.out.println("\n10. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ ПИФАГОРА \n");
        int digitTwo = 2;
        int digitNine = 9;

        for (int i = digitTwo - 1; i <= digitNine; i++) {
            if (i == 1) {
                System.out.printf("%3c", '|');
            } else {
                System.out.printf("%3d", i);
            }
        }
        System.out.println();

        for (int i = digitTwo - 1; i <= digitNine; i++) {
            if (i == 1) {
                System.out.print("--+");
            } else {
                System.out.print("---");
            }
        }

        System.out.println();

        for (int i = digitTwo; i <= digitNine; i++) {
            for (int j = digitTwo - 1; j <= digitNine; j++) {
                if (j == 1) {
                    System.out.print(i * j + " |");
                } else {
                    System.out.printf("%3d", i * j);
                }
            }
            System.out.println();
        }
    }
}