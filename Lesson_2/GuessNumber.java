import java.util.Random;

public class GuessNumber {
    Random random = new Random();

    public int generateSecretNumber() {
        return random.nextInt(0, 101);
    } 

    public boolean guessNumber(int secretNumber, int playerNumber, Player currentPlayer, Player nextPlayer) {
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
        
