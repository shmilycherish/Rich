import Game.GamePlayer;
import Game.Rich;
import Game.StartRich;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-26
 * Time: 上午4:24
 * To change this template use File | Settings | File Templates.
 */
public class RichTest {
    @Test
    public void shouldstartGame(){
         Rich rich=new Rich();
        rich.startRichGame();
    }
}
