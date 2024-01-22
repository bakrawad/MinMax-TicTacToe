package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class tictac extends Application {
    private Button button0 =new Button();


    private Button button1= new Button();


    private Button button2= new Button();


    private Button button3= new Button();


    private Button button4= new Button();


    private Button button5= new Button();


    private Button button6= new Button();


    private Button button7= new Button();


    private Button button8= new Button();

    public static String starter = "player";

    public static ArrayList<Button> buttons;

    public static boolean fl = false;
    boolean flag = false;
    public AnchorPane pane = new AnchorPane();
    public char GameMode;

    public String Xname;
    public String Oname;

    public int NumOfRound=1;

    public int ScoreOne;
    public int ScoreTwo;
    public Label lbSOne;
    public Label lbSTwo;

    public TextArea textArea  ;


    public void start(Stage primaryStage) {

        Image image = new Image("Back.gif");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        textArea = new TextArea();
        textArea.setPrefHeight(150);
        textArea.setPrefWidth(400);
        textArea.setLayoutX(20);
        textArea.setLayoutY(530);
        textArea.setStyle("-fx-background-color: #202051; " + "-fx-text-fill: White; " + "-fx-control-inner-background: #202051; " + "-fx-border-color: #3e3e3e; " + "-fx-border-width: 2px;" + "-fx-padding: 5px;");
        textArea.setEditable(false);
        pane.getChildren().addAll(textArea);
        textArea.setVisible(false);



        AnchorPane root = new AnchorPane();
        root.setBackground(new Background(backgroundImage));


        Button btPlay = new Button("Play");
        Label lb1v1 = new Label("1V1");
        Label lbEs = new Label("Easy Mode");
        Label lbUb = new Label("Unbeatable Mode");
        //style for label's
        lb1v1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lb1v1.setStyle("-fx-text-fill: white;");
        lbEs.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbEs.setStyle("-fx-text-fill: white;");
        lbUb.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbUb.setStyle("-fx-text-fill: white;");


        //style for Name Of project
        Label lbTicTac = new Label("Tic Tac Toe Game");
        Label lbBakr = new Label("Bakr Edition");
        lbTicTac.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        lbTicTac.setStyle("-fx-text-fill: white;");
        lbBakr.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        lbBakr.setStyle("-fx-text-fill: white;");

        lbTicTac.setLayoutY(100);
        lbTicTac.setLayoutX(200);
        lbBakr.setLayoutY(140);
        lbBakr.setLayoutX(260);
        root.getChildren().addAll(lbTicTac,lbBakr);

        //style for button
        btPlay.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 20 40;-fx-border-color: #202040; -fx-border-width: 2;");
        btPlay.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR , 18));
        btPlay.setOnMouseEntered(e -> btPlay.setStyle("-fx-background-color: #010a2a; -fx-text-fill: white; -fx-padding: 20 40;-fx-border-color: #202040; -fx-border-width: 2;"));
        btPlay.setOnMouseExited(e -> btPlay.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 20 40;-fx-border-color: #202040; -fx-border-width: 2;"));

        //style for name of label and textField
        TextField txNameOfPl1 = new TextField();
        TextField txNameOfPl2 = new TextField();
        TextField txRound = new TextField();
        txNameOfPl1.setDisable(true);
        txNameOfPl2.setDisable(true);
        txRound.setDisable(true);
        txRound.setPrefWidth(100);
        txRound.setPrefHeight(20);
        txNameOfPl1.setPrefWidth(100);
        txNameOfPl1.setPrefHeight(20);
        txNameOfPl2.setPrefWidth(100);
        txNameOfPl2.setPrefHeight(20);
        txRound.setText(5+"");
        Label lbRound = new Label("Number Of Round");
        Label lbNameOfPl = new Label("Name Of Players");
        Label lbNameOfPl1 = new Label("Player One");
        Label lbNameOfPl2 = new Label("Player Two");
        lbRound.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lbRound.setStyle("-fx-text-fill: white;");
        lbNameOfPl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lbNameOfPl.setStyle("-fx-text-fill: white;");
        lbNameOfPl1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbNameOfPl1.setStyle("-fx-text-fill: white;");
        lbNameOfPl2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lbNameOfPl2.setStyle("-fx-text-fill: white;");

        lbNameOfPl.setLayoutX(500);
        lbNameOfPl.setLayoutY(370);
        HBox hPl1 = new HBox(10);
        hPl1.getChildren().addAll(lbNameOfPl1,txNameOfPl1);
        HBox hPl2 = new HBox(10);
        hPl2.getChildren().addAll(lbNameOfPl2,txNameOfPl2);
        HBox hRu = new HBox(10);
        hRu.getChildren().addAll(lbRound,txRound);
        hRu.setLayoutX(422);
        hRu.setLayoutY(490);
        VBox vPl = new VBox(20);
        vPl.getChildren().addAll(hPl1,hPl2);

       // vPl.setVisible(false);// for players name
       // lbNameOfPl.setVisible(false);//for label of the nameof players
       // hRu.setVisible(false);//for the Round
        vPl.setLayoutY(400);
        vPl.setLayoutX(450);
        root.getChildren().addAll(vPl,lbNameOfPl,hRu);

        //Check Box for Who play first
        CheckBox chFirst = new CheckBox();
        Label lbFirst = new Label("Do You Want To Play First ?");
        chFirst.setVisible(false);
        lbFirst.setVisible(false);
        lbFirst.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lbFirst.setStyle("-fx-text-fill: white;");
        HBox hCh = new HBox(10);
        hCh.getChildren().addAll(chFirst,lbFirst);
        hCh.setLayoutX(30);
        hCh.setLayoutY(520);
        root.getChildren().add(hCh);



        RadioButton rb1v1 = new RadioButton();
        RadioButton rbEs = new RadioButton();
        RadioButton rbUb = new RadioButton();
        ToggleGroup tg = new ToggleGroup();
        rb1v1.setToggleGroup(tg);
        rbEs.setToggleGroup(tg);
        rbUb.setToggleGroup(tg);




        HBox h1v1 = new HBox(10);
        h1v1.getChildren().addAll(rb1v1,lb1v1);
        HBox hEs = new HBox(10);
        hEs.getChildren().addAll(rbEs,lbEs);
        HBox hUb = new HBox(10);
        hUb.getChildren().addAll(rbUb,lbUb);

        VBox rb = new VBox(10);
        rb.getChildren().addAll(h1v1,hEs,hUb);
        rb.setLayoutX(30);
        rb.setLayoutY(400);
        root.getChildren().add(rb);

        btPlay.setLayoutX(280);
        btPlay.setLayoutY(580);
        root.getChildren().add(btPlay);
        Scene scene1 = new Scene(root,700,700);




        GridPane gridPane = new GridPane();
        gridPane.setPrefHeight(300.0);
        gridPane.setPrefWidth(300.0);
//        // Add ColumnConstraints


// Add Buttons
        button0.setFocusTraversable(false);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(100);
        button0.setPrefWidth(100);
        button0.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");


        button1.setFocusTraversable(false);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(100);
        button1.setPrefWidth(100);
        button1.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");

// Repeat the above code for button2 to button8 with appropriate indices
        button2.setFocusTraversable(false);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(100);
        button2.setPrefWidth(100);
        button2.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");
        // Repeat the above code for button2 to button8 with appropriate indices
        button3.setFocusTraversable(false);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(100);
        button3.setPrefWidth(100);
        button3.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");

// Repeat the above code for button2 to button8 with appropriate indices
        button4.setFocusTraversable(false);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(100);
        button4.setPrefWidth(100);
        button4.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");

// Repeat the above code for button2 to button8 with appropriate indices
        button5.setFocusTraversable(false);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(100);
        button5.setPrefWidth(100);
        button5.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");

        // Repeat the above code for button2 to button8 with appropriate indices
        button6.setFocusTraversable(false);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(100);
        button6.setPrefWidth(100);
        button6.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");

        // Repeat the above code for button2 to button8 with appropriate indices
        button7.setFocusTraversable(false);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(100);
        button7.setPrefWidth(100);
        button7.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");
        // Repeat the above code for button2 to button8 with appropriate indices
        button8.setFocusTraversable(false);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(100);
        button8.setPrefWidth(100);
        button8.setStyle("-fx-background-color: #6666ad; -fx-text-fill: white; -fx-border-color: #2a2a46; -fx-border-width: 2px; -fx-border-style: solid;");


        Button Replay = new Button("Replay");
        Replay.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;");
        Replay.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR , 18));
        Replay.setOnMouseEntered(e -> Replay.setStyle("-fx-background-color: #010a2a; -fx-text-fill: white; -fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;"));
        Replay.setOnMouseExited(e -> Replay.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;"));


        Button Return = new Button("Return");
        Return.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;");
        Return.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR , 18));
        Return.setOnMouseEntered(e -> Return.setStyle("-fx-background-color: #010a2a; -fx-text-fill: white; -fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;"));
        Return.setOnMouseExited(e -> Return.setStyle("-fx-background-color: #292872;-fx-text-fill: white;-fx-padding: 10 20;-fx-border-color: #202040; -fx-border-width: 2;"));

        Label X = new Label("X");
        Label O = new Label("0");
        X.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        X.setStyle("-fx-text-fill: white;");
        O.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        O.setStyle("-fx-text-fill: white;");

        Label Pl1 = new Label();
        Label Pl2 = new Label();

        Pl1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        Pl1.setStyle("-fx-text-fill: white;");

        Pl2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        Pl2.setStyle("-fx-text-fill: white;");

        lbSOne= new Label("0");
        lbSTwo = new Label("0");

        lbSOne.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        lbSOne.setStyle("-fx-text-fill: white;");

        lbSTwo.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        lbSTwo.setStyle("-fx-text-fill: white;");

        Label Sc = new Label("Score");
        Sc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        Sc.setStyle("-fx-text-fill: white;");

        Label Sc1 = new Label("Score");
        Sc1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        Sc1.setStyle("-fx-text-fill: white;");



        lbSOne.setLayoutX(50);
        lbSOne.setLayoutY(300);
        lbSTwo.setLayoutX(600);
        lbSTwo.setLayoutY(300);

        Sc.setLayoutX(30);
        Sc.setLayoutY(250);

        Sc1.setLayoutX(580);
        Sc1.setLayoutY(250);

        Pl1.setLayoutX(50);
        Pl1.setLayoutY(150);

        Pl2.setLayoutX(600);
        Pl2.setLayoutY(150);

        X.setLayoutX(50);
        X.setLayoutY(100);

        O.setLayoutX(600);
        O.setLayoutY(100);

        reSetButton();
        Return.setLayoutX(550);
        Return.setLayoutY(600);
        pane.getChildren().add(Return);
        Replay.setLayoutX(280);
        Replay.setLayoutY(450);
        pane.getChildren().add(Replay);
        pane.setBackground(new Background(backgroundImage));
        pane.setOnMouseClicked(e ->{
            System.out.println(e.getX()+"  " +e.getY());
        });

        Label lbReb = new Label();
        lbReb.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 22));
        lbReb.setStyle("-fx-text-fill: white;");


        lbReb.setText(NumOfRound+"/"+txRound.getText());
        lbReb.setLayoutX(620);
        lbReb.setLayoutY(400);
        pane.getChildren().addAll(X,O,Pl1,Pl2,lbReb,lbSOne,lbSTwo,Sc,Sc1);
        rb1v1.setOnAction(e ->{
            txRound.setDisable(false);
            txNameOfPl1.setDisable(false);
            txNameOfPl2.setDisable(false);
            chFirst.setVisible(false);
            lbFirst.setVisible(false);
        });
        rbEs.setOnAction(e ->{
            txRound.setDisable(false);
            chFirst.setVisible(true);
            lbFirst.setVisible(true);
            txNameOfPl1.setDisable(true);
            txNameOfPl2.setDisable(true);
        });
        rbUb.setOnAction(e ->{
            txRound.setDisable(false);
            chFirst.setVisible(true);
            lbFirst.setVisible(true);
            txNameOfPl1.setDisable(true);
            txNameOfPl2.setDisable(true);
            textArea.setVisible(true);
        });
        Replay.setOnAction(event -> {
            if (NumOfRound==Integer.parseInt(txRound.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You Are Played All Round");
                alert.setContentText("You Are Played All Round , Please Start A New Game");
                alert.show();
                return;
            }
            NumOfRound++;
            lbReb.setText(NumOfRound+"/"+txRound.getText());
            pane.getChildren().clear();
            resetButtons(buttons);
            if (rbEs.isSelected()||rbUb.isSelected()){
                if (starter.equals("ai")){
                    int move = minimax(buttons, "ai",true)[1];
                    Button b = buttons.get(move);
                    setSymbol(b, "ai");
                    b.setDisable(true);
                }
            }
            reSetButton();
            pane.getChildren().addAll(Replay,Return,X,O,Pl1,Pl2,lbReb,lbSOne,lbSTwo,Sc,Sc1,textArea);

        });
        Return.setOnAction(e ->{
            textArea.setVisible(false);
            ScoreOne = 0;
            ScoreTwo = 0;
            NumOfRound = 1;
            lbSTwo.setText(ScoreTwo+"");
            lbSOne.setText(ScoreOne+"");
            lbReb.setText(NumOfRound+"/"+txRound.getText());
            pane.getChildren().clear();
            resetButtons(buttons);
            reSetButton();
            pane.getChildren().addAll(Replay,Return,X,O,Pl1,Pl2,lbReb,lbSOne,lbSTwo,Sc,Sc1,textArea);
            textArea.clear();
            primaryStage.setScene(scene1);
            chFirst.setSelected(false);
            rb1v1.setSelected(false);
            rbUb.setSelected(false);
            rbEs.setSelected(false);
            chFirst.setVisible(false);
            lbFirst.setVisible(false);
            txRound.setText(5+"");
            txNameOfPl1.clear();
            txNameOfPl2.clear();
            txNameOfPl1.setDisable(true);
            txNameOfPl2.setDisable(true);
            txRound.setDisable(true);
            flag = false;
        });

        Scene scene = new Scene(pane, 700, 700);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();

        btPlay.setOnAction(e ->{

            ScoreOne = 0;
            ScoreTwo = 0;

            NumOfRound = 1;
            if (!ishasInt(txRound.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error Number");
                alert.setContentText("Please put a Valid Number !!");
                alert.show();
                return;
            }
            if (chFirst.isSelected()){
                starter = "ai";
            }else {
                starter = "player";
            }

            if (rb1v1.isSelected()){
                GameMode='P';
                flag = true;
                starter = "ai";
                if (txNameOfPl1.getLength()<1 || txNameOfPl2.getLength()<1){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Fill the name's pf Player ! !");
                    alert.setContentText("Please Fill the name's pf Player !");
                    alert.show();
                    return;
                }
                Xname = txNameOfPl1.getText();
                Oname = txNameOfPl2.getText();
                Pl1.setText(Xname);
                Pl2.setText(Oname);

            } else if (rbEs.isSelected()) {
                GameMode='E';
                Pl1.setText("You");
                Pl2.setText("AI");
            }else if(rbUb.isSelected()) {
                GameMode='H';
                Pl1.setText("You");
                Pl2.setText("AI");
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Chose the Mode !");
                alert.setContentText("Chose The Mode To Start Play");
                alert.show();
                return;
            }
            primaryStage.setScene(scene);
            buttons = new ArrayList<>(Arrays.asList(button0,button1,button2,button3,button4,button5,button6,button7,button8));
            for (int i = 0; i < buttons.size(); i++) {
                Button button = buttons.get(i);
                char gameType = GameMode;
                switch (gameType) {
                    case 'H': setupButton_PVAI_H(button); break;
                    case 'P': setupButton_PVP(button); break;
                    case 'E': setupButton_PVAI_E(button); break;
                }
            }
            resetButtons(buttons);
            if (!flag){
                if(chFirst.isSelected()){
                    gridPane.setDisable(false);
                    starter = "player";
                }
                else if(!chFirst.isSelected()){
                    if (rbUb.isSelected()){
                        int move = minimax(buttons, "ai",true)[1];
                        Button b = buttons.get(move);
                        setSymbol(b, "ai");
                        b.setDisable(true);
                    }
                    gridPane.setDisable(false);
                    starter = "ai";
                    Button randomButton = buttons.get(new Random().nextInt(9));
                    setSymbol(randomButton, "ai");
                    randomButton.setDisable(true);
                }
                flag = true;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void setupButton_PVP(Button button) {//this method for player vs player
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
                        alert.setTitle("The Player "+Oname+" Is Win");
                        alert.setContentText("The Player "+Oname+" Is Win");
                        alert.show();

                        ScoreTwo++;
                        lbSTwo.setText(ScoreTwo+"");
                        setLineInBt();
                    } else if (winner.equals("player")) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("The Player "+Xname+" Is Win");
                        alert.setContentText("The Player "+Xname+" Is Win");
                        alert.show();
                        ScoreOne++;
                        lbSOne.setText(ScoreOne+"");

                        setLineInBt();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("This Game Is Draw");
                        alert.setContentText("This Game Is Draw");
                        alert.show();
                        setLineInBt();
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
                    alert.setTitle("The Player "+Oname+" Is Win");
                    alert.setContentText("The Player "+Oname+" Is Win");
                    ScoreTwo++;
                    lbSTwo.setText(ScoreTwo+"");
                    alert.show();// AI wins

                    setLineInBt();
                }else if (winner.equals("player")){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("The Player "+Xname+" Is Win");
                    alert.setContentText("The Player "+Xname+" Is Win");
                    alert.show();
                    ScoreOne++;
                    lbSOne.setText(ScoreOne+"");
                    setLineInBt();
                }else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("This Game Is Draw");
                    alert.setContentText("This Game Is Draw");
                    alert.show();

                }
            }
        });
    }


    public void setupButton_PVAI_E(Button button) {//this method for player vs AI easy mood

        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button, "player");
            button.setDisable(true);

            // check for winner after player makes a move
            String winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("The AI Is Win");
                    alert.setContentText("The AI Is Win");
                    alert.show();// AI wins
                    ScoreTwo++;
                    lbSTwo.setText(ScoreTwo+"");
                    setLineInBt();
                    return;
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("You Beat The AI !!");
                    alert.setContentText("You Beat The AI !!");
                    alert.show();
                    ScoreOne++;
                    lbSOne.setText(ScoreOne+"");
                    setLineInBt();
                    return;
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("This Game Is Draw");
                    alert.setContentText("This Game Is Draw");
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
                    alert.setTitle("The AI Is Win");
                    alert.setContentText("The AI Is Win");
                    alert.show();// AI wins
                    ScoreTwo++;
                    lbSTwo.setText(ScoreTwo+"");
                    setLineInBt();
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("You Beat The AI !!");
                    alert.setContentText("You Beat The AI !!");
                    alert.show();
                    ScoreOne++;
                    lbSOne.setText(ScoreOne+"");
                    setLineInBt();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("This Game Is Draw");
                    alert.setContentText("This Game Is Draw");
                    alert.show();
                }
            }
        });

    }


    public void setupButton_PVAI_H(Button button) {//This method player vs Unbeatable AI

        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button, "player");
            button.setDisable(true);

            // check for winner after player makes a move
            String winner = getWinner(buttons);
            if(winner.length() > 0){
                disableButtons(buttons);
                if (winner.equals("ai")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("The AI Is Win");
                    alert.setContentText("The AI Is Win");
                    alert.show();// AI wins
                    ScoreTwo++;
                    lbSTwo.setText(ScoreTwo+"");
                    setLineInBt();

                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("You Beat The AI !!");
                    alert.setContentText("You Beat The AI !!");
                    alert.show();
                    ScoreOne++;
                    lbSOne.setText(ScoreOne+"");
                    setLineInBt();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("This Game Is Draw");
                    alert.setContentText("This Game Is Draw");
                    alert.show();
                    return;
                }
            }

            // AI makes a move
            boolean boardIsFull = isFull(buttons);
            if(!boardIsFull && getWinner(buttons).length() == 0){
                int move = minimax(buttons, "ai",true)[1];
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
                    alert.setTitle("The AI Is Win");
                    alert.setContentText("The AI Is Win");
                    alert.show();// AI wins
                    ScoreTwo++;
                    lbSTwo.setText(ScoreTwo+"");
                    setLineInBt();
                } else if (winner.equals("player")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("You Beat The AI !!");
                    alert.setContentText("You Beat The AI !!");
                    alert.show();
                    ScoreOne++;
                    lbSOne.setText(ScoreOne+"");
                    setLineInBt();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("This Game Is Draw");
                    alert.setContentText("This Game Is Draw");
                    alert.show();
                }
            }
        });

    }


    public static void setSymbol(Button button, String player){//this method to but into a button X or O
        button.setFont(new Font(40));
        if ("player".equals(player)) {
            button.setText("X");
        } else if ("ai".equals(player)) {
            button.setText("0");
        } else if ("empty".equals(player)) {
            button.setText("");
        }
    }

    public boolean checkLine(Button a, Button b, Button c){//this method to check of line for X or O
        return a.getText().equals(b.getText()) && b.getText().equals(c.getText()) && a.getText().length() > 0;
    }

    public String getWinner(List<Button> buttons){//this method to get the Winner
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
        } else if(symbol.equals("0")){                  //AI win
            winner = "ai";
        } else if(boardIsFull && symbol.length() == 0){  // draw
            winner = "nobody";
        }
        return winner;
    }

    public static boolean isFull(List<Button> buttons){//to check if the Buttons is Pressed
        for(int i = 0; i < 9; i++){
            if(buttons.get(i).getText().length() == 0){
                return false;
            }
        }
        return true;
    }

    public static void disableButtons(List<Button> buttons){//to disable all buttons
        for(Button button : buttons){
            button.setDisable(true);
        }
    }

    public static void resetButtons(List<Button> buttons){//to reset the all button and make the starter player or ai
        for(Button button: buttons){
            setSymbol(button, "empty");
            button.setDisable(false);
        }
        if (starter.equals("player")) {// starting player
            starter = "ai";
        } else {
            starter = "player";
        }
    }

    public int[] minimax(List<Button> buttons, String player , boolean isTop) {//this is min max method to get the best move for ai
        String winner = getWinner(buttons);
        if (!winner.equals("")) {
            if (winner.equals("player")) {
                return new int[]{-1, 0};
            } else if (winner.equals("ai")) {
                return new int[]{1, 0};
            } else { // "nobody"
                return new int[]{0, 0};
            }
        }

        int bestScore;
        int bestMove = -1;
        int[] scores = new int[9];

        if (player.equals("ai")) {
            bestScore = -10;
            for (int pos = 0; pos < 9; pos++) {
                Button button = buttons.get(pos);
                if (button.getText().isEmpty()) {
                    setSymbol(button, player);
                    int score = minimax(buttons, "player",false)[0];
                    if (score > bestScore) { // check for the best Score
                        bestScore = score;
                        bestMove = pos;
                    }
                    setSymbol(button, "empty");
                    scores[pos] = score;
                } else {
                    scores[pos] = -10;
                }
            }
        } else {
            bestScore = 10;
            for (int pos = 0; pos < 9; pos++) {
                Button button = buttons.get(pos);
                if (button.getText().isEmpty()) {
                    setSymbol(button, player);
                    int score = minimax(buttons, "ai",false)[0];
                    if (score < bestScore) { // check for the best Score
                        bestScore = score;
                        bestMove = pos;
                    }
                    setSymbol(button, "empty");
                    scores[pos] = score;
                } else {
                    scores[pos] = 10;
                }
            }
        }
        if (isTop){
            printFinalPossibleMoves(scores);
        }
        return new int[]{bestScore, bestMove};
    }

    private void printFinalPossibleMoves(int[] scores) {//this method to print all possible moves
        int maxScore = -10;
        int minScore = 10;

        // First, find the max and min scores to calculate the range
        for (int score : scores) {
            if (score > maxScore && score < 10) {
                maxScore = score;
            }
            if (score < minScore && score > -10) {
                minScore = score;
            }
        }


        int scoreRange = maxScore - minScore;
        if (scoreRange == 0) {
            scoreRange = 1;
        }

        System.out.println("Final possible moves with their possibility:");
        for (int i = 0; i < scores.length; i++) {
            // Print only the possible moves
            if (scores[i] > -10 && scores[i] < 10) {
                double possibility =  (double) (scores[i] - minScore) / scoreRange * 100;
                System.out.println("Move " + (i + 1) + ": " + String.format("%.2f%%", possibility));
                textArea.appendText("Final possible moves with their possibility:"+"\n");
                textArea.appendText("Move " + (i + 1) + ": " + String.format("%.2f%%", possibility)+"\n");
            }
        }
        textArea.appendText("------------------------------------------"+"\n");
    }

    public int[] random_choose(List<Button> buttons) {//this method for Random chose Ai
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
    public Line SetLine(Button button1,Button button3){//this method to put lines
        Line line = new Line();
        line.setStrokeWidth(3);
        line.setStartX(button1.getLayoutX()+50);
        line.setStartY(button1.getLayoutY()+50);
        line.setEndX(button3.getLayoutX()+50);
        line.setEndY(button3.getLayoutY()+50);
        return line;
    }
    public void reSetButton(){//this to put button in the pane
        button0.setLayoutX(195);
        button0.setLayoutY(100);

        button1.setLayoutX(295);
        button1.setLayoutY(100);

        button2.setLayoutX(395);
        button2.setLayoutY(100);

        button3.setLayoutX(195);
        button3.setLayoutY(200);

        button4.setLayoutX(295);
        button4.setLayoutY(200);

        button5.setLayoutX(395);
        button5.setLayoutY(200);

        button6.setLayoutX(195);
        button6.setLayoutY(300);

        button7.setLayoutX(295);
        button7.setLayoutY(300);

        button8.setLayoutX(395);
        button8.setLayoutY(300);

        pane.getChildren().addAll(button0,button1,button2,button3,button4,button5,button6,button7,button8);
    }
    public void setLineInBt(){//this method to put lines in the button

        if(checkLine(button0, button1, button2)){         // rows
            pane.getChildren().add(SetLine(button0,button2));

        } else if(checkLine(button3, button4, button5)){
            pane.getChildren().add(SetLine(button3,button5));

        } else if(checkLine(button6, button7, button8)){
            pane.getChildren().add(SetLine(button6,button8));

        } else if(checkLine(button0, button3, button6)){
            pane.getChildren().add(SetLine(button0,button6));// columns

        } else if(checkLine(button1, button4, button7)){
            pane.getChildren().add(SetLine(button1,button7));

        } else if(checkLine(button2, button5, button8)){
            pane.getChildren().add(SetLine(button2,button8));

        } else if(checkLine(button0, button4, button8)){// diagonals

            pane.getChildren().add(SetLine(button0,button8));

        } else if(checkLine(button2, button4, button6)){

            pane.getChildren().add(SetLine(button2,button6));
        }

    }
    public static boolean ishasInt(String data){//to check if has Int
        try {
            Double d = Double.parseDouble(data);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}

