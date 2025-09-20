import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int secretNumber;
    private Scanner console = new Scanner(System.in);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame() {
        secretNumber = new Random().nextInt(101); 
        System.out.println("Компьютер загадал число от 0 до 100. Попробуйте угадать!");

        boolean isGameOn = false;

        while (!isGameOn) {
            // Ход первого игрока
            System.out.print("Ход " + player1.getName() + ": ");
            int player1Move = console.nextInt();
            isGameOn = checkNumber(player1Move, player1, player2);
            if (isGameOn) break;

            // Ход второго игрока
            System.out.print("Ход " + player2.getName() + ": ");
            int player2Move = console.nextInt();
            isGameOn = checkNumber(player2Move, player2, player1);
        }
    }

    private boolean checkNumber(int playerNumber, Player currentPlayer, Player nextPlayer) {
        if (secretNumber < playerNumber) {
            System.out.println(playerNumber + " больше того, что загадал компьютер");
            System.out.println("Ход переходит к игроку " + nextPlayer.getName());
            return false;
        } else if (secretNumber > playerNumber) {
            System.out.println(playerNumber + " меньше того, что загадал компьютер");
            System.out.println("Ход переходит к игроку " + nextPlayer.getName());
            return false;
        } else {
            System.out.println(playerNumber + " = " + secretNumber);
            System.out.println("Победил " + currentPlayer.getName() + "!");
            return true;
        }
    }
}