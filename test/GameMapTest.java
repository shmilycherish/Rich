import junit.framework.Assert;
import org.hamcrest.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GameMapTest {

    private GameMap gameMap;

    @Before
    public void setUp() throws Exception {

        gameMap = new GameMap();
    }

    @Test
    public void shouldInitialRightMap()
    {
        List<Ground> grounds = gameMap.initalizeMap();

        assertThat(grounds.size(), is(70));
        assertThat(grounds.get(0), isGroundAs("S"));
    }

    private Matcher<? super Ground> isGroundAs(final String s) {
        return new TypeSafeMatcher<Ground>() {
            @Override
            protected boolean matchesSafely(Ground ground) {
                return ground.getDisplay().equals(s);
            }

            @Override
            public void describeTo(Description description) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}
