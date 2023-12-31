package org.example.simon;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import java.io.File;

public class Controller {


    @FXML
    private Label welcomeText;
    @FXML
    private Label lblLevel;
    @FXML
    private Label lblHighestScore;
    @FXML
    private Label lblScore;
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
        welcomeText.setText("Green");
    }
    @FXML
    protected void onMouseClickedRed() {
        welcomeText.setText("Red");
    }

    @FXML
    protected void onMouseClickedBlue() {
        welcomeText.setText("Blue");
    }
    @FXML
    protected void onMouseClickedYellow() {
        welcomeText.setText("Yellow");
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

    public void  changeColorArcRed(){
        PauseTransition pause = new PauseTransition(Duration.millis(500));
        pause.setOnFinished(e -> arcRed.setFill(Color.RED));
        pause.play();
        arcRed.setFill(Color.web("#EE6352"));

    }

    public void changeColorArcBlue(){
        PauseTransition pause = new PauseTransition(Duration.millis(500));
        pause.setOnFinished(e -> arcBlue.setFill(Color.BLUE));
        pause.play();
        arcBlue.setFill(Color.web("#3FA7D6"));

    }

    public void changeColorArcGreen(){
        PauseTransition pause = new PauseTransition(Duration.millis(500));
        pause.setOnFinished(e -> arcGreen.setFill(Color.GREEN));
        pause.play();
        arcGreen.setFill(Color.web("#59CD90"));

    }

    public void changeColorArcYellow(){
        PauseTransition pause = new PauseTransition(Duration.millis(500));
        pause.setOnFinished(e -> arcYellow.setFill(Color.YELLOW));
        pause.play();
        arcYellow.setFill(Color.web("#FAC05E"));
    }
    public void changeHighestScore(int i){
        lblHighestScore.setText( String.format("%03d", i));
    }

    public void changeScore(int i ){
        lblScore.setText( String.format("%03d",i));
    }

    public void changeLevel(int i){
        lblLevel.setText(String.format("%03d", i));
    }
    public void hideStartButton(){
        btnStart.setVisible(false);
    }

    public void playSound(String path){
//               Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
    }
}
