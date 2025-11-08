package Classes;

import java.util.HashMap;

/**
 * PlayerScore class extends Player to manage player scoring functionality.
 * Calculates player scores based on the game difficulty (largest number) and performance (tries).
 * Maintains a static HashMap to store all player records across game sessions.
 * 
 * Score calculation: score = largestNumber / numberOfTries
 * Higher scores indicate better performance (fewer tries for a larger range).
 */
public class PlayerScore extends Player {
    // Individual player's calculated score
    private float score;

    // Static HashMap to store all player records (name -> score)
    protected static HashMap<String, Float> playerRecord = new HashMap<>();
        
    /**
     * Constructor to create a PlayerScore with calculated score.
     * Score is calculated by dividing the largest number by the number of tries.
     * 
     * @param largestNumber The upper bound of the guessing range (difficulty factor)
     * @param tries The number of attempts the player made
     */
    public PlayerScore(int largestNumber, int tries) {
            this.tries = tries;
            // Calculate score: higher range and fewer tries = higher score
            this.score = (float)(largestNumber) / this.tries;
        }

    /**
     * Default constructor for PlayerScore.
     */
    public PlayerScore(){

    }

    /**
     * Gets the calculated score for this player.
     * 
     * @return The player's score as a float
     */
    public float getPlayerScore(){
        return this.score;
    }

    /**
     * Adds or updates a player's record in the static playerRecord HashMap.
     * 
     * @param name The player's name
     * @param score The player's calculated score
     */
    public void setPlayerRecord(String name, float score){
        playerRecord.put(name, score);
    }

    /**
     * Gets all player records as a string representation.
     * 
     * @return String representation of the playerRecord HashMap
     */
    public static String getPlayerRecord(){
       return playerRecord.toString();
    }
    
}
