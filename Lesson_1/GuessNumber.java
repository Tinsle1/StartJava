import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int secretNum = 38;
        Scanner console = new Scanner(System.in);
        int inputNum;
        do {
            System.out.println("Введите число: ");
            inputNum = console.nextInt();
            if (inputNum < secretNum) {
                System.out.println(inputNum + " меньше того, что загадал компьютер");
            } else if (inputNum > secretNum) {
                System.out.println(inputNum + " больше того, что загадал компьютер");
            }
        } while (inputNum != secretNum);
        System.out.println("Вы победили!");
    }
}


