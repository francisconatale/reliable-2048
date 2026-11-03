package ar.edu.unrc.game2048;

public class Score {
    int score;
    public Score(int value){
        if(value < 0) { 
            throw new IllegalArgumentException("The score cannot be less 0");
        }
        this.score = value;
    }

    public void increaseScore(int value){ score += value; }
    public void setScore(int value){ score = value; }
    public int getScore(){ return score; }
}
