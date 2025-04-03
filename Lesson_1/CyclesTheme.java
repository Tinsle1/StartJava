public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ПОДСЧЕТ СУММЫ ЧЕТНЫХ И НЕЧЕТНЫХ ЧИСЕЛ");
        int segmentStart = -10;
        int segmentEnd = 21;
        int counter = segmentStart;
        int evenSum = 0;
        int oddSum = 0;

        do {
            if (counter % 2 == 0) {
                evenSum += counter;
            } else {
                oddSum += counter;
            }
            counter++;
        } while (counter <= segmentEnd);

        System.out.println("В отрезке " + "[" + segmentStart + "," + segmentEnd + "]" +
                " сумма четных чисел = " + evenSum + ", а нечетных = " + oddSum);

        // новое решение
        System.out.println("\n2. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
        int maxNumber = 10;   
        int numberB = 5;
        int minNumber = -1;

        if (numberB > maxNumber && maxNumber > minNumber) {
            maxNumber = numberB;
        } else if (numberB < minNumber && minNumber < maxNumber) {
            minNumber = numberB;
        } else if (numberB > minNumber && minNumber > maxNumber) {
            minNumber = maxNumber;
            maxNumber = numberB;
        } else if (numberB < maxNumber && maxNumber < minNumber) {
            maxNumber = minNumber;
            minNumber = numberB;
        } else if (maxNumber < numberB && numberB < minNumber) {
            numberB = minNumber;
            minNumber = maxNumber;
            maxNumber = numberB;
        }

        for (int i = --maxNumber; i > minNumber; i--) {
            System.out.print(i + " ");
        }

        // старое решение
        System.out.println("\n\n2. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
        int numA = -1;
        int numB = 10;
        int numC = 5;
        int maxNum = numA;
        int minNum = numC;

        if (numB > numA && numB > numC) {
            maxNum = numB;
            if (numC > numA) {
                minNum = numA;
            }
        } else if (numC > numA && numC > numB) {
            maxNum = numC;
            if (numA > numB) {
                minNum = numB;
            } else {
                minNum = numA;
            }
        } else if (numA > numB && numA > numC && numC > numB) {
            minNum = numB;
        }
        
        for (int i = --maxNum; i > minNum; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. ВЫВОД РЕВЕРСИВНОГО ЧИСЛА И СУММЫ ЕГО ЦИФР");
        int originalNum = 1234;
        int digitsSum = 0;
        System.out.print("Исходное число " + originalNum + " в обратном порядке = ");

        while (originalNum % 10 > 0) {
            int lastDigit = originalNum % 10;
            originalNum /= 10;
            digitsSum += lastDigit;
            System.out.print(lastDigit);
        }

        System.out.println("\nСумма цифр выведенного выше числа = " + digitsSum);

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

        while (currNum % 10 > 0) {
            int lastDigit = currNum % 10;
            if (lastDigit == 2) {
                twoCount++;
            }
            currNum /= 10;
        }

        System.out.print("В " + originalNum);
        if (twoCount > 0) {
            if (twoCount % 2 != 0) {
                System.out.print(" не");
            }
            System.out.print(" четное " + "(" + twoCount + ")" + " количество двоек\n");
        } else {
            System.out.println(" нет двоек\n");
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

        System.out.println("\n6.3 Равнобедренный треугольник");
        // над этой еще туплю

        System.out.println("\n7. ВЫВОД ASCII-СИМВОЛОВ\n");

        System.out.printf("%-10s%-12s%s", "DECIMAL", "CHARACTER", "DESCRIPTION" + "\n");

        for (int i = 0; i < 255; i++) {
            char asciiChar = (char) i;
            boolean isTrueCondition = (i > 32 && i < 48 && i % 2 != 0) ||
                    (i > 96 && i < 123 && i % 2 == 0);
            if (isTrueCondition) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        System.out.printf("%4d", (int) asciiChar);
                    } else if (j == 1) {
                        System.out.printf("%11c", asciiChar);
                    } else {
                        System.out.printf("%12s%s", " ", Character.getName(asciiChar));
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
        String happyNum = "счастливое";
        int firstNum = originalNum / 1000;
        int firstNumSum = 0;
        int secondNum = originalNum % 1000;
        int secondNumSum = 0;
        int firstNumCopy = firstNum;
        int secondNumCopy = secondNum;

        for (int j = 0; j < 6; j++) {
            reversed = firstNumCopy % 10;
            firstNumCopy /= 10;
            firstNumSum += reversed;

            reversed = secondNumCopy % 10;
            secondNumCopy /= 10;
            secondNumSum += reversed;
        }
        System.out.print("Число " + originalNum + " - ");

        if (firstNumSum == secondNumSum) {
            System.out.println(happyNum);
        } else {
            System.out.println("не " + happyNum);
        }
        System.out.println("Сумма цифр " + firstNum + " = " + firstNumSum + "\n" +
                "Сумма цифр " + secondNum + " = " + secondNumSum);

        System.out.println("\n10. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ ПИФАГОРА \n");

        System.out.println("  |  2  3  4  5  6  7  8  9\n" +
                "--+------------------------");

        for (int i = 2; i <= 9; i++) {
            for (int j = 2 - 1; j <= 9; j++) {
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