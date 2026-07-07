package com.startjava.lesson_2_3_4.bookcase;

public enum MenuItem {
    ADD_BOOK("Добавить книгу"),
    FIND_BOOK("Найти книгу"),
    DELETE_BOOK("Удалить книгу"),
    CLEAR_BOOKCASE("Очистить весь книжный шкаф"),
    EXIT("Выйти из книжного шкафа");

    final String action;

    MenuItem(String action) {
        this.action = action;
    }

    public static void validateMenuNumber(MenuItem[] menu, int selectedNumber) {
        int firstMenuItem = 1;
        int lastMenuItem = menu.length;

        if (selectedNumber < firstMenuItem || selectedNumber > lastMenuItem) {
            throw new IllegalArgumentException(
                    "неверное значение меню (%d). Допустимые значения [%d - %d]: "
                            .formatted(selectedNumber, firstMenuItem, lastMenuItem));
        }
    }
}
