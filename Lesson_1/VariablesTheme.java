import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public class VariablesTheme {
    public static void main(String[] args) {
        LocalTime timeNow1 = LocalTime.now();
        long startTime = System.nanoTime();

        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ\n");

        System.out.println("1.1 Вывод с помощью конкатенации");
        System.out.println(
                "                     /\\\n" +
                "   J    a  v     v  /  \\\n" +
                "   J   a a  v   v  /_( )\\\n" +
                "J  J  aaaaa  V V  /      \\\n" +
                " JJ  a     a  V  /___/\\___\\\n");

        System.out.println("1.2 Вывод с помощью строкового литерала");
        String block = """
                         /\\            
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a
                """;
        System.out.println(block);

        System.out.println("\n\n2. РАСЧЕТ СТОИМОСТИ ТОВАРА");
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
                "\nСтоимость товаров со скидкой = " + discountPriceBd + " руб.\n");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int firstNum = 2;
        int secondNum = 5;
        System.out.println("Исходные значения переменных: firstNum = " + firstNum +
                        ", secondNum = " + secondNum);

        System.out.println("\n3.1. Перестановка с помощью третей переменной tmp");        
        int tmp = firstNum;
        firstNum = secondNum;
        secondNum = tmp;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);
                
        System.out.println("\n3.2. Перестановка с помощью арифметических операций");       
        firstNum += secondNum;
        secondNum = firstNum - secondNum;
        firstNum -= secondNum;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);

        System.out.println("\n3.3. Перестановка с помощью побитовой операции ^");
        firstNum ^= secondNum;
        secondNum ^= firstNum;
        firstNum ^= secondNum;
        System.out.println("Новые значения: firstNum = " + firstNum + ", secondNum = " + secondNum);

        System.out.println("\n\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;

        System.out.printf("%4d%8d%8d%8d%8d%8d%n", code1, code2, code3, code4, code5, code6);
        System.out.printf("%3c%8c%8c%8c%8c%8c", code1, code2, code3, code4, code5, code6);

        System.out.println("\n\n5. АНАЛИЗ КОДА ТОВАРА");
        int productCode = 123;
        int category = productCode / 100;
        int subcategory = productCode / 10 % 10;
        int packageType = productCode % 100 % 10;
        int checksum = category + subcategory + packageType;
        int verificationCode = category * subcategory * packageType;
        System.out.printf("""
                Код товара: %d 
                   категория товара - %d 
                   подкатегория - %d 
                   тип упаковки - %d
                Контрольная сумма = %d 
                Проверочный код = %d""", productCode, category, subcategory,
                packageType, checksum, verificationCode);

        System.out.println("\n\n6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, temperature, ++temperature, --temperature);

        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, pressure, ++pressure, --pressure);

        int distance = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, км]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, distance, ++distance, --distance);

        long duration = Long.MAX_VALUE;
        System.out.printf("""
                [Время с момента старта, ч]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, duration, ++duration, --duration);

        char status = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, (int) status, (int) ++status, (int) --status);

        System.out.println("\n\n7. ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime rt = Runtime.getRuntime();
    
        double toMegaByte = 1024 * 1024;
        int coreCount = rt.availableProcessors();
    
        double totalMemory = rt.totalMemory() / toMegaByte;
        double freeMemory = rt.freeMemory() / toMegaByte;
        double maxMemory = rt.maxMemory() / toMegaByte;
        double usedMemory = totalMemory - freeMemory;

        String javaHome = System.getProperty("java.home");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String fileSeparator = System.getProperty("file.separator");
   
        System.out.printf("""
                ХАРАКТЕРИСТИКИ JVM: 
                доступное число ядер - %d
                выделенная память (МБ) - %.1f
                свободная память (Мб) - %.1f
                используемая память (Мб) - %.1f
                максимально доступная для \
                выделения память (Мб) - %.1f%n
                """, 
                coreCount, totalMemory, freeMemory, usedMemory, maxMemory);
           
        System.out.printf("""
                ПАРАМЕТРЫ ОС: 
                системный диск - %s
                версия ОС - %s
                версия Java - %s
                символ разделения пути (сепаратор) - %s""", 
                        javaHome.substring(0, 1), osVersion, javaVersion, fileSeparator);

        System.out.println("\n\n8. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        
        long endTime = System.nanoTime();
        double difference = (endTime - startTime) / 1e9;
        LocalTime timeNow2 = LocalTime.now();
        System.out.printf("""
                Старт проверки: %tT.%1$tL
                Финиш проверки: %tT.%2$tL
                Время работы:   %.3f сек
                """, timeNow1, timeNow2, difference);
    }
}