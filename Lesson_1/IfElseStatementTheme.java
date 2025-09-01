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
        int firstDaySteps = 10000;
        int secondDaySteps = 60000;
        int totalSteps = firstDaySteps + secondDaySteps;
        double averageSteps = totalSteps / 2.0;

        System.out.println("Всего шагов за два дня: " + totalSteps);
        if (firstDaySteps == secondDaySteps) {
            System.out.println("Равное количество шагов в оба дня: " + firstDaySteps);
        } else if (firstDaySteps > secondDaySteps) {
            System.out.println("В первый день больше шагов(" + firstDaySteps +
                    "), чем во второй(" + secondDaySteps + ")");
        } else {
            System.out.println("Во второй день больше шагов(" + secondDaySteps +
                    "), чем в первый(" + firstDaySteps + ")");
        }
        System.out.println("В среднем шагов в день: " + averageSteps);

        System.out.println("\n\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestsAmount = -60;

        if (guestsAmount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsAmount < 0) {
            System.out.println("Число гостей не может быть отрицательным. Введите повторно");
        } else if (guestsAmount % 2 == 0) {
            System.out.println("Записалось " + guestsAmount +
                    " гостей. Можно формировать пары для конкурсов.");
        } else {
            System.out.println("Записалось " + guestsAmount +
                    " гостей. Нужны индивидуальные задания.");
        }

        System.out.println("\n\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String name = "8Larisa";
        char firstLetter = name.charAt(0);

        System.out.println("Первый способ");
        if (firstLetter > 96 && firstLetter < 123) {
            System.out.println(firstLetter + " = маленькая буква");
        } else if (firstLetter > 64 && firstLetter < 91) {
            System.out.println(firstLetter + " = большая буква");
        } else if (firstLetter > 47 && firstLetter < 58) {
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
        int firstNum = 623;
        int secondNum = 623;
        boolean isEqualHundreds = firstNum / 100 == secondNum / 100;
        boolean isEqualTens = firstNum / 10 % 10 == secondNum / 10 % 10;
        boolean isEqualOnes = firstNum % 10 == secondNum % 10;
        System.out.println("Исходные числа: " + firstNum + ", " + secondNum);
        if (firstNum == secondNum) {
            System.out.println("Числа равны");
        } else if (isEqualHundreds || isEqualTens || isEqualOnes) {
            System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%03d]
                        Фактический: [№%03d]
                    """, firstNum, secondNum);
        } 

        System.out.println("\n\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("\n1-й способ решения");
        float penPrice = 105.5F;
        float bookPrice = 235.23F;
        float discount = 0.11F;       
        float baseSum = penPrice + bookPrice;
        float discountSum = baseSum * discount;
        float discountPrice = baseSum - discountSum;
        System.out.println("Стоимость товаров без скидки = " + baseSum + " руб." +
                "\nСумма скидки = " + discountSum + " руб." +
                "\nСтоимость товаров со скидкой = " + discountPrice + " руб.\n");

        System.out.println("2-й способ решения");
        BigDecimal penPriceBd = BigDecimal.valueOf(105.5);
        BigDecimal bookPriceBd = BigDecimal.valueOf(235.23);
        BigDecimal discountBd = BigDecimal.valueOf(0.11);
        BigDecimal baseSumBd = penPriceBd.add(bookPriceBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountSumBd = baseSumBd.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountPriceBd = baseSumBd.subtract(discountSumBd).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки = " + baseSumBd + " руб." +
                "\nСумма скидки = " + discountSumBd + " руб." +
                "\nСтоимость товаров со скидкой = " + discountPriceBd + " руб.");

        System.out.println("\n\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyRate = 59;
        int historyGrade = 2;

        if (historyRate > 91) {
            historyGrade = 5;
        } else if (historyRate > 73) {
            historyGrade = 4;
        } else if (historyRate > 60) {
            historyGrade = 3;
        } 

        int programmingRate = 92;
        int programmingGrade = 2;

        if (programmingRate > 91) {
            programmingGrade = 5;
        } else if (programmingRate > 73) {
            programmingGrade = 4;
        } else if (programmingRate > 60) {
            programmingGrade = 3;
        } 

        double averageRate = (historyRate + programmingRate) / 2.0;
        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        System.out.println("Оценка по истории = " + historyGrade +
                "\nОценка по программированию = " + programmingGrade +
                "\nСредний балл оценок = " + averageGrade +
                "\nСредний % по предметам = " + averageRate);

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