package com.example.tictactoe;

import javafx.event.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ChoiceDialog;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;



public class HelloController {



    public HelloController() {
        // default constructor
    }
    private String[] styleColors = new String[2];
    private Color[] colors = new Color[2];
    private Player player1;
    private Player player2;
    private String currentPlayer = "X";
    public final int ROWS=3, COLUMNS=3;
    Board board = new Board(ROWS, COLUMNS, 0);
    @FXML
    MenuItem menuItemNew;
    private MenuItem[] items;
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane gridPane;
    Button[][] btns;

    @FXML
    private Text winnerText;

    @FXML
    private Button colorButton;

    @FXML
    private Button btn1 , btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9;
    public void initialize() {
        // Initialize boardButtons array
        btns = new Button[][] {
                {btn1, btn2, btn3},
                {btn4, btn5, btn6},
                {btn7, btn8, btn9}
        };

        // Set onAction event handlers for each button
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = btns[i][j];
                button.setOnAction(event -> handleButtonClick(button));
            }
        }
        // Initialize colors array


        // Show a choice dialog to select player 1 color
        ChoiceDialog<String> dialog1 = new ChoiceDialog<>("Red", "Red", "Yellow", "Green", "Blue");
        dialog1.setTitle("Select Player 1 Color");
        dialog1.setHeaderText("Player 1, choose your color:");
        dialog1.setContentText("Color:");

        // Show a choice dialog to select player 2 color
        ChoiceDialog<String> dialog2 = new ChoiceDialog<>("Yellow", "Red", "Yellow", "Green", "Blue");
        dialog2.setTitle("Select Player 2 Color");
        dialog2.setHeaderText("Player 2, choose your color:");
        dialog2.setContentText("Color:");

        // Initialize styleColors array with default values
        String[] styleColors = {"-fx-background-color: Red", "-fx-background-color: Yellow"};

        // Get the selected colors and update the styleColors array
        dialog1.showAndWait().ifPresent(selectedColor -> {
            if (selectedColor.equals("Red")) {
                player1 = new Player("X", Color.RED);
            } else if (selectedColor.equals("Yellow")) {
                player1 = new Player("X", Color.YELLOW);
            } else if (selectedColor.equals("Green")) {
                player1 = new Player("X", Color.GREEN);
            } else if (selectedColor.equals("Blue")) {
                player1 = new Player("X", Color.BLUE);
            }
        });

        dialog2.showAndWait().ifPresent(selectedColor -> {
            if (selectedColor.equals("Red")) {
                player2 = new Player("O", Color.RED);
            } else if (selectedColor.equals("Yellow")) {
                player2 = new Player("O", Color.YELLOW);
            } else if (selectedColor.equals("Green")) {
                player2 = new Player("O", Color.GREEN);
            } else if (selectedColor.equals("Blue")) {
                player2 = new Player("O", Color.BLUE);
            }
        });
        // Set the current player to X
        currentPlayer = "X";
    }

    // define instance variables for player colors
    private Color player1Color;
    private Color player2Color;


   // Initial player
    private int turnCount = 0;
    private boolean isGameOver = false;
    @FXML
    private TextArea toText;

    @FXML
    private void onHelp() {
        toText.setText("learn how to code Bozo");
    }

    @FXML
    private void onNewGame() {
        // Clear the text and background color of all the buttons
        for (int row = 0; row < btns.length; row++) {
            for (int col = 0; col < btns[row].length; col++) {
                btns[row][col].setText(" ");
                btns[row][col].setStyle(null);
                btns[row][col].setDisable(false);
            }
        }

        // Reset the turn count and the game status
        turnCount = 0;
        isGameOver = false;

        // Clear the output text area
        toText.clear();

        initialize();
    }




    @FXML
    private void handleButtonClick() {
        // Handle button clicks as before
    }

    private int playerTurn = 0;
    ArrayList<Button> btn;
    Text text = new Text();
    private final String X_MARK = "X";
    private final String O_MARK = "O";
    private String currentPlayerMark = X_MARK; // X goes first

    @FXML
    private void handleButtonClick(Button button) {
        Button clickedButton = (Button) button;
        if (clickedButton.getText().equals(" ")) { // Only allow moves on empty squares
            clickedButton.setText(currentPlayerMark);
            if (checkIfGameIsOver()) {
                disableAllButtons();
                toText.setText(currentPlayerMark + " wins!");
            } else {
                currentPlayerMark = currentPlayerMark.equals(X_MARK) ? O_MARK : X_MARK; // Switch players
                if (currentPlayerMark.equals(X_MARK)) {
                    clickedButton.setStyle("-fx-background-color: " + player1.getColor().toString().replace("0x", "#") + ";");
                    clickedButton.setText("X");
                } else {
                    clickedButton.setStyle("-fx-background-color: " + player2.getColor().toString().replace("0x", "#") + ";");
                    clickedButton.setText("O");
                }
            }
        }
    }


    private boolean checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line = "";
            switch (a) {
                case 0: line = btn1.getText() + btn2.getText() + btn3.getText(); break;
                case 1: line = btn4.getText() + btn5.getText() + btn6.getText(); break;
                case 2: line = btn7.getText() + btn8.getText() + btn9.getText(); break;
                case 3: line = btn1.getText() + btn4.getText() + btn7.getText(); break;
                case 4: line = btn2.getText() + btn5.getText() + btn8.getText(); break;
                case 5: line = btn3.getText() + btn6.getText() + btn9.getText(); break;
                case 6: line = btn1.getText() + btn5.getText() + btn9.getText(); break;
                case 7: line = btn3.getText() + btn5.getText() + btn7.getText(); break;
            }
            if (line.equals("XXX") || line.equals("OOO")) {
                isGameOver = true;
                return true;
            }
        }
        turnCount++;
        if (turnCount == 9) {
            isGameOver = true;
            return true;
        }
        return false;
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j].setDisable(true);
            }
        }
    }


    @FXML
    private void resetGame() {
        // Clear the text and background color of all the buttons
        for (int row = 0; row < btns.length; row++) {
            for (int col = 0; col < btns[row].length; col++) {
                btns[row][col].setText(" ");
                btns[row][col].setStyle(null);
            }
        }

        // Reset the turn count and the game status
        turnCount = 0;
        isGameOver = false;

        // Clear the output text area
        toText.clear();


        // Update the welcome text
        welcomeText.setText("Welcome to Tic Tac Toe! Player " + currentPlayer + ", it's your turn.");
    }


}