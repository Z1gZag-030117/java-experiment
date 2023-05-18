/**
 * @author Öì†´
 * @version 1.0
 */
public class Line {

    InputScore inputScore;
    DelScore delScore;
    ComputerAver computerAver;

    public Line() {
        computerAver = new ComputerAver();
        delScore = new DelScore(computerAver);
        inputScore = new InputScore(delScore);
    }

    public void givePersonScore(){
        inputScore.inputScore();
    }


}
