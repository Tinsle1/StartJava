package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.AlreadyExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookNotFoundException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseFullException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyAuthorException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyTitleException;
import com.startjava.lesson_2_3_4.bookcase.exception.EmptyYearException;
import com.startjava.lesson_2_3_4.bookcase.exception.InvalidYearException;
import com.startjava.lesson_2_3_4.util.AnsiColor;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookcaseTest {
    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final Bookcase bookcase = new Bookcase();

    public static void main(String[] args) throws InterruptedException {
        printWelcome();
        while (true) {
            printBookcaseStatus();
            printBookcase();
            MenuItem[] menu = createAvailableMenu();
            printMenu(menu);

            MenuItem action = findAction(menu);
            boolean shouldExit = processAction(action);

            if (shouldExit) {
                break;
            }
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

    private static void printBookcaseStatus() {
        if (bookcase.getBooksCount() == 0) {
            System.out.println("Сейчас шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }

        if (bookcase.getBooksCount() == Bookcase.CAPACITY) {
            System.out.println("Книжный шкаф заполнен.\n");
            return;
        }

        System.out.printf("В шкафу книг - %d, свободно полок - %d%n%n", bookcase.getBooksCount(),
                bookcase.countEmptyShelves());
    }

    private static void printBookcase() {
        if (bookcase.getBooksCount() == 0) {
            return;
        }

        for (Book book : bookcase.getBooks()) {
            int diff = bookcase.getBookcaseLength() - book.toString().length();
            System.out.printf("|%s", book);
            System.out.println(" ".repeat(diff) + "|");
            System.out.println("|" + "-".repeat(bookcase.getBookcaseLength()) + "|");
        }
    }

    private static MenuItem[] createAvailableMenu() {
        if (bookcase.isEmpty()) {
            return new MenuItem[]{
                    MenuItem.ADD_BOOK,
                    MenuItem.EXIT
            };
        }

        if (bookcase.isFull()) {
            return new MenuItem[]{
                    MenuItem.FIND_BOOK,
                    MenuItem.DELETE_BOOK,
                    MenuItem.CLEAR_BOOKCASE,
                    MenuItem.EXIT
            };
        }

        return MenuItem.values();
    }

    private static void printMenu(MenuItem[] menu) {
        System.out.println("\n========= МЕНЮ =========");

        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menu[i].action);
        }
    }

    private static MenuItem findAction(MenuItem[] menu) {
        System.out.print("\nВведите номер нужного действия из меню: ");
        int actionNumber;

        while (true) {
            try {
                actionNumber = CONSOLE.nextInt();
                CONSOLE.nextLine();
                MenuItem.validateMenuNumber(menu.length, actionNumber);
                break;
            } catch (InputMismatchException e) {
                System.out.printf(AnsiColor.YELLOW + "Введенное значение должно быть числом: " +
                        AnsiColor.RESET);
                CONSOLE.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            }
        }
        return menu[actionNumber - 1];
    }

    private static boolean processAction(MenuItem action) {
        boolean shouldExit = false;
        switch (action) {
            case ADD_BOOK -> addBook();
            case FIND_BOOK -> findBook();
            case DELETE_BOOK -> removeBook();
            case CLEAR_BOOKCASE -> clearBookcase();
            case EXIT -> shouldExit = true;
        }
        if (!shouldExit) {
            System.out.println("\nОперация выполнена. Нажмите Enter для продолжения...");
            CONSOLE.nextLine();
        }
        return shouldExit;
    }

    private static void addBook() {
        try {
            bookcase.addBook(createBook());

            System.out.printf("%nКнига %s добавлена в шкаф%n",
                    bookcase.getBooks()[bookcase.getBooksCount() - 1]);
        } catch (BookcaseFullException | AlreadyExistException e) {
            System.out.println(AnsiColor.YELLOW + e.getMessage() + AnsiColor.RESET);
        }
    }

    private static Book createBook() {
        String title = readTitle();
        String author = readAuthor();
        Year publishedYear = readYear();
        return new Book(title, author, publishedYear);
    }

    private static String readTitle() {
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

    private static String readAuthor() {
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

    private static Year readYear() {
        System.out.print("Введите год издания книги: ");
        while (true) {
            try {
                String input = CONSOLE.nextLine().trim();

                if (input.isBlank()) {
                    throw new EmptyYearException("Год не может быть пустым: ");
                }

                Year year = Year.parse(input);

                if (year.isBefore(Book.MIN_PUBLISHED_YEAR) || year.isAfter(Book.maxPublishedYear)) {
                    throw new InvalidYearException("Год издания должен быть между %d и %d: "
                            .formatted(Book.MIN_PUBLISHED_YEAR.getValue(),
                                    Book.maxPublishedYear.getValue()));
                }
                return year;
            } catch (EmptyYearException | InvalidYearException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! " + e.getMessage() + AnsiColor.RESET);
            } catch (DateTimeParseException e) {
                System.out.print(AnsiColor.YELLOW + "Ошибка! Год должен быть числом: " + AnsiColor.RESET);
            }
        }
    }

    private static void findBook() {
        try {
            Book[] foundBooks = bookcase.findBooks(readTitle());
            System.out.printf("%nНайдены книги:%n");
            for (int i = 0; i < foundBooks.length; i++) {
                System.out.println(i + 1 + "." + foundBooks[i]);
            }
        } catch (BookNotFoundException e) {
            System.out.println(AnsiColor.YELLOW + e.getMessage() + AnsiColor.RESET);
        }
    }

    private static void removeBook() {
        try {
            Book[] booksToRemove = bookcase.findBooks(readTitle());
            System.out.printf("%nНайдены книги:%n");

            for (int i = 0; i < booksToRemove.length; i++) {
                System.out.println(i + 1 + "." + booksToRemove[i]);
            }

            Book bookToRemove = booksToRemove[0];

            String answer = "yes";
            do {
                if (answer.equals("yes")) {
                    System.out.print("\nВы действительно хотите удалить книгу/и? [yes/no]:");
                } else {
                    System.out.print("Введите корректный ответ [yes / no]: ");
                }
                answer = CONSOLE.nextLine().trim().toLowerCase();

                if (answer.equals("yes")) {
                    break;
                }
            } while (!answer.equals("no"));

            bookcase.removeBook(bookToRemove.getTitle());
            System.out.printf("Удалено книг: %d", booksToRemove.length);
        } catch (BookNotFoundException e) {
            System.out.println(AnsiColor.YELLOW + e.getMessage() + AnsiColor.RESET);
        }
    }

    private static void clearBookcase() {
        bookcase.clear();
        System.out.println("Книжный шкаф пуст");
    }
}
