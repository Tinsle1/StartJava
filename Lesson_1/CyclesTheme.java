import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. ВЫВОД ASCII-СИМВОЛОВ");

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

        System.out.println("\n\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");

        System.out.println("Прямоугольник");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("-");
            }
            System.out.println();
        }

        System.out.println("\nПрямоугольный треугольник");
        for (int i = 0; i < 5; i++) {
            for (int j = 5 - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nРавнобедренный треугольник");
        // тут пока не додумалась, пропускаю 

        System.out.println("\n\n3. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ ПИФАГОРА");
        System.out.print("""
                |  2  3  4  5  6  7  8  9
              --+------------------------
                """);
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    System.out.print(i * j + " |");
                } else {
                    System.out.printf("%3d", i * j);
                }
            }
            System.out.println();
        }

        System.out.println("\n\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
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

        System.out.println("\n\n\n5. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
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

        System.out.println("\n\n\n6. РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int originalNum = 2234321;
        int currNum = originalNum;
        int reversed = 0;
        int twoCount = 0;
      
        while (currNum > 0) {
            if (currNum % 10 == 2) {
                twoCount++;
            }  
            
            reversed = reversed * 10 + currNum % 10;
            currNum /= 10;
        }
        
        String palindorm = (originalNum == reversed) ? " - палиндром" : " - не палиндром";
        String evenness = (twoCount % 2 == 0) ?
                " с четным (" + twoCount + ") количеством + двоек"
                : " с нечетным (" + twoCount + ") количеством двоек";
        System.out.println(originalNum + palindorm + evenness);

        System.out.println("\n\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        originalNum = 104002;
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

        String happyNum = (firstNumSum == secondNumSum) ? " счастливое число" : " не счастливое число";
   
        System.out.printf("""
        %d - %s
        Сумма цифр %03d = %d
        Сумма цифр %03d = %d
                """, originalNum, happyNum, firstNum, firstNumSum, secondNum, secondNumSum);

        System.out.println("\n\n8. ГЕНЕРАТОР ПАРОЛЯ");
        Random random = new Random();
        String password = "";
        String passwordStatus = "Слабый";
        int countDigit = 0;
        int countLowerCase = 0;
        int countUpperCase = 0;
        int countSpecChar = 0;

        for (int i = 0; i < 8; i++) {
            char currChar = (char) random.nextInt(33, 127);
            password += currChar;
            
            if (Character.isUpperCase(currChar)) {
                countUpperCase++;
            } else if (Character.isLowerCase(currChar)) {
                countLowerCase++;
            } else if (!Character.isLetterOrDigit(currChar)) {
                countSpecChar++;
            } else if (Character.isDigit(currChar)) {
                countDigit++;
            }        
        }
            
        boolean isStrong = (countLowerCase > 0 && countUpperCase > 0 && countSpecChar > 0);
        boolean isGood = ((countUpperCase + countDigit) > 0);
            
        if (isStrong) {
            passwordStatus = "Надежный";
        } else if (isGood) {
            passwordStatus = "Средний";
        } 
            
        System.out.printf("""
                Пароль: %s
                Надежность: %s
                 """, password, passwordStatus);
    }
}