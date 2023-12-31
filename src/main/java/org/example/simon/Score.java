package org.example.simon;

public class Score {
    private int score;
    private int highestScore;

    public Score() {
        score = 0;
        highestScore = 0;
    }

    public void changeScore(Controller controller){
        score++;
        controller.changeScore(score);
        if (score > highestScore){
            highestScore = score;
            controller.changeHighestScore(highestScore);
        }
    }



}
