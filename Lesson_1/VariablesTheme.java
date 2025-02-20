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
        byte maxByteValue = 127;
        byte minByteValue = -128;
        short maxShortValue = 32_767;
        short minShortValue = -32_768;
        int maxIntValue = 2_147_483_647;
        int minIntValue = -2_147_483_648;
        long maxLongValue = 9_223_372_036_854_775_807L;
        long minLongValue = -9_223_372_036_854_775_808L;
        char maxCharValue = 65_535;
        char minCharValue = 0;
        System.out.println(maxByteValue + ", " + ++maxByteValue + ", " + --maxByteValue);
        System.out.println(minByteValue + ", " + ++minByteValue + ", " + --minByteValue);
        System.out.println(maxShortValue + ", " + ++maxShortValue + ", " + --maxShortValue);
        System.out.println(minShortValue + ", " + ++minShortValue + ", " + --minShortValue);
        System.out.println(maxIntValue + ", " + ++maxIntValue + ", " + --maxIntValue);
        System.out.println(minIntValue + ", " + ++minIntValue + ", " + --minIntValue);
        System.out.println(maxLongValue + ", " + ++maxLongValue + ", " + --maxLongValue);
        System.out.println(minLongValue + ", " + ++minLongValue + ", " + --minLongValue);
        System.out.println((int) maxCharValue + ", " + (int) ++maxCharValue + ", " +
                (int) --maxCharValue);
        System.out.println((int) minCharValue + ", " + (int) ++minCharValue + ", " +
                (int) --minCharValue);

        System.out.println("\n5. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        int firstNum = 2;
        int secondNum = 5;
        System.out.println("Исходные значения переменных: firstNum = " +
                firstNum + ", secondNum = " + secondNum);

        System.out.println("\n5.1. Перестановка с помощью третей переменной thirdNum");        
        int thirdNum = firstNum;
        firstNum = secondNum;
        secondNum = thirdNum;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);
                
        System.out.println("\n5.2. Перестановка с помощью арифметических операций");       
        firstNum = firstNum + secondNum;
        secondNum = firstNum - secondNum;
        firstNum = firstNum - secondNum;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);

        System.out.println("\n5.3. Перестановка с помощью побитовой операции ^");
        firstNum = firstNum ^ secondNum;
        secondNum = firstNum ^ secondNum;
        firstNum = firstNum ^ secondNum;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);
        
        System.out.println("\n6. ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char dollar = '$';
        char asterisk = '*';
        char at = '@';
        char caret = '^';
        char tilde = '~';

        System.out.println("Код " + (int) dollar + " = символу " + dollar + "\n" +
                "Код " + (int) asterisk + " = символу " + asterisk + "\n" +
                "Код " + (int) at + " = символу " + at + "\n" +
                "Код " + (int) caret + " = символу " + caret + "\n" +
                "Код " + (int) tilde + " = символу " + tilde);

        System.out.println("\n7. ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + slash + backslash + "\n" +
                "   " + slash + "  " + backslash + "\n" +
                "  " + slash + underscore + leftParenthesis + " " +
                rightParenthesis + backslash + "\n" + " " + slash +
                "      " + backslash + "\n" + slash + underscore +
                underscore + underscore + underscore + slash + backslash +
                underscore + underscore + backslash);

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
        BigDecimal baseSum2 = penPrice2.add(bookPrice2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountSum2 = baseSum2.multiply(discount2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountPrice2 = baseSum2.subtract(discountSum2).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Стоимость товаров без скидки = " + baseSum2 + " руб." +
                "\nСумма скидки = " + discountSum2 + " руб." +
                "\nСтоимость товаров со скидкой = " + discountPrice2 + " руб.\n");
    }
}