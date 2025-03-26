import java.lang.String;
import java.util.Random;

public class RpsGameFormatting {
    // Игра Камень-Ножницы-Бумага
    public static void main(String[] args) throws InterruptedException {
        char rock = 'R';
        char scissors = 'S';
        char paper = 'P';
        
        Random randomNumner = new Random();
        int position = randomNumner.nextInt(1, 100);
        char sign = rock;
        String firstPlayerSigns = "";
        String secondPlayerSigns = "";
        String firstPlayerName = "HEL";
        String secondPlayerName = "WALLY";

        for (int i = 0; i < 2; i++) {
            String currentSign = "";

            for (int j = 0; j < 5; j++) {
                if (position > 66) {
                    sign = paper;
                } else if (position > 33) {
                    sign = scissors;
                }
                currentSign = currentSign + sign;
                position = randomNumner.nextInt(1, 100);
            }
            System.out.println();

            if (i == 0) {
                System.out.println("Ход " + firstPlayerName + ": ");
                firstPlayerSigns = currentSign;
                System.out.print(firstPlayerSigns);
            } else {
                System.out.println("Ход " + secondPlayerName + ": ");
                secondPlayerSigns = currentSign;
                System.out.print(secondPlayerSigns);
            }
        }
        System.out.println();

        int firstPlayerCount = 0;
        int secondtPlayerCount = 0;

        for (int i = 0; i < 5; i++) {
            char firstPlayerSign = firstPlayerSigns.charAt(i);
            char secondPlayerSign = secondPlayerSigns.charAt(i);

            boolean isFirstPlayerWinner = firstPlayerSign == rock &&
                    secondPlayerSign == scissors || firstPlayerSign == scissors &&
                    secondPlayerSign == paper || firstPlayerSign == paper &&
                     secondPlayerSign == rock;

            boolean isSecondPlayerWinner = secondPlayerSign == rock &&
                    firstPlayerSign == scissors || secondPlayerSign == scissors &&
                    firstPlayerSign == paper || secondPlayerSign == paper &&
                    firstPlayerSign == rock;

            if (isFirstPlayerWinner) {
                firstPlayerCount++;
            } else if (isSecondPlayerWinner) {
                secondtPlayerCount++;
            }
        }

        if (firstPlayerCount > secondtPlayerCount) {
            System.out.println("Победил " + firstPlayerName);
        } else if (firstPlayerCount < secondtPlayerCount) {
            System.out.println("Победил " + secondPlayerName);
        } else {
            System.out.println("Победила дружба");
        }
    }
}