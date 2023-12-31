package org.example.simon;

public class ColorOrder {
    private int[] colorOrder = new int[20];
    private int[] colorAnswer = new  int[20];
    public int[] getColorOrder() {
        return colorOrder;
    }

    public void setColorOrder(int[] colorOrder) {
        this.colorOrder = colorOrder;
    }

    public int[] getColorAnswer() {
        return colorAnswer;
    }

    public void setColorAnswer(int[] colorAnswer) {
        this.colorAnswer = colorAnswer;
    }



    public void generateColor(int numberOfColors){
        for (int i = 0; i < numberOfColors; i++) {
            colorOrder[i] = (int)(Math.random()*4) + 1;
        }
    }

    public boolean compareColor(int i){
        for (int j = 0; j < i; j++) {
            if (colorOrder[i] != colorAnswer[i]){
                return false;
            }
        }
        return true;
    }

    public void resetArrays(){
        for (int i = 0; i < colorOrder.length; i++) {
            colorOrder[i] = 0;
            colorAnswer[i] = 0;
        }
    }


}
