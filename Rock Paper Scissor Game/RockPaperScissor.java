import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] options = { "Rock", "Paper", "Scissors" };

        System.out.println("Welcome to Rock, Paper, Scissors Game!");

        int playerWins = 0;
        int computerWins = 0;
        int rounds = 5;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            System.out.println("Choose your option:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Enter your choice (1-3): ");

            int userChoice = sc.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
                round--; // Don't count this round
                continue;
            }

            // Computer's choice
            int comPlayer = random.nextInt(3); // Generates 0, 1, or 2
            System.out.println("You chose: " + options[userChoice - 1]);
            System.out.println("Computer chose: " + options[comPlayer]);

            // Determine winner for the round
            if (userChoice - 1 == comPlayer) {
                System.out.println("It's a tie!");
            } else if ((userChoice - 1 == 0 && comPlayer == 2) ||
                       (userChoice - 1 == 1 && comPlayer == 0) ||
                       (userChoice - 1 == 2 && comPlayer == 1)) {
                System.out.println("You win this round!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }
        }

        // Decide overall winner after 5 rounds
        System.out.println("\n--- Game Over ---");
        System.out.println("Final Score:");
        System.out.println("You: " + playerWins);
        System.out.println("Computer: " + computerWins);

        if (playerWins > computerWins) {
            System.out.println("Congratulations! You are the Winner!");
        } else if (computerWins > playerWins) {
            System.out.println("Computer wins the game. Better luck next time!");
        } else {
            System.out.println("It's an overall tie!");
        }

        sc.close();
    }
}
