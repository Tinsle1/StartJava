public class BooleanMethods {
    MethodGetter methodGetter = new MethodGetter();
    
    public Boolean shouldProgramEnd() {
        System.out.println(methodGetter.getMethodName() +
                "() -> программа выполняется далее или завершается?");
        return true;
    }

    public Boolean hasUniqueDigit() {
        System.out.println(methodGetter.getMethodName() +
                "() -> последовательность содержит уникальную цифру?");
        return false;
    }

    public Boolean isDigit() {
        System.out.println(methodGetter.getMethodName() +
                "() -> пользователь ввел букву или что-то другое?");
        return true;
    }

    public Boolean hasEqualDigits() {
        System.out.println(methodGetter.getMethodName() +
                "() -> в проверяемых числах, есть равные цифры?");
        return false;
    }

    public Boolean hasMoreTry() {
        System.out.println(methodGetter.getMethodName() +
                "() -> в игре \"Марио\" остались попытки?");
        return true;
    }

    public Boolean isEmptyLineOrSpaces() {
        System.out.println(methodGetter.getMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов?");
        return false;
    }

    public Boolean isEvenNumber() {
        System.out.println(methodGetter.getMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число?");
        return true;
    }

    public Boolean isValidPath() {
        System.out.println(methodGetter.getMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный?");
        return false;
    }

    public Boolean isExist() {
        System.out.println(methodGetter.getMethodName() +
                "() -> файл по указанному адресу существует?");
        return true;
    }
}