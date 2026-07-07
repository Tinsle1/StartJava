package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.InvalidMenuNumberException;

public enum MenuItem {
    ADD_BOOK("Добавить книгу"),
    FIND_BOOK("Найти книгу"),
    DELETE_BOOK("Удалить книгу"),
    CLEAR_BOOKCASE("Очистить весь книжный шкаф"),
    EXIT("Выйти из книжного шкафа");

    private static final int FIRST_MENU_ITEM = 1;

    final String action;

    MenuItem(String action) {
        this.action = action;
    }

    public static void validateMenuNumber(int menuItemsCount, int selectedNumber) {
        if (selectedNumber < FIRST_MENU_ITEM || selectedNumber > menuItemsCount) {
            throw new InvalidMenuNumberException(
                    "неверное значение меню (%d). Допустимые значения [%d - %d]: "
                            .formatted(selectedNumber, FIRST_MENU_ITEM, menuItemsCount));
        }
    }
}
