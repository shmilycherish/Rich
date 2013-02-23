import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class RichPreparationTest {
    @Test
    public void shouldFundsPreparedBeforeGoingToChoosePlayers(){
        RichPreparation richPreparation=new RichPreparation();
        Iterator<String> scanner = Mockito.mock(Iterator.class);
        Mockito.when(scanner.next()).thenReturn("15000");
         richPreparation.preparedFunds(scanner);
        assertThat(richPreparation.richGame.getFunds(), is(15000)) ;
    }
}
