package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.AlreadyExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookNotFoundException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseFullException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyAuthorException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyTitleException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyYearException;
import com.startjava.lesson_2_3_4.bookcase.exception.InvalidYearException;
import com.startjava.lesson_2_3_4.guess.AnsiColor;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookCaseTest {
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        printWelcome();
        while (true) {
            printBookshelfStatus();
            printBookshelf();
            String[] menu = getAvailableMenu();
            printMenu(menu);

            int selectedMenuNumber = getMenuNumber(menu);
            String selectedMenuItem = getSelectedMenuItem(selectedMenuNumber, menu);
            MenuItems action = findAction(selectedMenuItem);
            boolean shouldExit = processAction(action);

            if (shouldExit) {
                break;
            }
        }
    }

    enum MenuItems {
        ADD_BOOK("Добавить книгу"),
        FIND_BOOK("Найти книгу"),
        DELETE_BOOK("Удалить книгу"),
        CLEAR_BOOKCASE("Очистить весь книжный шкаф"),
        EXIT("Выйти из книжного шкафа");

        private final String action;

        MenuItems(String action) {
            this.action = action;
        }
    }

    private static void printWelcome() throws InterruptedException {
        String welcomeText = "ДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ";

        for (int i = 0; i < welcomeText.length(); i++) {
            System.out.print(welcomeText.charAt(i));
            Thread.sleep(80);
        }
        System.out.println();
    }

    private static void printBookshelfStatus() {
        if (Bookcase.getBooksCount() == 0) {
            System.out.println("Сейчас шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }

        if (Bookcase.getBooksCount() == Bookcase.CAPACITY) {
            System.out.println("Книжный шкаф заполнен.");
            return;
        }

        System.out.printf("В шкафу книг - %d, свободно полок - %d%n", Bookcase.getBooksCount(),
                Bookcase.countEmptyShelves());
    }

    private static void printBookshelf() {
        if (Bookcase.getBooksCount() == 0) {
            return;
        }
        Book[] books = Bookcase.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // выводим меню
    private static void printMenu(String[] menu) {
        System.out.println("\n========= МЕНЮ =========");

        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menu[i]);
        }
    }

    // получаем доступное на данный момемент меню
    private static String[] getAvailableMenu() {
        if (Bookcase.getBooksCount() == 0) {
            return new String[]{
                    MenuItems.ADD_BOOK.action,
                    MenuItems.EXIT.action
            };
        }

        if (Bookcase.getBooksCount() == Bookcase.CAPACITY) {
            return new String[]{
                    MenuItems.FIND_BOOK.action,
                    MenuItems.DELETE_BOOK.action,
                    MenuItems.CLEAR_BOOKCASE.action,
                    MenuItems.EXIT.action
            };
        }

        MenuItems[] actions = MenuItems.values();
        String[] menu = new String[actions.length];

        for (int i = 0; i < actions.length; i++) {
            menu[i] = actions[i].action;
        }
        return menu;
    }

    // получаем пункт текущего меню от пользователя
    private static int getMenuNumber(String[] menu) {
        System.out.print("\nВведите номер нужного действия из меню: ");
        int firstMenuItem = 1;
        int lastMenuItem = menu.length;
        while (true) {
            try {
                int actionNumber = CONSOLE.nextInt();
                CONSOLE.nextLine();

                if (actionNumber < firstMenuItem || actionNumber > lastMenuItem) {
                    throw new IllegalArgumentException(
                            "неверное значение меню (%d). Допустимые значения [%d - %d]: "
                                    .formatted(actionNumber, firstMenuItem, lastMenuItem));
                }

                return actionNumber;
            } catch (InputMismatchException e) {
                System.out.printf(AnsiColor.YELLOW + "Введенное значение должно быть числом: " +
                        AnsiColor.RESET);
                CONSOLE.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            }
        }
    }

    // извлекаем строку, соответствующую пункту текущего меню
    private static String getSelectedMenuItem(int number, String[] menu) {
        return menu[number - 1];
    }

    // находим соответствующее выбранному пункту константу enum
    private static MenuItems findAction(String menuItem) {
        for (MenuItems action : MenuItems.values()) {
            if (action.action.equals(menuItem)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Неизвестный пункт меню: " + menuItem);
    }

    // выполняем соответствующее константе enum действие
    private static boolean processAction(MenuItems action) {
        boolean shouldExit = false;
        switch (action) {
            case ADD_BOOK -> addBook();
            case FIND_BOOK -> findBook();
            case DELETE_BOOK -> System.out.println("Удалить книгу");
            case CLEAR_BOOKCASE -> clearBookcase();
            case EXIT -> shouldExit = true;
            default -> System.out.println("Пункт не найден");
        }
        if (!shouldExit) {
            System.out.println("\nОперация выполнена. Нажмите Enter для продолжения...");
            CONSOLE.nextLine();
        }
        return shouldExit;
    }

    private static void addBook() {
        try {
            Bookcase.addBook(createBook());
        } catch (BookcaseFullException | AlreadyExistException e) {
            System.out.println(AnsiColor.YELLOW + e.getMessage() + AnsiColor.RESET);
        }
        System.out.printf("%nКнига «%s» добавлена в шкаф%n",
                Bookcase.getBooks()[Bookcase.getBooksCount() - 1]);
    }

    public static Book createBook() {
        String title = getTitle();
        String author = getAuthor();
        Year year = getYear();
        return new Book(title, author, year);
    }

    private static String getTitle() {
        System.out.print("Введите название книги: ");
        while (true) {
            try {
                String title = CONSOLE.nextLine().trim().replaceAll("\\s+", " ");
                if (title.isBlank()) {
                    throw new EmptyTitleException("Название не может быть пустым: ");
                }
                return title;
            } catch (EmptyTitleException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            }
        }
    }

    private static String getAuthor() {
        System.out.print("Введите имя автора: ");
        while (true) {
            try {
                String author = CONSOLE.nextLine().trim().replaceAll("\\s+", " ");
                if (author.isBlank()) {
                    throw new EmptyAuthorException("Имя не может быть пустым: ");
                }
                return author;
            } catch (EmptyAuthorException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            }
        }
    }

    private static Year getYear() {
        System.out.print("Введите год издания книги: ");
        while (true) {
            try {
                String input = CONSOLE.nextLine().trim();

                if (input.isBlank()) {
                    throw new EmptyYearException("Год не может быть пустым: ");
                }

                Year year = Year.parse(input);

                if (year.isBefore(Book.MIN_PUBLICATION_YEAR) || year.isAfter(Book.MAX_PUBLICATION_YEAR)) {
                    throw new InvalidYearException("Год издания должен быть между %d и %d: "
                            .formatted(Book.MIN_PUBLICATION_YEAR.getValue(),
                                    Book.MAX_PUBLICATION_YEAR.getValue()));
                }
                return year;
            } catch (EmptyYearException | InvalidYearException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            } catch (DateTimeParseException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! Год должен быть числом: " + AnsiColor.RESET);
            }
        }
    }

    public static void findBook() {
        try {
            Book book = Bookcase.findBook(getTitle());
            System.out.printf("Найдена книга: %s%n", book);
        } catch (BookNotFoundException e) {
            System.out.println(AnsiColor.YELLOW + e.getMessage() + AnsiColor.RESET);
        }
    }

    public static void clearBookcase() {
        Bookcase.clear();
        System.out.println("Книжный шкаф пуст");
    }
}
