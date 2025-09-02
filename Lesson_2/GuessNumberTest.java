import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        GuessNumber guessNumber = new GuessNumber();
        String userAnswer = "yes";

        System.out.print("Имя первого игрока: ");
        Player player1 = new Player(console.nextLine());
        System.out.print("Имя второго игрока: ");
        Player player2 = new Player(console.nextLine());
        int secretNumber = guessNumber.generateSecretNumber();
        System.out.println("Отгадайте число от 0 до 100");

        boolean isGameOn = false;
        while (!isGameOn) {
            System.out.print("Ход " + player1.getName() + ": ");
            int player1Move = console.nextInt();
            isGameOn = guessNumber.guessNumber(secretNumber, player1Move, player1, player2);
            if (isGameOn) break;

            System.out.print("Ход " + player2.getName() + ": ");
            int player2Move = console.nextInt();
            isGameOn = guessNumber.guessNumber(secretNumber, player2Move, player2, player1);
        }
    }
}
    

