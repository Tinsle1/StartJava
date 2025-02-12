import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. ВЫВОД ХАРАКТЕРИСТИК КОМПЬЮТЕРА");
        byte coreCount = 5; 
        System.out.println("Количество ядер процессора = " + coreCount);

        short windowsEdition = 11;
        System.out.println("Версия Windows = " + windowsEdition + " Pro");

        int pcPrice = 120_000;
        System.out.println("Стоимость ПК = " + pcPrice);

        long productId = 330_524_547;
        System.out.println("ID продукта = " + productId);

        float ramCapacity = 16.0F;
        System.out.println("Емкость оперативной памяти = " + ramCapacity + " ГБ");

        double osBuild = 22631.4751;
        System.out.println("OS Build = " + osBuild);

        boolean isProWindows = true;
        System.out.println("Это версия Pro? = " + isProWindows);

        char windowsSymbol = 0x57;
        System.out.println("Знак Windows = " + windowsSymbol + "\n");

        System.out.println("2. РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double discount = 0.11;       
        double fullPriceSum = penPrice + bookPrice;
        double discountSum = fullPriceSum * discount;
        double discountPriceSum = fullPriceSum - discountSum;
        System.out.println("Стоимость товаров без скидки = " +
                fullPriceSum + " руб." + "\nСумма скидки = " +
                discountSum + " руб." + "\nСтоимость товаров со скидкой = " +
                discountPriceSum + " руб.\n");

        System.out.println("3. ВЫВОД СЛОВА JAVA\n");
        System.out.println("    J    a  v     v  a\n" +
                "    J   a a  v   v  a a\n" +
                " J  J  aaaaa  V V  aaaaa\n" +
                "  JJ  a     a  V  a     a\n");

        System.out.println("4. ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ");

        System.out.println("\n5. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        int firstNum = 10;
        int secondNum = -5;
        System.out.println("Исходные значения переменных: firstNum = " +
                firstNum + ", secondNum = " + secondNum);

        int thirdNum = firstNum - secondNum;
        int firstNum1 = firstNum - thirdNum;
        int secondNum1 = secondNum + thirdNum;
        System.out.println("\n5.1. Перестановка с помощью третей переменной thirdNum" + 
                "\n" + "Новые значения: firstNum1 = " + firstNum1 +
                ", secondNum1 = " + secondNum1);

        int firstNum2 = firstNum - (firstNum - secondNum);
        int secondNum2 = secondNum - (secondNum - firstNum);
        System.out.println("\n5.2. Перестановка с помощью арифметических операций" + 
                "\n" + "Новые значения: firstNum2 = " + firstNum2 +
                ", secondNum2 = " + secondNum2);

        System.out.println("\n6. ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char symbol36 = '$';
        System.out.println("Символ с кодом 36 = " + symbol36);

        char symbol42 = '*';
        System.out.println("Символ с кодом 42 = " + symbol42);

        char symbol64 = '@';
        System.out.println("Символ с кодом 64 = " + symbol64);

        char symbol94 = '^';
        System.out.println("Символ с кодом 94 = " + symbol94);

        char symbol126 = '~';
        System.out.println("Символ с кодом 126 = " + symbol126);

        System.out.println("\n7. ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char symbol47 = '/';
        char symbol92 = '\\';
        char symbol95 = '_';
        char symbol40 = '(';
        char symbol41 = ')';
        System.out.println("    " + symbol47 + symbol92 + "\n" +
                "   " + symbol47 + "  " + symbol92 + "\n" +
                "  " + symbol47 + symbol95 + symbol40 + " " +
                symbol41 + symbol92 + "\n" + " " + symbol47 +
                "      " + symbol92 + "\n" + symbol47 + symbol95 +
                symbol95 + symbol95 + symbol95 + symbol47 + symbol92 +
                symbol95 + symbol95 + symbol92);

        System.out.println("\n8. МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА");
        int originalNum = 123;
        int countHundreds = originalNum / 100;
        int countTen = originalNum / 10 % 10;
        int countOnes = originalNum % 100 % 10;
        int positionsSum = countHundreds + countTen + countOnes;
        int positionsMultiplication = countHundreds * countTen * countOnes;
        System.out.println("Число 123 содержит:\n" +
                "  сотен - " + countHundreds + "\n" +
                "  десятков - " + countTen + "\n" +
                "  единиц - " + countOnes + "\n" +
                "Сумма разрядов = " + positionsSum +
                "\n" + "Произведение разрядов = " +
                positionsMultiplication);

        System.out.println("\n9. ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ");
        int allSeconds = 86399;

        // вычисляем секунды
        int seconds = allSeconds % 60;

        // вычисляем минуты
        int minutes = allSeconds / 60 % 60;

        // вычисляем часы
        int hours = allSeconds / 3600;
        System.out.println(hours + ":" + minutes + ":" + seconds);

        System.out.println("\n10. *РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        BigDecimal penPrice2 = new BigDecimal("105.5");
        BigDecimal bookPrice2 = new BigDecimal("235.83");
        BigDecimal discount2 = new BigDecimal("0.11");
        BigDecimal fullPriceSum2 = penPrice2.add(bookPrice2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountSum2 = fullPriceSum2.multiply(discount2);
        BigDecimal discountPriceSum2 = fullPriceSum2.subtract(discountSum2);

        System.out.println("Стоимость товаров без скидки = " +
                fullPriceSum2 + " руб." + "\nСумма скидки = " +
                discountSum2 + " руб." + "\nСтоимость товаров со скидкой = " +
                discountPriceSum2 + " руб.\n");
    }
}