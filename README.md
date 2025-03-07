# TicTacToe-JavaFX-

## Overview  
This is a simple **Tic-Tac-Toe** game built using **JavaFX**. The game provides a graphical user interface (GUI) for two players to take turns placing their marks (X or O) on a 3x3 grid. The first player to form a horizontal, vertical, or diagonal line with their marks wins the game. If the grid is full and no player has won, the game ends in a draw.  

## Features  
- Interactive **JavaFX GUI** with a clean design  
- Two-player gameplay (local)  
- Highlights winning combinations  
- Displays game status (winner or draw)  
- Option to restart the game  

## Technologies Used  
- **Java** (JDK 11 or later)  
- **JavaFX** (for GUI)  

## Installation and Setup  
1. **Clone the Repository**  
   ```sh
   git clone https://github.com/your-username/tic-tac-toe-javafx.git
   cd tic-tac-toe-javafx
   ```  
2. **Ensure Java and JavaFX are Installed**  
   - Install Java Development Kit (JDK 11 or later).  
   - Install JavaFX SDK and configure JavaFX in your IDE (e.g., IntelliJ, Eclipse).  

3. **Compile and Run the Game**  
   - Using an IDE: Open the project and run the `Main.java` file.  
   - Using the terminal:  
     ```sh
     javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml Main.java
     java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml Main
     ```  

## How to Play  
1. Launch the game.  
2. Player 1 (X) and Player 2 (O) take turns clicking on empty cells.  
3. The game announces the winner when a player forms a row, column, or diagonal with their marks.  
4. If all cells are filled without a winner, the game ends in a draw.  
5. Click the **Restart** button to play again.  

## Screenshots  
**  

## Future Enhancements  
- Add an AI opponent (single-player mode)  
- Implement score tracking  
- Improve UI with animations and sound effects  

## License  
This project is licensed under the MIT License.  

## Author  
**Birkti** 
