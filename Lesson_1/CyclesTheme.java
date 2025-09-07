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
                System.out.printf("%-10d%-12c%s%n", (int) asciiChar, asciiChar, Character.getName(asciiChar));
            }
        }

        System.out.println("\n\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("-");
            }
            
            System.out.print(" ");
            
            for (int j = 6 - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print(" ");
            
            for (int j = 1; j < i * 2; j++) {
                System.out.print("^");
            }
            
            System.out.println();
        } 

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
        int numbersCountInLine = 5;

        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%5d", i);
            numberCount++;

            if (numberCount % numbersCountInLine == 0) {
                System.out.println();
            }
        }

        int zeroCount = numbersCountInLine - (numberCount % numbersCountInLine);
        if (zeroCount < numbersCountInLine) {
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
        int reversedNum = 0;
        int twoCount = 0;

        while (currNum > 0) {
            int remainder = currNum % 10;
            if (remainder == 2) {
                twoCount++;
            }  
            reversedNum = reversedNum * 10 + remainder;
            currNum /= 10;
        }
        
        String palindorme = (originalNum == reversedNum) ? " - палиндром" : " - не палиндром";
        String evenOrOdd = (twoCount > 0) ?
                (twoCount % 2 == 0) ? " с четным (" + twoCount + ") количеством + двоек"
                : " с нечетным (" + twoCount + ") количеством двоек" : " без двоек";
              
        System.out.println(reversedNum + palindorme + evenOrOdd);

        System.out.println("\n\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        originalNum = 104005;
        int leftHalfNum = originalNum / 1000;
        int leftHalfSum = 0;
        int rightHalfNum = originalNum % 1000;
        int rightHalfSum = 0;
        int leftHalfCopy = leftHalfNum;
        int rightHalfCopy = rightHalfNum;

        for (int j = 0; j < 3; j++) {
            int remainder = leftHalfCopy % 10;
            leftHalfCopy /= 10;
            leftHalfSum += remainder;

            remainder = rightHalfCopy % 10;
            rightHalfCopy /= 10;
            rightHalfSum += remainder;
        }

        String happyNum = (leftHalfSum == rightHalfSum) ? " счастливое число" : " не счастливое число";
   
        System.out.printf("""
                %d - %s
                Сумма цифр %03d = %d
                Сумма цифр %03d = %d
                """, originalNum, happyNum, leftHalfNum, leftHalfSum, rightHalfNum, rightHalfSum);

        System.out.println("\n\n8. ГЕНЕРАТОР ПАРОЛЯ");
        Random random = new Random();
        String password = "";
        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecChar = false;

        for (int i = 0; i < 8; i++) {
            char currChar = (char) random.nextInt(33, 127);
            password += currChar;
            
            if (Character.isUpperCase(currChar)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(currChar)) {
                hasLowerCase = true;
            } else if (!Character.isLetterOrDigit(currChar)) {
                hasSpecChar = true;
            } else if (Character.isDigit(currChar)) {
                hasDigit = true;
            }        
        }
            
        boolean isStrong = (hasLowerCase && hasUpperCase && hasSpecChar);
        boolean isGood = (hasUpperCase || hasDigit);

        String passwordStrength = "Слабый";
            
        if (isStrong) {
            passwordStrength = "Надежный";
        } else if (isGood) {
            passwordStrength = "Средний";
        } 
            
        System.out.printf("""
                Пароль: %s
                Надежность: %s
                """, password, passwordStrength);
    }
}