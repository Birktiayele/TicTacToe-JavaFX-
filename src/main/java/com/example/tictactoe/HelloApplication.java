package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage stage;
    private Scene tictactoeScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        FXMLLoader tictactoeLoader = new FXMLLoader(getClass().getResource("TicTacToe.fxml"));
        Parent tictactoeRoot = tictactoeLoader.load();
        tictactoeScene = new Scene(tictactoeRoot, 800, 600);

        // Set the TicTacToe scene as the primary scene initially
        stage.setScene(tictactoeScene);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
