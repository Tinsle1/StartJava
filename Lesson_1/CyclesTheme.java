public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ПОДСЧЕТ СУММЫ ЧЕТНЫХ И НЕЧЕТНЫХ ЧИСЕЛ");
        int startValue = -10;
        int endValue = 21;
        int count = startValue;
        int evenSum = 0;
        int oddSum = 0;

        do {
            if (count % 2 == 0) {
                evenSum += count;
            } else {
                oddSum += count;
            }
            count++;
        } while (count <= endValue);

        System.out.println("В отрезке " + "[" + startValue + "," + endValue + "]" +
                " сумма четных чисел = " + evenSum + ", а нечетных = " + oddSum);

        System.out.println("\n2. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
        int max = 10;
        int min = 5;
        int inter = -1;

        if (min > inter) {
            min = inter;
        } else if (min > max) {
            max = min;
            min = max;
            if (max > inter) {
                min = inter;
            }
        } else if (inter > max) {
            max = inter;
            min = max;
        }
      
        for (int i = --max; i > -1; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. ВЫВОД РЕВЕРСИВНОГО ЧИСЛА И СУММЫ ЕГО ЦИФР");
        int originalNum = 1234;
        int reverseNum;
        int reverseDigitsSum = 0;
      
        while (originalNum % 10 != 0) {
            reverseNum = originalNum % 10;
            originalNum /= 10;
            reverseDigitsSum += reverseNum;

            System.out.print(reverseNum);
        }
        System.out.println();
        System.out.println(reverseDigitsSum);

        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        // над этой еще туплю

        System.out.println("\n5. ПРОВЕРКА КОЛИЧЕСТВА ДВОЕК ЧИСЛА НА ЧЕТНОСТЬ/НЕЧЕТНОСТЬ");
        int originalNum5 = 3242592;
        int num5Condition = originalNum5;
        int lastDigit;
        int twoCount = 0;

        while (num5Condition % 10 != 0) {
            lastDigit = num5Condition % 10;
            num5Condition /= 10;

            if (lastDigit - 2 == 0) {
                twoCount++;
            }
        }

        if (twoCount > 0) {
            if (twoCount % 2 == 0) {
                System.out.println("В " + originalNum5 + " четное " +
                        "(" + twoCount + ")" + " количество двоек");
            } else {
                System.out.println("В " + originalNum5 + " нечетное " +
                        "(" + twoCount + ")" + " количество двоек");
            }
        } else {
            System.out.println("В " + originalNum5 + " нет двоек");
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
        int originalNum9 = 1234321;
        int num9Copy = originalNum9;
        int reverseNum9 = 0;

        while (num9Copy % 10 != 0) {
            reverseNum9 = reverseNum9 * 10 + num9Copy % 10;
            num9Copy /= 10;
        }

        if (originalNum9 == reverseNum9) {
            System.out.println("Число " + originalNum9 + " - палиндром");
        } else {
            System.out.println("Число " + originalNum9 + " - не палиндром");
        }
        
        System.out.println("\n9. ПРОВЕРКА, ЯВЛЯЕТСЯ ЛИ ЧИСЛО СЧАСТЛИВЫМ");
        int sixDigitsNum = 123321;
        int sixDigitsNumCopy = sixDigitsNum;
        int sixDigitsNumReverse;
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        int digitCount = 0;
        int firstHalfNum = 0;
        int secondHalfNum = 0;
        
        while (sixDigitsNumCopy % 10 != 0) {
            sixDigitsNumReverse = sixDigitsNumCopy % 10;
            sixDigitsNumCopy /= 10;
          
            if (digitCount < 3) {
                secondHalfSum += sixDigitsNumReverse;
                secondHalfNum = secondHalfNum * 10 + sixDigitsNumReverse;
            } else if (digitCount >= 3 || digitCount < 6) {
                firstHalfSum += sixDigitsNumReverse;
                firstHalfNum = firstHalfNum * 10 + sixDigitsNumReverse;
            }
            digitCount++;
        }
        
        if (secondHalfSum == firstHalfSum) {
            System.out.println("Число " + sixDigitsNum + " счастливое" + "\n" +
                    "Сумма цифр " + secondHalfNum + " = " + secondHalfSum + "\n" +
                    "Сумма цифр " + firstHalfNum + " = " + firstHalfSum);
        } else {
            System.out.println("Число " + sixDigitsNum + " не счастливое" + "\n" +
                    "Сумма цифр " + secondHalfNum + " = " + secondHalfSum + "\n" +
                    "Сумма цифр " + firstHalfNum + " = " + firstHalfSum);
        }

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