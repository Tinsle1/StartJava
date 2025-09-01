import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNum = random.nextInt(0, 101);
        int inputNum;

        do {
            inputNum = random.nextInt(0, 101);
            System.out.println("Введите число: " + inputNum);
            
            if (inputNum < secretNum) {
                System.out.println(inputNum + " меньше того, что загадал компьютер");
            } else if (inputNum > secretNum) {
                System.out.println(inputNum + " больше того, что загадал компьютер");
            }
        } while (inputNum != secretNum);
        System.out.println("Вы победили!");
    }
}


