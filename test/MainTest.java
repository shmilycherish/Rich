import Game.RichGame;
import Game.RichPreparation;
import Game.UserInput;
import RollAct.RollAction;
import org.mockito.Mockito;
import player.Player;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-26
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {
    public static void main(String[] args){
         UserInput userInput=new UserInput();
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        RichGame richGame=richPreparation.getRichGame();
        Player player= richGame.getPlayers().get(2) ;
        player.setLocaion(32);
       RollAction rollAction=new RollAction(player,richGame,userInput);
        rollAction.executeRoll(3);

    }
}
