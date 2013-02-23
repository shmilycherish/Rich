package convertor;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import player.*;

import java.security.InvalidParameterException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: shmilyhoney
 * Date: 13-2-23
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class StringConvertTest {

    @Test
    public void shouldGetFundsInformation()
    {
        StringConvert stringConvert = new StringConvert();

        assertThat(stringConvert.convertFunds("10000"), is(10000));
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldGetExceptionInformationWhenConvertFunds()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertFunds("1000s");
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldGetExceptionInformationWhenFundsExceedMaximum()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertFunds("60000");
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldGetExceptionInformationWhenFundsUnderMinimum()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertFunds("900");
    }

    @Test
    public void shouldGetPlayersInformation()
    {
        StringConvert stringConvert = new StringConvert();
        List<Player> players = stringConvert.convertPlayers("1234");
        assertThat(players.size(), is(4));

        assertThat(players.get(0), isQianfuren());
        assertThat(players.get(1), isAtubo());
        assertThat(players.get(2), isSunmeimei());
        assertThat(players.get(3), isJinbaobei());
    }

    @Test  (expected = InvalidParameterException.class)
    public void shouldGetExceptionWhenContainsInvalidChars()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertPlayers("d234");
    }

    @Test  (expected = InvalidParameterException.class)
    public void shouldGetExceptionWhenStringLessThan2Chars()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertPlayers("1");
    }

    @Test  (expected = InvalidParameterException.class)
    public void shouldGetExceptionWhenStringMoreThan4Chars()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertPlayers("12342");
    }

    @Test  (expected = InvalidParameterException.class)
    public void shouldGetExceptionWhenStringContainsDuplicatedChars()
    {
        StringConvert stringConvert = new StringConvert();
        stringConvert.convertPlayers("11");
    }

    private Matcher<Player> isJinbaobei() {
        return new TypeSafeMatcher<Player>() {
            @Override
            protected boolean matchesSafely(Player player) {
                return (player instanceof JinBaoBeiPlayer);
            }

            @Override
            public void describeTo(Description description) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    private Matcher<Player> isSunmeimei() {
        return new TypeSafeMatcher<Player>() {
            @Override
            protected boolean matchesSafely(Player player) {
                return (player instanceof SunMeiMeiPlayer);
            }

            @Override
            public void describeTo(Description description) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    private Matcher<Player> isAtubo() {

        return new TypeSafeMatcher<Player>() {
            @Override
            protected boolean matchesSafely(Player player) {
                return (player instanceof ATuBoPlayer);
            }

            @Override
            public void describeTo(Description description) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    private Matcher<Player> isQianfuren() {
        return new TypeSafeMatcher<Player>() {
            @Override
            protected boolean matchesSafely(Player player) {
                return (player instanceof QianfurenPlayer);
            }

            @Override
            public void describeTo(Description description) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    @Test
    public void shouldGetRightCommand(){

    }
}
