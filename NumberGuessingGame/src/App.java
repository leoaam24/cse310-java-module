import java.util.Scanner;

import Classes.LeaderBoards;
import Classes.Player;
import Classes.PlayerScore;
import Classes.Validation;
import Classes.WinningCondition;

/**
 * Main application class for the Number Guessing Game.
 * This game allows players to guess a randomly generated number within a specified range,
 * tracks their attempts, calculates scores, and maintains a leaderboard.
 */
public class App {
    /**
     * Main entry point for the Number Guessing Game application.
     * Handles the game flow including:
     * - Player registration
     * - Range configuration
     * - Guess validation and feedback
     * - Score calculation and leaderboard updates
     * - Replay functionality
     */
    public static void main(String[] args) throws Exception {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        String answer;
        WinningCondition win;
        Player newPlayer = null;
       
        // Variables to store the guessing range
        int smallestNumber = 0;
        int largestNumber = 0;

        // Main game loop - allows replaying the game
        while (true) {
            // Display welcome message and game instructions
            System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("The mechanics is easy. You just have to guess the number from the parameters you've set. I'll tell you when you're close or your far from the number.");
        
        // Check and display existing leaderboard if available
        LeaderBoards.fileCheck();

        // Prompt user to start the game
        while(true){
            System.out.print("\nAre you ready? (yes/no) ");
           
            answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                break;
            } else if (answer.equalsIgnoreCase("no")){
               System.exit(0);
            } else {
                 System.out.println("\nPlease just answer either yes or no.");
            }
        }

        // Get player name and create player object
        System.out.println("\nGreat! Let's start.");
        System.out.print("Please type your name: ");
        String playerName = scanner.next();
        newPlayer = new Player(playerName);

        // Get the smallest number for the guessing range (must be greater than 0)
        while(true){
            try {
                System.out.println("What the smallest number you want the guess starts? ");
                String input = scanner.next();
                // Validate and parse user input
                Object parsed = Validation.parseUnknownInput(input);
                if (parsed instanceof Integer){
                    smallestNumber = (Integer) parsed;
                }
                if (smallestNumber > 0) {
                break;
            } else {
                System.out.println("Please choose a number greater than 0.");
            }
            } catch (Exception e) {
                System.out.println("It seems you're trying to enter something different than a number please try again");
            }
            
        }

        // Get the largest number for the guessing range (must be greater than smallest number)
        while(true){
            System.out.println("What the largest number you want the guess starts? ");
            String input = scanner.next();
            // Validate and parse user input
            Object parsed = Validation.parseUnknownInput(input);
            if (parsed instanceof Integer){
                    largestNumber = (Integer) parsed;
                }
            // Ensure largest number is greater than smallest number
            if (largestNumber != smallestNumber && largestNumber > smallestNumber) {
                // Initialize winning condition with the specified range
                win = new WinningCondition(smallestNumber, largestNumber);
                break;
            } else {
                System.out.println("Please choose a number greater not equal to the starting number");
            }
        }

        
        // Start the guessing phase
        System.out.println("Number is set start guessing now!");
        System.out.print("Please enter your number: ");
        int guessNumber = scanner.nextInt();
        int triesMade;
        
        // Main guessing loop - continues until player guesses correctly
        while(true) {
            // Track number of attempts made
            triesMade = win.checkTries();
            
            // Check if the guess is correct
            if (win.checkGuess(guessNumber)){
                // Player guessed correctly - calculate and save score
                String currentPlayer = newPlayer.getPlayerName();
                PlayerScore gameScore = new PlayerScore(largestNumber, triesMade);

                float playerScore = gameScore.getPlayerScore();

                // Save player's score to the record
                gameScore.setPlayerRecord(currentPlayer, playerScore);

                // Persist the leaderboard to file
                LeaderBoards.saveRecord();

                // Display success message and player statistics
                System.out.println("Great job! " + currentPlayer);
                System.out.println("you got the number!");
                System.out.println("Tries: " + triesMade);
                System.out.println("Player Score: "+ playerScore);
                
                break;
            } else {
                // Provide feedback to help player narrow down their guess
                if (win.checkWinningNumber() > guessNumber) {
                    System.out.println("Your guess is less than the right answer.");
                } else {
                    System.out.println("Your guess is higher than the right answer.");
                }
                // Prompt for next guess
                System.out.print("Please enter your number: ");
                guessNumber = scanner.nextInt();
            }
        }

        // Ask if player wants to play again
        while (true){
            String playAgain = "no";
            System.out.println("Do you want to play again?");
            playAgain = scanner.next().trim();
            if (playAgain.equalsIgnoreCase("yes")) {
                // Restart the game loop
                break;
            } else if(playAgain.equalsIgnoreCase("no")) {
                // Exit the application
                System.exit(0);
            } else {
                System.out.println("Please enter either yes or no.");
            }
        }

        } // End of main game loop
    } // End of main method
} // End of App class
