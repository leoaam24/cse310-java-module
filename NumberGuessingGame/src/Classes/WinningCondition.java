package Classes;

/**
 * WinningCondition class manages the game logic for the number guessing game.
 * Generates a random winning number within a specified range and tracks:
 * - The secret winning number
 * - Whether the player has won
 * - The number of attempts made
 */
public class WinningCondition {

    // The randomly generated number that the player needs to guess
    private int winningNumber;
    
    // Flag indicating whether the player has guessed correctly
    private boolean win;
    
    // Counter for the number of attempts made (starts at 1)
    private int tries = 1;

    /**
     * Constructor that initializes the game with a random winning number.
     * Generates a random number within the inclusive range [smallRange, largeRange].
     * 
     * @param smallRange The minimum value for the random number (inclusive)
     * @param largeRange The maximum value for the random number (inclusive)
     */
    public WinningCondition(int smallRange, int largeRange){
        // Generate random number: Math.random() * (max - min + 1) + min
        this.winningNumber = (int)(Math.random() * (largeRange - smallRange + 1)) + smallRange;
    }

    /**
     * Checks if the player's guess matches the winning number.
     * Increments the tries counter if the guess is incorrect.
     * 
     * @param guessNumber The number guessed by the player
     * @return true if the guess is correct, false otherwise
     */
    public boolean checkGuess(int guessNumber){
        if (this.winningNumber == guessNumber){
           // Player guessed correctly
           this.win = true;
        } else {
            // Incorrect guess - increment try counter
            this.tries += 1;
            this.win = false;
        }

        return this.win;
    }

    /**
     * Gets the winning number (used for providing hints to the player).
     * 
     * @return The secret winning number
     */
    public int checkWinningNumber(){
        return this.winningNumber;
    }

    /**
     * Gets the current number of attempts made by the player.
     * 
     * @return The number of tries
     */
    public int checkTries(){
        return this.tries;
    }

      
}
