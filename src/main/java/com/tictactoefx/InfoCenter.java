package com.tictactoefx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class InfoCenter {

    private StackPane pane;
    private Label message;
    private Label scoreBoardMessage;
    private Button startGameButton;
    private Button X3Button;
    private Button X10Button;
    private Button playAgainButton;

    private Button playVsPlayer;

    private Button playVsComputer;



    public InfoCenter(){

        pane = new StackPane();
        pane.setMinSize(UIConstants.APP_WIDTH,UIConstants.INFO_CENTER_HEIGHT);
        pane.setTranslateX(UIConstants.APP_WIDTH / 2);
        pane.setTranslateY(UIConstants.INFO_CENTER_HEIGHT /2);

        scoreBoardMessage = new Label("ScoreBoard:" + "\n" +
                "Player X:" + Counter.XWins +
                "\n" +
                "Player O:" + Counter.YWins +
                "\n" +
                "Tie:" + Counter.Tie);

        scoreBoardMessage.setMinSize(UIConstants.APP_WIDTH, UIConstants.INFO_CENTER_HEIGHT);
        scoreBoardMessage.setFont(Font.font(28));
        scoreBoardMessage.setTranslateX(20);
        scoreBoardMessage.setTranslateY(-20);
        pane.getChildren().add(scoreBoardMessage);

        message = new Label("Tic-Tac-Toe");
        message.setMinSize(UIConstants.APP_WIDTH, UIConstants.INFO_CENTER_HEIGHT);
        message.setFont(Font.font(28));
        message.setAlignment(Pos.CENTER);
        message.setTranslateY(-60);
        pane.getChildren().add(message);

        startGameButton = new Button("Start New Game");
        startGameButton.setMinSize(135,30);
        startGameButton.setTranslateY(-20);
        pane.getChildren().add(startGameButton);

        X3Button = new Button("3X3");
        X3Button.setMinSize(135,30);
        X3Button.setTranslateY(-20);
        X3Button.setTranslateX(-80);
        pane.getChildren().add(X3Button);
        X3Button.setVisible(false);

        X10Button = new Button("10X10");
        X10Button.setMinSize(135,30);
        X10Button.setTranslateY(-20);
        X10Button.setTranslateX(60);
        pane.getChildren().add(X10Button);
        X10Button.setVisible(false);

        playVsPlayer = new Button("PVP");
        playVsPlayer.setMinSize(135,30);
        playVsPlayer.setTranslateY(-20);
        playVsPlayer.setTranslateX(-80);
        pane.getChildren().add(playVsPlayer);
        playVsPlayer.setVisible(false);

        playVsComputer = new Button("PVC");
        playVsComputer.setMinSize(135,30);
        playVsComputer.setTranslateY(-20);
        playVsComputer.setTranslateX(60);
        pane.getChildren().add(playVsComputer);
        playVsComputer.setVisible(false);

        playAgainButton = new Button("Play Again");
        playAgainButton.setMinSize(135,30);
        playAgainButton.setTranslateY(-20);
        playAgainButton.setTranslateX(150);
        pane.getChildren().add(playAgainButton);
        playAgainButton.setVisible(false);
    }
    public StackPane getStackPane(){
        return pane;
    }
    public void updateMessage(String message)
    {
        this.message.setText(message);
    }
    public void updateScore(String scoreBoardMessage)
    {
        this.scoreBoardMessage.setText(scoreBoardMessage);
    }

    public void showStartButton()
    {
        startGameButton.setVisible(true);

    }
    public void hideStartButton()
    {
        startGameButton.setVisible(false);

    }
    public void showX3Button()
    {
        X3Button.setVisible(true);

    }
    public void hideX3Button()
    {
        X3Button.setVisible(false);

    }
    public void showX10Button()
    {
        X10Button.setVisible(true);

    }
    public void hideX10Button()
    {
        X10Button.setVisible(false);

    }
    public void showPlayVsPlayer()
    {
        playVsPlayer.setVisible(true);

    }
    public void hidePlayVsPlayer()
    {
        playVsPlayer.setVisible(false);

    }

    public void showPlayVsComputer()
    {
        playVsComputer.setVisible(true);

    }
    public void hidePlayVsComputer()
    {
        playVsComputer.setVisible(false);

    }

    public void showPlayAgainButton()
    {
        playAgainButton.setVisible(true);

    }
    public void hidePlayAgainButton()
    {
        playAgainButton.setVisible(false);

    }

    public void setStartButtonOnAction(EventHandler<ActionEvent> onAction)
    {
        startGameButton.setOnAction(onAction);

    }
    public void setX3GameOnAction(EventHandler<ActionEvent> onAction)
    {
        X3Button.setOnAction(onAction);

    }
    public void setX10GameOnAction(EventHandler<ActionEvent> onAction)
    {
        X10Button.setOnAction(onAction);

    }
    public void setPlayAgainButton(EventHandler<ActionEvent> onAction)
    {
        playAgainButton.setOnAction(onAction);

    }
    public void setPlayVsPlayer(EventHandler<ActionEvent> onAction)
    {
        playVsPlayer.setOnAction(onAction);

    }
    public void setPlayVsComputer(EventHandler<ActionEvent> onAction)
    {
        playVsComputer.setOnAction(onAction);

    }
}
