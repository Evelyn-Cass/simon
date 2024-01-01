package org.example.simon;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Controller {

    @FXML
    private Label lblLevel;
    @FXML
    private Label lblHighestLevel;
    @FXML
    private Label lblAlertNextLevel;
    @FXML
    private Label lblAlertGameOver;
    @FXML
    private Label lblAlertYourTurn;
    @FXML
    private Label lblAlertYouWon;
    @FXML
    private Rectangle recAlert;
    @FXML
    private Arc arcRed;
    @FXML
    private Arc arcGreen;
    @FXML
    private Arc arcYellow;
    @FXML
    private Arc arcBlue;
    @FXML
    private Button btnStart;



    @FXML
    protected void onButtonAction(){
        Application.startGame();
    }

    @FXML
    protected void onMouseClickedGreen() {
        //1-Red, 2-Blue, 3-Yellow, 4-Green
        Game.clickedColor(4);
        changeColorArcGreen();
    }
    @FXML
    protected void onMouseClickedRed(){
        //1-Red, 2-Blue, 3-Yellow, 4-Green
        Game.clickedColor(1);
        changeColorArcRed();
    }

    @FXML
    protected void onMouseClickedBlue() {
        //1-Red, 2-Blue, 3-Yellow, 4-Green
        Game.clickedColor(2);
        changeColorArcBlue();
    }
    @FXML
    protected void onMouseClickedYellow() {
        //1-Red, 2-Blue, 3-Yellow, 4-Green
        Game.clickedColor(3);
        changeColorArcYellow();
    }

    @FXML
    protected  void  onMouseEnteredRed(){
        arcRed.setEffect(new DropShadow());
    }
    @FXML
    protected  void  onMouseExitedRed(){
        //arcRed.setFill(Color.RED);
        arcRed.setEffect(null);
    }

    @FXML
    protected  void  onMouseEnteredBlue(){
        //arcBlue.setFill(Color.web("#3FA7D6"));
        arcBlue.setEffect(new DropShadow());
    }
    @FXML
    protected  void  onMouseExitedBlue(){
        //arcBlue.setFill(Color.BLUE);
        arcBlue.setEffect(null);
    }

    @FXML
    protected  void  onMouseEnteredYellow(){
        //arcYellow.setFill(Color.web("#FAC05E"));
        arcYellow.setEffect(new DropShadow());
    }
    @FXML
    protected  void  onMouseExitedYellow(){
        //arcYellow.setFill(Color.YELLOW);
        arcYellow.setEffect(null);
    }

    @FXML
    protected  void  onMouseEnteredGreen(){
       // arcGreen.setFill(Color.web("#59CD90"));
        arcGreen.setEffect(new DropShadow());
    }
    @FXML
    protected  void  onMouseExitedGreen(){
       // arcGreen.setFill(Color.GREEN);
        arcGreen.setEffect(null);
    }

    protected void  changeColorArcRed(){
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(e -> arcRed.setFill(Color.RED));
        pause.play();
        arcRed.setFill(Color.web("#EE6352"));

    }

    protected void changeColorArcBlue(){
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(e -> arcBlue.setFill(Color.BLUE));
        pause.play();
        arcBlue.setFill(Color.web("#3FA7D6"));

    }

    protected void changeColorArcGreen(){
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(e -> arcGreen.setFill(Color.GREEN));
        pause.play();
        arcGreen.setFill(Color.web("#59CD90"));

    }

    protected void changeColorArcYellow(){
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(e -> arcYellow.setFill(Color.YELLOW));
        pause.play();
        arcYellow.setFill(Color.web("#FAC05E"));
    }
    protected void changeHighestLevel(int i){
        lblHighestLevel.setText( String.format("%03d", i));
    }

    protected void changeLevel( int i){
       lblLevel.setText(String.format("%03d", i));
    }
    protected void hideStartButton(){
        btnStart.setVisible(false);
    }
    protected void showStartButton(){
        btnStart.setVisible(true);
    }

    protected void playSound(String path) {
        Media sound = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    protected void showAlertYourTurn(){

        lblAlertYourTurn.setVisible(true);
        recAlert.setVisible(true);
    }
    protected void showAlertNextLevel(){

        lblAlertNextLevel.setVisible(true);
        recAlert.setVisible(true);
    }
    protected void showAlertGameOver(){

        lblAlertGameOver.setVisible(true);
        recAlert.setVisible(true);
    }
    protected void showAlertYouWon(){

        lblAlertYouWon.setVisible(true);
        recAlert.setVisible(true);
    }
    protected void hideAlert(){
        lblAlertYourTurn.setVisible(false);
        lblAlertGameOver.setVisible(false);
        lblAlertNextLevel.setVisible(false);
        lblAlertYouWon.setVisible(false);
        recAlert.setVisible(false);
    }
}
