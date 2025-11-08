package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * LeaderBoards class manages the game's leaderboard functionality.
 * Extends PlayerScore to access player records and provides methods to:
 * - Save player scores to a persistent file
 * - Load and display existing leaderboard data
 */
public class LeaderBoards extends PlayerScore {
    
    /**
     * Default constructor for LeaderBoards.
     */
    public LeaderBoards(){

    }

    /**
     * Saves all player records to the scoreboard.txt file.
     * Each record is stored in the format: "PlayerName|Score"
     * Overwrites the existing file with current player records.
     */
    public static void saveRecord() {
        try {
            // Create/overwrite the scoreboard file
            FileWriter writer = new FileWriter("scoreboard.txt");
            
            // Write each player's name and score on a separate line
            for (java.util.Map.Entry<String, Float> entry : playerRecord.entrySet()) {
                writer.write(entry.getKey() + "|" + entry.getValue() + "\n");
            }
            writer.close();
            System.out.println("Score saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the scoreboard file exists and displays its contents.
     * If the file exists, reads and displays all player records.
     * If the file doesn't exist, displays a message indicating no leaderboard yet.
     */
    public static void fileCheck() {
        File file = new File("scoreboard.txt");

        // Check if scoreboard file exists
        if (file.exists()){
            try {
                // Read and display all records from the file
                BufferedReader reader = new BufferedReader(new FileReader("scoreboard.txt"));
                String line;
                System.out.println("\n=== LEADERBOARD ===");
                
                // Parse each line and display player name and score
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        System.out.println("Name: " + parts[0] + " | Score: " + parts[1]);
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            };
        } else {
            // No scoreboard file exists yet
            System.out.println("No Leader Boards Yet");
        }
    }
}
