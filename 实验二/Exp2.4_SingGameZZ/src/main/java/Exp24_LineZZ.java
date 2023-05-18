/**
 * @author Öì†´
 * @version 1.0
 */
public class Exp24_LineZZ {

    Exp24_InputScoreZZ inputScore;
    Exp24_DelScoreZZ delScore;
    Exp24_ComputerAverZZ computerAver;

    public Exp24_LineZZ() {
        computerAver = new Exp24_ComputerAverZZ();
        delScore = new Exp24_DelScoreZZ(computerAver);
        inputScore = new Exp24_InputScoreZZ(delScore);
    }

    public void givePersonScore(){
        inputScore.inputScore();
    }


}
