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
        double baseSum = penPrice + bookPrice;
        double discountSum = baseSum * discount;
        double discountPrice = baseSum - discountSum;
        System.out.println("Стоимость товаров без скидки = " + baseSum + " руб." +
                "\nСумма скидки = " + discountSum + " руб." +
                "\nСтоимость товаров со скидкой = " + discountPrice + " руб.\n");

        System.out.println("3. ВЫВОД СЛОВА JAVA\n");
        System.out.println("    J    a  v     v  a\n" +
                "    J   a a  v   v  a a\n" +
                " J  J  aaaaa  V V  aaaaa\n" +
                "  JJ  a     a  V  a     a\n");

        System.out.println("4. ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ");
        byte someByte = 127;
        short someShort = 32_767;
        int someInt = 2_147_483_647;
        long someLong = 9_223_372_036_854_775_807L;
        char someChar = 65_535;
        System.out.println(someByte + ", " + ++someByte + ", " + --someByte);
        System.out.println(someShort + ", " + ++someShort + ", " + --someShort);
        System.out.println(someInt + ", " + ++someInt + ", " + --someInt);
        System.out.println(someLong + ", " + ++someLong + ", " + --someLong);
        System.out.println(someChar + ", " + ++someChar + ", " + --someChar);

        System.out.println("\n5. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        int firstNum = 0;
        int secondNum = -8;
        System.out.println("Исходные значения переменных: firstNum = " +
                firstNum + ", secondNum = " + secondNum);
                
        int thirdNum = firstNum - secondNum;
        firstNum -= thirdNum;
        secondNum += thirdNum;
        System.out.println("\n5.1. Перестановка с помощью третей переменной thirdNum" + 
                "\n" + "Новые значения: firstNum = " + firstNum +
                ", secondNum = " + secondNum);
                
        firstNum = (firstNum + secondNum) - firstNum;
        secondNum -= thirdNum;
        System.out.println("\n5.1. Перестановка с помощью арифметических операций" +
                "\n" + "Новые значения: firstNum = " + firstNum +
                ", secondNum = " + secondNum);

        System.out.println("\n6. ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char dollar = '$';
        char asterisk = '*';
        char at = '@';
        char caret = '^';
        char tilde = '~';

        System.out.println("Символ dollar = " + dollar +
                "\n" + "Символ asterisk = " + asterisk +
                "\n" + "Символ at = " + at +
                "\n" + "Символ caret = " + caret +
                "\n" + "Символ tilde = " + tilde);

        System.out.println("\n7. ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char forwardSlash = '/';
        char backSlash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + forwardSlash + backSlash + "\n" +
                "   " + forwardSlash + "  " + backSlash + "\n" +
                "  " + forwardSlash + underscore + leftParenthesis + " " +
                rightParenthesis + backSlash + "\n" + " " + forwardSlash +
                "      " + backSlash + "\n" + forwardSlash + underscore +
                underscore + underscore + underscore + forwardSlash + backSlash +
                underscore + underscore + backSlash);

        System.out.println("\n8. МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА");
        int originalNum = 123;
        int hundredCount = originalNum / 100;
        int tenCount = originalNum / 10 % 10;
        int oneCount = originalNum % 100 % 10;
        int sum = hundredCount + tenCount + oneCount;
        int multiplication = hundredCount * tenCount * oneCount;
        System.out.println("Число 123 содержит:\n" +
                "  сотен - " + hundredCount + "\n" +
                "  десятков - " + tenCount + "\n" +
                "  единиц - " + oneCount + "\n" +
                "Сумма разрядов = " + sum +
                "\n" + "Произведение разрядов = " + multiplication);

        System.out.println("\n9. ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ");
        int allSeconds = 86399;
        int ss = allSeconds % 60;
        int mm = allSeconds / 60 % 60;
        int hh = allSeconds / 3600;
        System.out.println(hh + ":" + mm + ":" + ss);

        System.out.println("\n10. *РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        BigDecimal penPrice2 = new BigDecimal("105.5");
        BigDecimal bookPrice2 = new BigDecimal("235.83");
        BigDecimal discount2 = new BigDecimal("0.11");
        BigDecimal basePrice2 = penPrice2.add(bookPrice2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountSum2 = basePrice2.multiply(discount2);
        BigDecimal discountPrice2 = basePrice2.subtract(discountSum2);

        System.out.println("Стоимость товаров без скидки = " + basePrice2 + " руб." +
                "\nСумма скидки = " + discountSum2 + " руб." +
                "\nСтоимость товаров со скидкой = " + discountPrice2 + " руб.\n");
    }
}