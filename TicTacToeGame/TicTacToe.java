import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3]; // 3x3 game board
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Tic-Tac-Toe Game!");

        // Loop for multiple rounds
        boolean playAgain = true;
        while (playAgain) {
            initializeBoard(); // Reset the board for each new round
            playGame(); // Play a single round of Tic-Tac-Toe

            // Ask if players want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }

    // Initialize or reset the game board
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // Empty space
            }
        }
    }

    // Play a single round of Tic-Tac-Toe
    private static void playGame() {
        char currentPlayer = 'X'; // Start with Player X
        boolean gameWon = false;

        for (int move = 1; move <= 9; move++) { // Maximum 9 moves
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");
            int row, col;

            while (true) {
                // Get the player's move
                System.out.print("Enter row (1-3): ");
                row = scanner.nextInt() - 1; // Convert to 0-based index
                System.out.print("Enter column (1-3): ");
                col = scanner.nextInt() - 1;

                // Check if the move is valid
                if (isValidMove(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid move! The cell is already occupied or out of bounds. Try again.");
                }
            }

            // Place the player's mark
            board[row][col] = currentPlayer;

            // Check for a win
            if (isWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        if (!gameWon) {
            printBoard();
            System.out.println("It's a draw!");
        }
    }

    // Display the current game board
    private static void printBoard() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.println(" -----------");
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println(" -----------");
    }

    // Check if a move is valid
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Check if the current player has won
    private static boolean isWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Main diagonal
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);   // Anti-diagonal
    }
}
