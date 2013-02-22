import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
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
    public void shouldInitialPlayersTypesUsingUserInput(){
        StartRichGame startRichGame=new StartRichGame();
        startRichGame.setPlayersTypes("1234");
        assertThat(startRichGame.getPlayersTypes(), is("1234"));
    }

    @Test
    public void shouldInitialPlayersUsingFundsAndPlayersTypes(){
        StartRichGame startRichGame=new StartRichGame();
        startRichGame.setFunds(15000);
        startRichGame.setPlayersTypes("1234");
        HashMap gamePlayers=startRichGame.InitialPlayers(startRichGame.getFunds(),startRichGame.getPlayersTypes());
        assertThat((GamePlayer)gamePlayers.get("1"),isGamePlayerAs("Q",15000,"1"));
        assertThat((GamePlayer)gamePlayers.get("2"),isGamePlayerAs("A",15000,"2"));
        assertThat((GamePlayer)gamePlayers.get("3"),isGamePlayerAs("S",15000,"3"));
        assertThat((GamePlayer)gamePlayers.get("4"),isGamePlayerAs("J",15000,"4"));
    }
    
    private Matcher<? super GamePlayer> isGamePlayerAs(final String display, final int funds, final String charactersType) {
        return new TypeSafeMatcher<GamePlayer>() {
            @Override
            protected boolean matchesSafely(GamePlayer gamePlayer) {
                return gamePlayer.getDisplay().equals(display) && (gamePlayer.funds==funds) && gamePlayer.getCharactersType().equals(charactersType);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }
}
