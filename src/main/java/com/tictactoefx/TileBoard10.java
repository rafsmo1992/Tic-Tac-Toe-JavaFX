package com.tictactoefx;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class TileBoard10 {

    private StackPane pane;
    private InfoCenter infoCenter;
    private Tile[][] tiles = new Tile[10][10];
    private Line winningLine;
    private char playerTurn = 'X';
    private boolean isEndOfGame = false;

    public TileBoard10(InfoCenter infoCenter)
    {
    this.infoCenter = infoCenter;
    pane = new StackPane();
    pane.setMinSize(UIConstants.APP_WIDTH, UIConstants.TILE_BOARD_HEIGHT);
    pane.setTranslateX(UIConstants.APP_WIDTH /2 -250);
    pane.setTranslateY((UIConstants.TILE_BOARD_HEIGHT /2) + UIConstants.INFO_CENTER_HEIGHT);
    addAllTiles();

    winningLine = new Line();
    pane.getChildren().add(winningLine);
    }
    public void Hidepane()
    {
        pane.setVisible(false);

    }
    public void Showpane()
    {
        pane.setVisible(true);

    }
    private void addAllTiles() {
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col * 75) - 75);
                tile.getStackPane().setTranslateY((row * 75) - 75);
                pane.getChildren().add(tile.getStackPane());
                tiles[row][col] = tile;

            }
        }
    }

    public void startNewGame()
    {
        isEndOfGame = false;
        playerTurn = 'X';
        for(int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                tiles[row][col].setValue("");
            }
        }
        winningLine.setVisible(false);
    }
public void changePlayerTurn()
{
    if (playerTurn == 'X') {
        playerTurn = 'O';
    }
        else{
            playerTurn = 'X';
        }
        infoCenter.updateMessage("Player " + playerTurn + "'s turn");
}

    public String getPlayerTurn()
    {
        return String.valueOf(playerTurn);

    }
    public StackPane getStackPane()
    {
        return pane;
    }

    public void checkForWinner()
    {
    checkRowsForWinner();
    checkColsForWinner();
    checkTopLeftToBottomRightForWinner();
    checkTopRightToBottomLeftForWinner();
    checkForStalemate();
    }



    private void checkRowsForWinner() {
        if (!isEndOfGame) {
            for (int row = 0; row < 10; row++) {
                for(int col = 0; col< 5; col++)
                {
                if (tiles[row][col].getValue().equals(tiles[row][col].getValue())
                        && tiles[row][col].getValue().equals(tiles[row][col +1].getValue())
                        && tiles[row][col].getValue().equals(tiles[row][col +2].getValue())
                        && tiles[row][col].getValue().equals(tiles[row][col +3].getValue())
                        && tiles[row][col].getValue().equals(tiles[row][col +4].getValue())
                        && !tiles[row][col].getValue().isEmpty()) {
                        String winner = tiles[row][col].getValue();
                        endGame(winner, new WinningTiles(tiles[row][col], tiles[row][col+2], tiles[row][col+4]));
                        return;
                    }
                }
            }
        }
    }

    private void checkColsForWinner() {
        if(!isEndOfGame)
        {
            for (int col = 0; col < 10; col++) {
                for(int row = 0; row< 5; row++)
                {
                    if (tiles[row][col].getValue().equals(tiles[row][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +1][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +2][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +3][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +4][col].getValue())
                            && !tiles[row][col].getValue().isEmpty()) {
                        String winner = tiles[row][col].getValue();
                        endGame(winner, new WinningTiles(tiles[row][col], tiles[row+2][col], tiles[row+4][col]));
                        return;
                    }
                }
            }
        }

    }

    private void checkTopLeftToBottomRightForWinner() {
        if (!isEndOfGame) {
            for (int row = 0; row < 6; row++) {
                for(int col = 0; col < 6; col++)
                {
                    if (tiles[row][col].getValue().equals(tiles[row][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +1][col +1].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +2][col +2].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +3][col +3].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +4][col +4].getValue())
                            && !tiles[row][col].getValue().isEmpty()) {
                        String winner = tiles[row][col].getValue();
                        endGame(winner, new WinningTiles(tiles[row][col], tiles[row+2][col+2], tiles[row+4][col+4]));
                        return;
                    }
                }
            }
        }
    }
    private void checkTopRightToBottomLeftForWinner() {
        if(!isEndOfGame)
            for (int row = 0; row < 6; row++) {
                for(int col = 9; col > 3; col--)
                {
                    if (tiles[row][col].getValue().equals(tiles[row][col].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +1][col -1].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +2][col -2].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +3][col -3].getValue())
                            && tiles[row][col].getValue().equals(tiles[row +4][col -4].getValue())
                            && !tiles[row][col].getValue().isEmpty()) {
                        String winner = tiles[row][col].getValue();
                        endGame(winner, new WinningTiles(tiles[row][col], tiles[row+2][col-2], tiles[row+4][col-4]));
                        return;
                    }
                }
            }
    }
    private void checkForStalemate() {
        if(!isEndOfGame)
        {
            for(int row = 0; row<10; row++)
            {
                for(int col = 0;col<10;col++)
                {
                    if(tiles[row][col].getValue().isEmpty())
                    {
                        return;
                    }
                }
            }
            isEndOfGame = true;
            infoCenter.updateMessage("Stalemate...");
            infoCenter.showStartButton();
            infoCenter.showPlayAgainButton();
            Counter.Tie++;
            infoCenter.updateScore("ScoreBoard:" + "\n" +
                    "Player X:" + Counter.XWins +
                    "\n" +
                    "Player O:" + Counter.YWins +
                    "\n" +
                    "Tie:" + Counter.Tie);
        }
    }





    public void endGame(String winner, WinningTiles winningTiles)
     {
         isEndOfGame = true;
         drawWinningLine(winningTiles);
         infoCenter.updateMessage("Player " + winner + " wins!!");
         infoCenter.showStartButton();
         infoCenter.showPlayAgainButton();
         if(winner.equals("X"))
         {
             Counter.XWins++;
             infoCenter.updateScore("ScoreBoard:" + "\n" +
                     "Player X:" + Counter.XWins +
                     "\n" +
                     "Player O:" + Counter.YWins +
                     "\n" +
                     "Tie:" + Counter.Tie);
         } else if (winner.equals("O")) {
             Counter.YWins++;
             infoCenter.updateScore("ScoreBoard:" + "\n" +
                     "Player X:" + Counter.XWins +
                     "\n" +
                     "Player O:" + Counter.YWins +
                     "\n" +
                     "Tie:" + Counter.Tie);
         }
     }
    private void drawWinningLine(WinningTiles winningTiles){
        winningLine.setStartX(winningTiles.start.getStackPane().getTranslateX());
        winningLine.setStartY(winningTiles.start.getStackPane().getTranslateY());
        winningLine.setEndX(winningTiles.end.getStackPane().getTranslateX());
        winningLine.setEndY(winningTiles.end.getStackPane().getTranslateY());
        winningLine.setTranslateX(winningTiles.middle.getStackPane().getTranslateX());
        winningLine.setTranslateY(winningTiles.middle.getStackPane().getTranslateY());
        winningLine.setVisible(true);
    }

     private class WinningTiles {
         Tile start;
         Tile middle;
         Tile end;
         public WinningTiles(Tile start, Tile middle, Tile end)
        {
            this.start = start;
            this.middle = middle;
            this.end = end;
        }

     }
    private class Tile {

        private StackPane pane;
        private Label label;
        public Tile() {
            pane = new StackPane();
            pane.setMinSize(75, 75);


            Rectangle border = new Rectangle();
            border.setWidth(75);
            border.setHeight(75);
            border.setFill(Color.TRANSPARENT);
            border.setStroke(Color.BLACK);
            pane.getChildren().add(border);

            label = new Label("");
            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font(50));
            pane.getChildren().add(label);

            pane.setOnMouseClicked(event -> {
                if (label.getText().isEmpty() && !isEndOfGame){
                    label.setText(getPlayerTurn());
                    changePlayerTurn();
                    checkForWinner();
                }
            });
        }
        public StackPane getStackPane(){
            return pane;

        }
        public String getValue(){
            return label.getText();
        }
        public void setValue(String value){
            label.setText(value);
        }

    }

}
