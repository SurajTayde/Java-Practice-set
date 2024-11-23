import java.util.Scanner; // Import the Scanner class
import java.util.Random; // Import the Random class

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        Random random = new Random(); // Create a Random object

        // Generate a random number between 1 and 99
        int randomNum = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Can you guess what it is?");

        // Game loop
        while (guess != randomNum) {
            System.out.print("Enter your guess:  ");
            guess = sc.nextInt();
            attempts++;

            if (guess < randomNum) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNum) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
            }
        }

        sc.close(); // Close the Scanner object
    }
}
