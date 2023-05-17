/**
 * @author Öì†´
 * @version 1.0
 */
public class Line {

    InputScore one;
    DelScore two;
    ComputerAver three;

    public Line() {
        three = new ComputerAver();
        two = new DelScore(three);
        one = new InputScore(two);
    }
    public void givePersonScore(){
        one.inputScore();
    }


}
