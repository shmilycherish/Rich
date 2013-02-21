import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 2/21/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RichGameTest {

    @Test
    public void shouldGetInitStatus()
    {
        RichGame richGame = new RichGame();
        RichGameStatus status = richGame.getStatus();

        MatcherAssert.assertThat(RichGameStatus.WaitingInput, is(RichGameStatus.WaitingInput));
    }
}
