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
        assertThat(grounds.get(1), isGroundAs("0"));
        assertThat(grounds.get(13), isGroundAs("0"));
        assertThat(grounds.get(14), isGroundAs("H"));
        assertThat(grounds.get(15), isGroundAs("0"));
        assertThat(grounds.get(27), isGroundAs("0"));
        assertThat(grounds.get(28), isGroundAs("T"));
        assertThat(grounds.get(29), isGroundAs("0"));
        assertThat(grounds.get(34), isGroundAs("0"));
        assertThat(grounds.get(35), isGroundAs("G"));
        assertThat(grounds.get(36), isGroundAs("0"));
        assertThat(grounds.get(48), isGroundAs("0"));
        assertThat(grounds.get(49), isGroundAs("P"));
        assertThat(grounds.get(50), isGroundAs("0"));
        assertThat(grounds.get(62), isGroundAs("0"));
        assertThat(grounds.get(63), isGroundAs("M"));
        assertThat(grounds.get(64), isGroundAs("$"));
        assertThat(grounds.get(69), isGroundAs("$"));
    }

    private Matcher<? super Ground> isGroundAs(final String s) {
        return new TypeSafeMatcher<Ground>() {
            @Override
            protected boolean matchesSafely(Ground ground) {
                return ground.getDisplay().equals(s);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }
}
