package org.example.simon;

public class Level {
    private int level;

    public Level() {
        level = 1;
    }

    public int newLevel(Controller controller){
        level++;
        controller.changeLevel(level);
        return level;
    }

    public void  resetLevel(Controller controller){
        level = 3;
        controller.changeLevel(level);


    }

}
