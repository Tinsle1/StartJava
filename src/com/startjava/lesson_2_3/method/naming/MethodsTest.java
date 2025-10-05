package com.startjava.lesson_2_3.method.naming;

public class MethodsTest {
    public static void main(String[] args) {
        MethodsTest methodsTest = new MethodsTest();
        methodsTest.doNonBooleanMethods();
        methodsTest.doBooleanMethods();
    }

    private void doNonBooleanMethods() {
        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        NonBooleanMethods nonBm = new NonBooleanMethods();

        nonBm.findLongestWord();
        nonBm.getMenuItem();
        nonBm.calculateAverageGrade();
        nonBm.countUniqueWords();
        nonBm.printError();
        nonBm.syncWithCloud();
        nonBm.restoreBackup();
        nonBm.pauseLoading();
        nonBm.resetToFactorySettings();
        nonBm.saveFileToUsb();
        nonBm.celsiusToFahrenheit();
        nonBm.printMathExpresion();
        nonBm.findWinner();
        nonBm.findBooksByAuthor();
    }

    private void doBooleanMethods() {
        System.out.println("\nBOOLEAN-МЕТОДЫ");
        BooleanMethods bm = new BooleanMethods();

        System.out.println(bm.shouldProgramEnd());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isDigit());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasMoreTry());
        System.out.println(bm.isEmptyLineOrSpaces());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExist());
    }
}