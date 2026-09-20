
import java.util.Random;
import java.util.Scanner;

class Main {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] table = new String[5][4];

        for (int i = 0; i < 5; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();

            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            table[i][0] = String.valueOf(i + 1);
            table[i][1] = playerMove;
            table[i][2] = computerMove;
            table[i][3] = result;

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        System.out.println("---------- Final Summary ----------");
        System.out.printf("%-8s %-15s %-15s %-18s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-8s %-15s %-15s %-18s%n",
                    table[i][0], table[i][1], table[i][2], table[i][3]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println();
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");

        sc.close();
    }
}
