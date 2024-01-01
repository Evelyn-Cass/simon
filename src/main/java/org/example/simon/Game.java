package org.example.simon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Game {

    private static Controller controller;
    private static int level;
    private static boolean playerTurn;
    private static int highestLevel;
    private static int[] colorOrder = new int[20];
    private static int[] colorAnswer = new int[20];
    private static int currentColorPosition;

    //
    public static int newLevel() {
        level++;
        controller.changeLevel(level);
        return level;
    }

    public static void resetLevel() {
        level = 0;
        controller.changeLevel(level);
        resetArrays();
        ;
    }

    public static boolean isPlayerTurn() {
        return playerTurn;
    }

    public static void setPlayerTurn(boolean playerTurn2) {
        playerTurn = playerTurn2;
    }

    public static void generateColor(int numberOfColors) {
        for (int i = 0; i < numberOfColors; i++) {
            colorOrder[i] = (int) (Math.random() * 4) + 1;
        }
    }

    public static boolean compareColor() {
        for (int j = 0; j < level; j++) {
            if (colorOrder[j] != colorAnswer[j]) {
                return false;
            }
        }
        return true;
    }

    public static void resetArrays() {
        for (int i = 0; i < colorOrder.length; i++) {
            colorOrder[i] = 0;
            colorAnswer[i] = 0;
        }
        currentColorPosition = 0;
    }

    public static void changeHighestLevel() {
        if (level > highestLevel) {
            highestLevel = level;
            controller.changeHighestLevel(highestLevel);
        }
    }

    public static void setController(Controller controller) {
        Game.controller = controller;
    }


    public static void clickedColor(int i) {

        if (isPlayerTurn()) {
            colorAnswer[currentColorPosition] = i;
            currentColorPosition++;
            if (currentColorPosition == level) {
                gameLevelResult();
            }
        }
    }


    //--------------

    public static void gameNewLevel() {

        int lvl = newLevel();
        generateColor(lvl);

        //1-Red, 2-Blue, 3-Yellow, 4-Green
        new Thread(() -> {

            try {

                setPlayerTurn(false);
                Thread.sleep(500);
                for (int i = 0; i < lvl; i++) {

                    Thread.sleep(1500);

                    controller.playSound("sound/alert.mp3");
                    if (colorOrder[i] == 1) {
                        controller.changeColorArcRed();
                    } else if (colorOrder[i] == 2) {
                        controller.changeColorArcBlue();
                    } else if (colorOrder[i] == 3) {
                        controller.changeColorArcYellow();
                    } else if (colorOrder[i] == 4) {
                        controller.changeColorArcGreen();

                    }
                }

                //Player turn
                Thread.sleep(1500);
                controller.showAlertYourTurn();

                Thread.sleep(700);
                controller.playSound("sound/your-turn.mp3");
                controller.hideAlert();
                setPlayerTurn(true);


            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.fillInStackTrace();
            }
        }).start();


    }

    public static void gameLevelResult() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        setPlayerTurn(false);
        if (compareColor()) {
            if (level == colorOrder.length) {
                changeHighestLevel();
                controller.showAlertYouWon();
                controller.showStartButton();
                controller.playSound("sound/success.mp3");
            }else {
                changeHighestLevel();
                resetArrays();
                controller.showAlertNextLevel();

                new Thread(() -> {

                    try {
                        Thread.sleep(1300);
                        controller.playSound("sound/success.mp3");
                        controller.hideAlert();

                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                }).start();


                gameNewLevel();
            }

        }else {
            controller.showAlertGameOver();
            controller.playSound("sound/failure.mp3");

            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    controller.showStartButton();
                    controller.hideAlert();
                } catch (Exception e) {
                    e.fillInStackTrace();
                }
            }).start();
        }

    }
}