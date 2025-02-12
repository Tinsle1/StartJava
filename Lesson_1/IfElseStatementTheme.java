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

        char firstLetterOfName = "Larisa".charAt(0);
        if (firstLetterOfName == 'М') {
            System.out.println("Имя начинается на 'M'");
        } else if (firstLetterOfName == 'I') {
            System.out.println("Имя начинается на 'I'");
        } else {
            System.out.println("Имя начинается на другую букву");
        }

        System.out.println("\n2. ПОИСК БОЛЬШЕГО ЧИСЛА");
        int firstNum = -1;
        int secondNum = 6;

        if (firstNum == secondNum) {
            System.out.println("Числа равны");
        } else if (firstNum > secondNum) {
            System.out.println(firstNum + " больше " + secondNum);
        } else {
            System.out.println(secondNum + " больше " + firstNum);
        }

        System.out.println("\n3. ПРОВЕРКА ЧИСЛА");
        int intNum = -71;

        if (intNum == 0) {
            System.out.println("Число intNum = 0");
            return;
        }
        if (intNum % 2 == 0 && intNum > 0) {
            System.out.println(intNum + " является четным и положительным");
        } else if (intNum % 2 == 0 && intNum < 0) {
            System.out.println(intNum + " является четным и отрицательным");
        } else if (intNum % 2 != 0 && intNum > 0) {
            System.out.println(intNum + " является нечетным и положительным");
        } else {
            System.out.println(intNum + " является нечетным и отрицательным");
        }

        System.out.println("\n4. ПОИСК ОДИНАКОВЫХ ЦИФР В ЧИСЛАХ");
        int intNum1 = 123;
        int intNum2 = 223;
        System.out.println("Исходные числа: " + intNum1 + ", " + intNum2);

        if (intNum1 / 100 == intNum2 / 100) {
            System.out.println("Разряды сотен одинаковы = " + intNum2 / 100);
        } 
        if (intNum1 / 10 % 10 == intNum2 / 10 % 10) {
            System.out.println("Разряды десяток одинаковы = " + intNum2 / 10 % 10);
        } 
        if (intNum1 % 10 == intNum2 % 10) {
            System.out.println("Разряды единиц одинаковы = " + intNum2 % 10);
        } else {
            System.out.println("Равных цифр нет");
            return;
        }

        System.out.println("\n5. ОПРЕДЕЛЕНИЕ СИМВОЛА ПО ЕГО КОДУ");

        System.out.println("\n6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        double depositSum = 321123.59;
        double sumRangeTop = 300000;
        double sumRangeBottom = 100000;
        double depositInterestSum = 0;
        double generalSum = 0;
        double depositInterest = 0;

        if (depositSum > sumRangeTop) {
            depositInterest = 0.1;
            depositInterestSum = depositInterest * depositSum;
            generalSum = depositSum + depositInterestSum;
        } else if (depositSum < sumRangeTop && depositSum > sumRangeBottom) {
            depositInterest = 0.07;
            depositInterestSum = depositInterest * depositSum;
            generalSum = depositSum + depositInterestSum;
        } else if (depositSum < sumRangeBottom) {
            depositInterest = 0.05;
            depositInterestSum = depositInterest * depositSum;
            generalSum = depositSum + depositInterestSum;
        } 
        System.out.println("Сумма вклада = " + depositSum + "\n" +
                "Сумма начисленного % = " + depositInterestSum + "\n" +
                "Итоговая сумма с % = " + generalSum);

        System.out.println("\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyRate = 59;
        int programmingRate = 92;
        int historyGrade = 0;
        int programmingGrade = 0;
        double medianRate = (historyRate + programmingRate) / 2.0;

        if (historyRate > 91) {
            historyGrade = 5;
        } else if (historyRate > 73) {
            historyGrade = 4;
        } else if (historyRate > 60) {
            historyGrade = 3;
        } else if (historyRate <= 60) {
            historyGrade = 2;
        }

        if (programmingRate > 91) {
            programmingGrade = 5;
        } else if (programmingRate > 73) {
            programmingGrade = 4;
        } else if (programmingRate > 60) {
            programmingGrade = 3;
        } else if (programmingRate <= 60) {
            programmingGrade = 2;
        }

        double medianGrade = (historyGrade + programmingGrade) / 2.0;
        System.out.println("Оценка по истории = " + historyGrade +
                "\n" + "Оценка по программированию = " + programmingGrade +
                "\n" + "Средний балл оценок = " + medianGrade +
                "\n" + "Средний % по предметам = " + medianRate);

        System.out.println("\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        double monthRevenue = 13025.233;
        double monthRentSum = 5123.018;
        double monthCostPrice = 9001.729;
        double yearProfit = (monthRevenue * 12) - (monthRentSum * 12) - (monthCostPrice * 12);

        if (yearProfit > 0) {
            System.out.println("Прибыль за год: +" + yearProfit + " руб.");
        } else {
            System.out.println("Прибыль за год: " + yearProfit + " руб.");
        }

        System.out.println("\n9. *РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ С BigDecimal");
        BigDecimal monthRevenue2 = new BigDecimal("13025.233");
        BigDecimal monthRentSum2 = new BigDecimal("5123.018");
        BigDecimal monthCostPrice2 = new BigDecimal("9001.729");
        BigDecimal monthsCount = new BigDecimal("12");

        BigDecimal yearRevenue2 = monthRevenue2.multiply(monthsCount);
        BigDecimal yearRentSum2 = monthRentSum2.multiply(monthsCount);
        BigDecimal yearCostPrice2 = monthCostPrice2.multiply(monthsCount);
        BigDecimal yearProfit2 = ((yearRevenue2.subtract(yearRentSum2)).subtract(
                yearCostPrice2)).setScale(2, RoundingMode.HALF_UP);

        if (yearProfit2.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Прибыль за год: +" + yearProfit2 + " руб.");
        } else {
            System.out.println("Прибыль за год: " + yearProfit2 + " руб.");
        }

        System.out.println("\n10. *ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ % C BigDecimal");
        BigDecimal depositSum2 = new BigDecimal("321123.59");
        BigDecimal sumRangeTop2 = new BigDecimal("300000");
        BigDecimal sumRangeBottom2 = new BigDecimal("100000");
        BigDecimal depositInterestSum2 = new BigDecimal(0);
        BigDecimal generalSum2 = new BigDecimal(0);

        if (depositSum2.compareTo(sumRangeTop2) == 1) {
            BigDecimal depositInterest2 = new BigDecimal("0.1");
            depositInterestSum2 = depositInterest2.multiply(depositSum2);
            generalSum2 = depositSum2.add(depositInterestSum2);
        } else if (depositSum2.compareTo(sumRangeTop2) == -1 &&
                    depositSum2.compareTo(sumRangeBottom2) == 1) {
            BigDecimal depositInterest2 = new BigDecimal("0.07");
            depositInterestSum2 = depositInterest2.multiply(depositSum2);
            generalSum2 = depositSum2.add(depositInterestSum2);
        } else if (depositSum2.compareTo(sumRangeBottom2) == -1) {
            BigDecimal depositInterest2 = new BigDecimal("0.05");
            depositInterestSum2 = depositInterest2.multiply(depositSum2);
            generalSum2 = depositSum2.add(depositInterestSum2);
        } 
        System.out.println("Сумма вклада = " + depositSum2.setScale(2, RoundingMode.HALF_UP) +
                "\n" + "Сумма начисленного % = " +
                depositInterestSum2.setScale(2, RoundingMode.HALF_UP) +
                "\n" + "Итоговая сумма с % = " + generalSum2.setScale(2, RoundingMode.HALF_UP));
    }
}