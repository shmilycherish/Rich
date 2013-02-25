import Game.Ground;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 2/20/13
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroundTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldGetTrue()
    {
         Ground ground=new Ground();
         ground.setOwners("Q");
         assertTrue(ground.isOwnerOfThePlayer("Q")) ;
    }
}
