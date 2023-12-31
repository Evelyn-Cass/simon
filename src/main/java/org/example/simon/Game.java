package org.example.simon;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Game {
    public void game(ColorOrder colorOrder, Controller controller, Level level, Score score) {

        int lvl = level.newLevel(controller);
        colorOrder.generateColor(lvl);
        int[] getColors = colorOrder.getColorOrder();

        //1-Red, 2-Blue, 3-Yellow, 4-Green
        new Thread(() -> {
            for (int i = 0; i < lvl; i++) {
                if (getColors[i] == 1) {
                    controller.changeColorArcRed();
                } else if (getColors[i] == 2) {
                    controller.changeColorArcBlue();
                } else if (getColors[i] == 3) {
                    controller.changeColorArcYellow();
                } else if (getColors[i] == 4) {
                    controller.changeColorArcGreen();

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }
}