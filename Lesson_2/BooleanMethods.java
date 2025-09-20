public class BooleanMethods {
    MethodName methodName = new MethodName();
    
    public Boolean shouldProgramEnd() {
        System.out.print(methodName.getCurrent() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public Boolean hasUniqueDigit() {
        System.out.print(methodName.getCurrent() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public Boolean isDigit() {
        System.out.print(methodName.getCurrent() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public Boolean hasEqualDigits() {
        System.out.print(methodName.getCurrent() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public Boolean hasMoreTry() {
        System.out.print(methodName.getCurrent() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public Boolean isEmptyLineOrSpaces() {
        System.out.print(methodName.getCurrent() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public Boolean isEvenNumber() {
        System.out.print(methodName.getCurrent() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public Boolean isValidPath() {
        System.out.print(methodName.getCurrent() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public Boolean isExist() {
        System.out.print(methodName.getCurrent() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}