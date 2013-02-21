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
        Iterator<String> scanner = Mockito.mock(Iterator.class);
        Mockito.when(scanner.next()).thenReturn("14000");
        int funds=startRichGame.setInitialFunds(scanner);
        assertThat(funds,is(14000));
    }
}
