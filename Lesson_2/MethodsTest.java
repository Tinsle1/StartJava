public class MethodsTest {
    public static void main(String[] args) {
        MethodsTest methodsTest = new MethodsTest();
        methodsTest.getNotBooleanMethods();
        methodsTest.getBooleanMethods();
    }

    public void getNotBooleanMethods() {
        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        NotBooleanMethods notBooleanMethods = new NotBooleanMethods();

        notBooleanMethods.findLongestWord();
        notBooleanMethods.getMenuItem();
        notBooleanMethods.calculateAverageGrade();
        notBooleanMethods.countUniqueWords();
        notBooleanMethods.printError();
        notBooleanMethods.syncWithCloud();
        notBooleanMethods.restoreBackup();
        notBooleanMethods.pauseLoading();
        notBooleanMethods.resetToFactorySettings();
        notBooleanMethods.saveFileToUsb();
        notBooleanMethods.celsiusToFahrenheit();
        notBooleanMethods.printMathExpresion();
        notBooleanMethods.findWinner();
        notBooleanMethods.findBooksByAuthor();
    }

    public void getBooleanMethods() {
        System.out.println("\n\nBOOLEAN-МЕТОДЫ");
        BooleanMethods booleanMethods = new BooleanMethods();

        booleanMethods.shouldProgramEnd();
        booleanMethods.hasUniqueDigit();
        booleanMethods.isDigit();
        booleanMethods.hasEqualDigits();
        booleanMethods.hasMoreTry();
        booleanMethods.isEmptyLineOrSpaces();
        booleanMethods.isEvenNumber();
        booleanMethods.isValidPath();
        booleanMethods.isExist();
    }
}