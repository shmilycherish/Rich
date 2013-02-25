package Game;

import Game.RichGame;
import Game.RichPreparation;
import Game.UserInput;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-24
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class Rich {
    private RichPreparation richPreparation=new RichPreparation(new UserInput())  ;
    RichGame richGame;
    public void startRichGame() {
        richPreparation.prepareRichGame();
        richGame=  richPreparation.getRichGame();
    }

}
