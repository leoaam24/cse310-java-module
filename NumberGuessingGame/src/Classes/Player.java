package Classes;

/**
 * Player class represents a game player with basic information.
 * Stores the player's name and number of tries made during the game.
 * This class serves as a base class for PlayerScore.
 */
public class Player {
    
    // Player's name
    protected String name;
    
    // Number of attempts made by the player
    protected int tries;

    /**
     * Constructor to create a player with a specified name.
     * 
     * @param name The name of the player
     */
    public Player(String name){
            this.name = name;
    }

    /**
     * Default constructor for Player.
     */
    public Player(){
        
    }
    
    /**
     * Gets the player's name.
     * 
     * @return The name of the player
     */
    public String getPlayerName(){
        return this.name;
    }
 
    
}
