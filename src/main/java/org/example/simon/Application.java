package org.example.simon;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    static Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("simon-game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 368);
        controller =  fxmlLoader.getController();
        stage.setTitle("Simon");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
    public static void startGame(){

        Level level = new Level();
        ColorOrder colorOrder = new ColorOrder();
        Score score = new Score();
        Game game = new Game();
        colorOrder.resetArrays();
        level.resetLevel(controller);
        score.changeScore(controller);
        //controller.hideStartButton();
        game.game(colorOrder, controller, level, score);


    }
}