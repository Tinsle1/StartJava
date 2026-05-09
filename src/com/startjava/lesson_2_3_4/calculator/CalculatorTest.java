package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                Calculator calculator = new Calculator();
                calculator.calc();
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = console.next().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
                answer = console.next().toLowerCase();
            }
        } while (!answer.equals("no"));
    }
}