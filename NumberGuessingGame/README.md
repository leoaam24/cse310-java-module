# Overview

This is a Number Guessing Game application where players try to guess a randomly generated number within a custom range. The game tracks attempts, calculates scores, and maintains a leaderboard.

[Software Demo Video](https://youtu.be/wG81GW81Ol4)

## Purpose

This project is an interactive console-based game that demonstrates object-oriented programming principles in Java. Players set their own difficulty by choosing the number range, and the game provides feedback to help narrow down guesses. Scores are calculated based on performance (fewer attempts = higher score) and saved to a persistent leaderboard.

## Running the Application

To run the Number Guessing Game:

1. Compile and run `src/App.java`
2. Follow the prompts to:
   - Enter your name
   - Set the smallest number for the range
   - Set the largest number for the range
   - Start guessing the number
3. The game will provide hints (higher/lower) until you guess correctly
4. Your score will be calculated and saved to the leaderboard
5. Choose to play again or exit

## Project Structure

- `src/`: Contains the Java source files
  - `App.java`: Main application file with game flow logic
  - `Classes/`: Package containing game classes
    - `Player.java`: Represents a player with name and tries
    - `PlayerScore.java`: Manages score calculation and player records
    - `WinningCondition.java`: Handles random number generation and guess validation
    - `LeaderBoards.java`: Manages leaderboard persistence and display
    - `Validation.java`: Provides input validation utilities
- `lib/`: Folder for dependencies (none required for this project)
- `bin/`: Compiled output files (generated automatically)
- `scoreboard.txt`: Persistent storage for player scores (created after first game)

# Development Environment

For this project I used Java programming language using VS Code for my IDE. I also installed latest Java Development Kit to help in running the program. To make my coding experience better, I installed the Extension Pack for Java extension in VS Code.

# Useful Websites

- https://www.youtube.com/watch?v=eIrMbAQSU34&t=8726s
- https://dev.java/learn/getting-started/#more-learning

# Future Work

- Need to fix leaderboards to show every player's entry.
- Need to add more guiding prompts for user inputs.