package com.startjava.lesson_2_3_4.bookcase;

public class Menu {
    public enum Item {
        ADD_BOOK("Добавить книгу"),
        FIND_BOOK("Найти книгу"),
        DELETE_BOOK("Удалить книгу"),
        CLEAR_BOOKCASE("Очистить весь книжный шкаф"),
        EXIT("Выйти из книжного шкафа");

        final String action;

        Item(String action) {
            this.action = action;
        }
    }

    public enum Number {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5);

        final int menuNumber;

        Number(int menuNumber) {
            this.menuNumber = menuNumber;
        }

        public static void validateMenuNumber(Item[] menu, int selectedNumber) {
            int firstMenuItem = 1;
            int lastMenuItem = menu.length;

            if (selectedNumber < firstMenuItem || selectedNumber > lastMenuItem) {
                throw new IllegalArgumentException(
                        "неверное значение меню (%d). Допустимые значения [%d - %d]: "
                                .formatted(selectedNumber, firstMenuItem, lastMenuItem));
            }
        }
    }
}
