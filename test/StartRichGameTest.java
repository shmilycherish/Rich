import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-21
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
public class StartRichGameTest {
     @Test
    public void shouldInitialFundsRightUsingUserInput(){
        StartRichGame startRichGame=new StartRichGame();
        startRichGame.setFunds(14000);
        assertThat(startRichGame.getFunds(), is(14000));
    }

    @Test
    public void shouldGet14000WhenUserInputIis14000t(){
        StartRichGame startRichGame=new StartRichGame();
        startRichGame.getUserInuptFunds();
        assertThat(startRichGame.getUserInuptFunds(), is(14000));
    }
}
