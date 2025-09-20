public class NonBooleanMethods {
    MethodName methodName = new MethodName();

    public String findLongestWord() {
        System.out.println(methodName.getCurrent() +
                "() -> найти самое длинное слово в предложении из книги по Java");
        return "программирование";
    }

    public void getMenuItem() {
        System.out.println(methodName.getCurrent() +
                "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }

    public double calculateAverageGrade() {
        System.out.println(methodName.getCurrent() +
                "() -> вычислить среднее значение оценок в школе №1234");
        return 4.9;
    }

    public int countUniqueWords() {
        System.out.println(methodName.getCurrent() +
                "() -> подсчитать количество уникальных слов в \"Война и Мир\"");
        return 8964;
    }

    public void printError() {
        System.out.println(methodName.getCurrent() +
                "() -> вывести сообщение об ошибке");
    }

    public void syncWithCloud() {
        System.out.println(methodName.getCurrent() +
                "() -> синхронизировать данные с облачным хранилищем");
    }

    public void restoreBackup() {
        System.out.println(methodName.getCurrent() +
                "() -> восстановить данные из резервной копии от 11.03.2024");
    }

    public void pauseLoading() {
        System.out.println(methodName.getCurrent() +
                "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }

    public void resetToFactorySettings() {
        System.out.println(methodName.getMethodName() +
                "() -> сбросить настройки до заводских для пылесоса Mi");
    }

    public void saveFileToUsb() {
        System.out.println(methodName.getMethodName() +
                "() -> записать содержимое в файл по указанному пути на флешку");
    }

    public double celsiusToFahrenheit() {
        System.out.println(methodName.getMethodName() +
                "() -> преобразовать температуру из Цельсия в Фаренгейт");
        return 72.0;
    }

    public String printMathExpresion() {
        System.out.println(methodName.getMethodName() +
                "() -> ввести математическое выражение с тремя аргументами");
        return "4 * 49";
    }

    public String findWinner() {
        System.out.println(methodName.getMethodName() +
                "() -> выявить победителя среди гонщиков игры \"Need For Speed\"");
        return "Екатерина";
    }

    public String findBooksByAuthor() {
        System.out.println(methodName.getMethodName() +
                "() -> найти книгу по имени писателя");
        return "Белые ночи";
    }
}


