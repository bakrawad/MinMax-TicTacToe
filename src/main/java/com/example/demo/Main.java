package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application{
    public void start(Stage stage) {
        try {
            URL fxmlUrl = getClass().getResource("Main.fxml");
            if (fxmlUrl == null) {
                throw new IOException("FXML file not found");
            }

            Parent root = FXMLLoader.load(fxmlUrl);
            Scene scene = new Scene(root);

            scene.setOnKeyPressed(event -> {
                System.out.println("sss");
                if (event.getCode() == KeyCode.R) {
                    ArrayList<Button> buttons = Controller.buttons;
                    Controller.resetButtons(buttons);
                    String starter = Controller.starter;

                    if ("ai".equals(starter)) {
                        Button button = buttons.get(new Random().nextInt(9));
                        Controller.setSymbol(button, "ai");
                        button.setDisable(true);
                    }
                }
            });

            stage.setScene(scene);
            stage.setTitle("TicTacToe");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}