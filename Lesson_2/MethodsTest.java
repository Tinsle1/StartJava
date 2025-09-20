public class MethodsTest {
    public static void main(String[] args) {
        MethodsTest methodsTest = new MethodsTest();
        methodsTest.doNonBooleanMethods();
        methodsTest.doBooleanMethods();
    }

    public void doNonBooleanMethods() {
        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        NonBooleanMethods nonBooleanMethods = new NonBooleanMethods();

        nonBooleanMethods.findLongestWord();
        nonBooleanMethods.getMenuItem();
        nonBooleanMethods.calculateAverageGrade();
        nonBooleanMethods.countUniqueWords();
        nonBooleanMethods.printError();
        nonBooleanMethods.syncWithCloud();
        nonBooleanMethods.restoreBackup();
        nonBooleanMethods.pauseLoading();
        nonBooleanMethods.resetToFactorySettings();
        nonBooleanMethods.saveFileToUsb();
        nonBooleanMethods.celsiusToFahrenheit();
        nonBooleanMethods.printMathExpresion();
        nonBooleanMethods.findWinner();
        nonBooleanMethods.findBooksByAuthor();
    }

    public void doBooleanMethods() {
        System.out.println("\n\nBOOLEAN-МЕТОДЫ");
        BooleanMethods booleanMethods = new BooleanMethods();

        System.out.println(booleanMethods.shouldProgramEnd());
        System.out.println(booleanMethods.hasUniqueDigit());
        System.out.println(booleanMethods.isDigit());
        System.out.println(booleanMethods.hasEqualDigits());
        System.out.println(booleanMethods.hasMoreTry());
        System.out.println(booleanMethods.isEmptyLineOrSpaces());
        System.out.println(booleanMethods.isEvenNumber());
        System.out.println(booleanMethods.isValidPath());
        System.out.println(booleanMethods.isExist());
    }
}