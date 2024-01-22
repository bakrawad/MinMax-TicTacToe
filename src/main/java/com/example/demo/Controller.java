package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    public static String starter = "player";

    public static ArrayList<Button> buttons;

    public static boolean fl = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button0,button1,button2,button3,button4,button5,button6,button7,button8));
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            char gameType = 'H';
            switch (gameType) {
                case 'H': setupButton_PVAI_H(button); break;
                case 'P': setupButton_PVP(button); break;
                case 'E': setupButton_PVAI_E(button); break;
            }
        }
    }

    public void setupButton_PVP(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            String winner ;
            if (!fl){
                setSymbol(button, "player");
                button.setDisable(true);
                fl = true;
                winner = getWinner(buttons);
                if(winner.length()>0 || isFull(buttons)){
                    disableButtons(buttons);
                    if (winner.length() <= 0) {
                        isFull(buttons);
                    }
                    if (winner.equals("ai")) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("شلك ثوكبتك !!!!");
                        alert.setContentText("شلك ثوكبتك !!!!");
                        alert.show();// AI wins
                    } else if (winner.equals("player")) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("شلكت ثوكبت ال AI !!!!");
                        alert.setContentText("شلكت ثوكبت ال AI !!!!");
                        alert.show();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("ولا حد شلك الثاني !!!!");
                        alert.setContentText("ولا حد شلك الثاني !!!!");
                        alert.show();
                    }

                }
                return;
            }

            // check for winner after AI makes a move
            boolean boardIsFull = isFull(buttons);
            if(!boardIsFull && fl &&getWinner(buttons).length() == 0){
                setSymbol(button, "ai");
                button.setDisable(true);
                fl = false;
            }

            winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
            }
            if (winner.length()>0 || isFull(buttons)){
                if (winner.equals("ai")){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلك ثوكبتك !!!!");
                    alert.setContentText("شلك ثوكبتك !!!!");
                    alert.show();// AI wins
                }else if (winner.equals("player")){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلكت ثوكبت ال AI !!!!");
                    alert.setContentText("شلكت ثوكبت ال AI !!!!");
                    alert.show();
                }else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ولا حد شلك الثاني !!!!");
                    alert.setContentText("ولا حد شلك الثاني !!!!");
                    alert.show();
                }
            }
        });
    }


    public void setupButton_PVAI_E(Button button) {

        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button, "player");
            button.setDisable(true);

            // check for winner after player makes a move
            String winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلك ثوكبتك !!!!");
                    alert.setContentText("شلك ثوكبتك !!!!");
                    alert.show();// AI wins
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلكت ثوكبت ال AI !!!!");
                    alert.setContentText("شلكت ثوكبت ال AI !!!!");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ولا حد شلك الثاني !!!!");
                    alert.setContentText("ولا حد شلك الثاني !!!!");
                    alert.show();
                    return;
                }
            }

            // AI makes a move
            boolean boardIsFull = isFull(buttons);
            if(!boardIsFull && getWinner(buttons).length() == 0){
                int move = random_choose(buttons)[1];
                Button b = buttons.get(move);
                setSymbol(b, "ai");
                b.setDisable(true);
            }

            // check for winner after AI makes a move
            winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلك ثوكبتك !!!!");
                    alert.setContentText("شلك ثوكبتك !!!!");
                    alert.show();// AI wins
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلكت ثوكبت ال AI !!!!");
                    alert.setContentText("شلكت ثوكبت ال AI !!!!");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ولا حد شلك الثاني !!!!");
                    alert.setContentText("ولا حد شلك الثاني !!!!");
                    alert.show();
                }
            }
        });

    }


    public void setupButton_PVAI_H(Button button) {

        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button, "player");
            button.setDisable(true);

            // check for winner after player makes a move
            String winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلك ثوكبتك !!!!");
                    alert.setContentText("شلك ثوكبتك !!!!");
                    alert.show();// AI wins
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلكت ثوكبت ال AI !!!!");
                    alert.setContentText("شلكت ثوكبت ال AI !!!!");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ولا حد شلك الثاني !!!!");
                    alert.setContentText("ولا حد شلك الثاني !!!!");
                    alert.show();
                    return;
                }
            }

            // AI makes a move
            boolean boardIsFull = isFull(buttons);
            if(!boardIsFull && getWinner(buttons).length() == 0){
                int move = minimax(buttons, "ai")[1];
                Button b = buttons.get(move);
                setSymbol(b, "ai");
                b.setDisable(true);
            }

            // check for winner after AI makes a move
            winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلك ثوكبتك !!!!");
                    alert.setContentText("شلك ثوكبتك !!!!");
                    alert.show();// AI wins
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("شلكت ثوكبت ال AI !!!!");
                    alert.setContentText("شلكت ثوكبت ال AI !!!!");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ولا حد شلك الثاني !!!!");
                    alert.setContentText("ولا حد شلك الثاني !!!!");
                    alert.show();
                }
            }
        });

    }


    public static void setSymbol(Button button, String player){
        button.setFont(new Font(40));
        if ("player".equals(player)) {
            button.setText("X");
        } else if ("ai".equals(player)) {
            button.setText("0");
        } else if ("empty".equals(player)) {
            button.setText("");
        }
    }

    public boolean checkLine(Button a, Button b, Button c){
        return a.getText().equals(b.getText()) && b.getText().equals(c.getText()) && a.getText().length() > 0;
    }

    public String getWinner(List<Button> buttons){
        String symbol = "";  // symbol of the winner (0 or X)
        String winner = "";  // name of the winner

        if(checkLine(button0, button1, button2)){         // rows
            symbol = button0.getText();
        } else if(checkLine(button3, button4, button5)){
            symbol = button3.getText();
        } else if(checkLine(button6, button7, button8)){
            symbol = button6.getText();
        } else if(checkLine(button0, button3, button6)){  // columns
            symbol = button0.getText();
        } else if(checkLine(button1, button4, button7)){
            symbol = button1.getText();
        } else if(checkLine(button2, button5, button8)){
            symbol = button2.getText();
        } else if(checkLine(button0, button4, button8)){  // diagonals
            symbol = button0.getText();
        } else if(checkLine(button2, button4, button6)){
            symbol = button2.getText();
        }

        boolean boardIsFull = isFull(buttons);
        if(symbol.equals("X")){                          // player wins
            winner = "player";
        } else if(symbol.equals("0")){
            winner = "ai";
        } else if(boardIsFull && symbol.length() == 0){  // draw
            winner = "nobody";
        }
        return winner;
    }

    public static boolean isFull(List<Button> buttons){
        for(int i = 0; i < 9; i++){
            if(buttons.get(i).getText().length() == 0){
                return false;
            }
        }
        return true;
    }

    public static void disableButtons(List<Button> buttons){
        for(Button button : buttons){
            button.setDisable(true);
        }
    }

    public static void resetButtons(List<Button> buttons){
        for(Button button: buttons){
            setSymbol(button, "empty");
            button.setDisable(false);
        }
        if (starter.equals("player")) {// starting player alternates
            starter = "ai";
        } else {
            starter = "player";
        }
    }

    public int[] minimax(List<Button> buttons, String player) {
        String winner = getWinner(buttons);
        if (!(winner.equals(""))) {
            if (winner.equals("player")) {
                return new int[]{-1, 0};
            }
            if (winner.equals("ai")) {
                return new int[]{1, 0};
            }
            if (winner.equals("nobody")) {
                return new int[]{0, 0};
            }
        }

        if(player.equals("ai")) {
            int bestScore = -100;
            int bestMove = 0;

            for (int pos = 0; pos < 9; pos++) {
                Button button = buttons.get(pos);
                if (button.getText().length() == 0) {
                    setSymbol(button, player);


                    int score = minimax(buttons, "player")[0];
                    if (score >= bestScore) { // check for the best Score
                        bestScore = score;
                        bestMove = pos;
                    }


                    setSymbol(button, "empty");// but the button empty after check
                }
            }
            return new int[]{bestScore, bestMove};
        } else {
            int bestScore = 100;
            int bestMove = 0;

            for (int pos = 0; pos < 9; pos++) {
                Button button = buttons.get(pos);
                if (button.getText().length() == 0) {
                    setSymbol(button, player);
                    int score = minimax(buttons, "ai")[0];
                    if (score <= bestScore) {// check for the best Score
                        bestScore = score;
                        bestMove = pos;
                    }
                    setSymbol(button, "empty");// but the button empty after check
                }
            }
            return new int[]{bestScore, bestMove};
        }

    }
    public int[] random_choose(List<Button> buttons) {
        String winner = getWinner(buttons);
        if (!winner.equals("")) {
            if (winner.equals("player")) {
                return new int[]{-1, 0};
            }
            if (winner.equals("ai")) {
                return new int[]{1, 0};
            }
            if (winner.equals("nobody")) {
                return new int[]{0, 0};
            }
        }
        int bestMove = 0;

        Random random = new Random();
        List<Integer> availableMoves = new ArrayList<>();

        for (int pos = 0; pos < 9; pos++) {
            Button button = buttons.get(pos);
            if (button.getText().length() == 0) {
                availableMoves.add(pos);
            }
        }
        if (!availableMoves.isEmpty()) {
            int randomMove = availableMoves.get(random.nextInt(availableMoves.size()));
            bestMove = randomMove;
        }

        return new int[]{0, bestMove};
    }

}