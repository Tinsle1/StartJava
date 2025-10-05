package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. ПЕРЕВОД ПСЕВДОКОДА НА JAVA");
        boolean isMale = false;
        if (!isMale) {
            System.out.println("Не надо в армию");
        } else {
            System.out.println("Надо в армию");
        }

        int age = 21;
        if (age > 18) {
            System.out.println("Пора в университет");
        } else {
            System.out.println("Доучись в школе");
        }

        float height = 1.6F;
        if (height < 1.8) {
            System.out.println("Иди на футбол");
        } else {
            System.out.println("Иди на баскетбол");
        }

        System.out.println("\n\n2. ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int stepsToday = 10000;
        int stepsYesterday = 60000;
        int totalSteps = stepsToday + stepsYesterday;
        double averageSteps = totalSteps / 2.0;

        System.out.println("Всего шагов за два дня: " + totalSteps);
        if (stepsToday == stepsYesterday) {
            System.out.println("Равное количество шагов за оба дня: " + stepsToday);
        } else if (stepsToday > stepsYesterday) {
            System.out.println("Сегодня шагов больше (" + stepsToday +
                    "), чем вчера(" + stepsYesterday + ")");
        } else {
            System.out.println("Вчера шагов больше (" + stepsYesterday +
                    "), чем сегодня(" + stepsToday + ")");
        }
        System.out.println("В среднем шагов в день: " + averageSteps);

        System.out.println("\n\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestsAmount = -60;

        if (guestsAmount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsAmount < 0) {
            System.out.println("Число гостей не может быть отрицательным. Введите повторно");
        } else if (guestsAmount % 2 == 0) {
            System.out.println("Записалось " + guestsAmount + " гостей. Можно формировать пары для конкурсов.");
        } else {
            System.out.println("Записалось " + guestsAmount + " гостей. Нужны индивидуальные задания.");
        }

        System.out.println("\n\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String name = "8Larisa";
        char firstLetter = name.charAt(0);

        System.out.println("Первый способ");
        if (firstLetter >= 'a' && firstLetter <= 'z') {
            System.out.println(firstLetter + " = маленькая буква");
        } else if (firstLetter >= 'A' && firstLetter <= 'Z') {
            System.out.println(firstLetter + " = большая буква");
        } else if (firstLetter >= '0' && firstLetter <= '9') {
            System.out.println(firstLetter + " = цифра");
        } else {
            System.out.println(firstLetter + " = прочий символ");
        }
    
        System.out.println("\nВторой способ");
        if (Character.isLowerCase(firstLetter)) {
            System.out.println(firstLetter + " = маленькая буква");
        } else if (Character.isUpperCase(firstLetter)) {
            System.out.println(firstLetter + " = большая буква");
        } else if (Character.isDigit(firstLetter)) {
            System.out.println(firstLetter + " = цифра");
        } else {
            System.out.println(firstLetter + "прочий символ");
        }

        System.out.println("\n\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSerialNumber = 863;
        int assetNumber = 863;

        if (dbSerialNumber == assetNumber) {
            System.out.printf("""
                    [№%03d]: компьютер на 3-м этаже в кабинете 2
                    """, dbSerialNumber);
        } else {
            int dbSerialNumHundreds = dbSerialNumber / 100;
            int dbSerialNumTens = dbSerialNumber / 10 % 10;
            int dbSerialNumOnes = dbSerialNumber % 10;
                    
            int assetNumberHundreds = assetNumber / 100;
            int assetNumberTens = assetNumber / 10 % 10;
            int assetNumberOnes = assetNumber % 10;
                  
            boolean isEqualHundreds = dbSerialNumHundreds == assetNumberHundreds;
            boolean isEqualTens = dbSerialNumTens == assetNumberTens;
            boolean isEqualOnes = dbSerialNumOnes == assetNumberOnes;
                    
            String hundredsOrNot = (isEqualHundreds) ? "" + assetNumberHundreds : "" + '_';
            String tensOrNot = (isEqualTens) ? "" + assetNumberTens : "" + '_';
            String onesOrNot = (isEqualOnes) ? "" + assetNumberOnes : "" + '_';
            String assetNumberToString = hundredsOrNot + tensOrNot + onesOrNot;

            if (isEqualHundreds || isEqualTens || isEqualOnes) {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%s]
                        """, dbSerialNumber, assetNumberToString);
            } else {
                System.out.printf("""
                        [№%03d]: оборудование не идентифицировано
                        """, dbSerialNumber);
            } 
        }
                
        System.out.println("\n\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("\n1-й способ решения");
        float depositSum = 321123.79F;
        float interest = 0.05F;

        if (depositSum > 100_000 && depositSum < 300_000) {
            interest = 0.07F;
        } else if (depositSum > 300_000) {
            interest = 0.1F;
        }

        float interestSum = depositSum * interest;
        float generalSum = interestSum + depositSum;

        System.out.printf("""
                Сумма вклада: %f руб.
                Сумма начисленного %c: %f руб.
                Итоговая сумма с %c: %f руб.
                """, depositSum, '%', interestSum, '%', generalSum);

        System.out.println("\n2-й способ решения");
        BigDecimal depositSumBd = BigDecimal.valueOf(321123.79);
        BigDecimal interestBd = BigDecimal.valueOf(0.05);

        if (depositSumBd.compareTo(BigDecimal.valueOf(100000)) == 1 && 
                depositSumBd.compareTo(BigDecimal.valueOf(300000)) == -1) {
            interestBd = BigDecimal.valueOf(0.07);
        } else if (depositSumBd.compareTo(BigDecimal.valueOf(300000)) == 1) {
            interestBd = BigDecimal.valueOf(0.1);
        }

        BigDecimal interestSumBd = depositSumBd.multiply(interestBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal generalSumBd = interestSumBd.add(depositSumBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Сумма вклада: " + depositSumBd + " руб." +
                "\nСумма начисленного %: " + interestSumBd + " руб." +
                "\nИтоговая сумма с %: " + generalSumBd + " руб.");

        System.out.println("\n\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyPercent = 59;
        int historyGrade = 2;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        } 

        int programmingPercent = 92;
        int programmingGrade = 2;

        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else if (programmingPercent > 60) {
            programmingGrade = 3;
        } 

        double averagePercent = (historyPercent + programmingPercent) / 2.0;
        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        System.out.println("Оценка по истории = " + historyGrade +
                "\nОценка по программированию = " + programmingGrade +
                "\nСредний балл оценок = " + averageGrade +
                "\nСредний % по предметам = " + averagePercent);

        System.out.println("\n\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ С BigDecimal");
        BigDecimal monthRevenue = BigDecimal.valueOf(13025.233);
        BigDecimal monthRentSum = BigDecimal.valueOf(5123.018);
        BigDecimal monthlyProductionCost = BigDecimal.valueOf(9001.729);
        BigDecimal monthsCount = BigDecimal.valueOf(12);

        BigDecimal yearProfit = ((monthRevenue.subtract(monthRentSum).subtract(
                monthlyProductionCost)).multiply(monthsCount)).setScale(2, RoundingMode.HALF_UP);

        if (yearProfit.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Прибыль за год: +" + yearProfit + " руб.");
        } else {
            System.out.println("Прибыль за год: " + yearProfit + " руб.");
        }
    }
}