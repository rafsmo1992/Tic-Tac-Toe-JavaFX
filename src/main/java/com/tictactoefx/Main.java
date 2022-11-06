package com.tictactoefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    private InfoCenter infoCenter;
    private TileBoard3 tileBoard3;
    private TileBoard10 tileBoard10;
    private boolean GameModeChecker;
    @Override
    public void start(Stage primaryStage)
    {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, UIConstants.APP_WIDTH, UIConstants.APP_HEIGHT);
            initLayout(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void initLayout(BorderPane root) {
        initInfoCenter(root);
        initTileBoard3(root);
        initTileBoard10(root);
    }


    private void initInfoCenter(BorderPane root) {
        infoCenter = new InfoCenter();
        infoCenter.setStartButtonOnAction(startNewGame());
        infoCenter.setX3GameOnAction(X3Game());
        infoCenter.setX10GameOnAction(X10Game());
        infoCenter.setPlayAgainButton(PlayAgain());
        root.getChildren().add(infoCenter.getStackPane());
    }
    private EventHandler<ActionEvent>startNewGame()
    {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                //tileBoard3.Showpane();
                tileBoard3.Hidepane();
                tileBoard10.Hidepane();
                infoCenter.hideStartButton();
                infoCenter.showX3Button();
                infoCenter.showX10Button();
                infoCenter.hidePlayAgainButton();
                //infoCenter.updateMessage("Player X's Turn");
                //tileBoard3.startNewGame();
            }
        };
    }
    private EventHandler<ActionEvent>X3Game()
    {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                GameModeChecker = true;
                tileBoard3.Showpane();
                infoCenter.hideX3Button();
                infoCenter.hideX10Button();
                infoCenter.updateMessage("Player X's Turn");
                tileBoard3.startNewGame();
            }
        };
    }
    private EventHandler<ActionEvent>X10Game()
    {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                GameModeChecker = false;
                tileBoard10.Showpane();
                infoCenter.hideX3Button();
                infoCenter.hideX10Button();
                infoCenter.updateMessage("Player X's Turn");
                tileBoard10.startNewGame();
            }
        };
    }

    private EventHandler<ActionEvent>PlayAgain()
    {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                if(GameModeChecker) {
                    infoCenter.hideStartButton();
                    infoCenter.hidePlayAgainButton();
                    tileBoard3.Showpane();
                    infoCenter.hideX3Button();
                    infoCenter.updateMessage("Player X's Turn");
                    tileBoard3.startNewGame();
                }
                else {
                    infoCenter.hideStartButton();
                    infoCenter.hidePlayAgainButton();
                    tileBoard10.Showpane();
                    infoCenter.hideX10Button();
                    infoCenter.updateMessage("Player X's Turn");
                    tileBoard10.startNewGame();
                }
            }
        };
    }

    private void initTileBoard3(BorderPane root) {
        tileBoard3 = new TileBoard3(infoCenter);
        root.getChildren().add(tileBoard3.getStackPane());
        tileBoard3.Hidepane();
    }
    private void initTileBoard10(BorderPane root) {
        tileBoard10 = new TileBoard10(infoCenter);
        root.getChildren().add(tileBoard10.getStackPane());
        tileBoard10.Hidepane();
    }
    public static void main (String[] args)
    {
        launch(args);
    }
}

