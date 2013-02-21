import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import java.util.*;
//TODO what's this test used for?
public class RichTest {

	@Test
	public void shouldstartGame(){
		StartRich startRich=new StartRich();
		startRich.query(new GamePlayer("1",15000));
	}
    @Test
    public void shouldInitialFundsRightUsingUserInput(){
        StartRich startRich=new StartRich();
        Iterator<String> scanner = Mockito.mock(Iterator.class);
        Mockito.when(scanner.next()).thenReturn("14000");
        int funds=startRich.setInitialFunds(scanner);
        assertThat(funds,is(14000));
    }

    @Test
    public void shouldInitialGamePlayersTypesRightUsingUserInput(){
        StartRich startRich=new StartRich();
        Iterator<String> scanner = Mockito.mock(Iterator.class);
        Mockito.when(scanner.next()).thenReturn("1234");
        String gamePlayersTypes=startRich.getGamePlayers(scanner);
        assertThat(gamePlayersTypes,is("1234"));
    }
    
    @Test
    public void shouldInitialPlayersRightWhenFundsIs15000AndGamePlayersTypes1234(){
    	StartRich startRich=new StartRich();
    	HashMap gamePlayers=startRich.InitialPlayers(15000,"1234");
        assertThat((GamePlayer)gamePlayers.get("1"),isGamePlayerAs("Q",15000,"1"));
        assertThat((GamePlayer)gamePlayers.get("2"),isGamePlayerAs("A",15000,"2"));
        assertThat((GamePlayer)gamePlayers.get("3"),isGamePlayerAs("S",15000,"3"));
        assertThat((GamePlayer)gamePlayers.get("4"),isGamePlayerAs("J",15000,"4"));
    }
    
    private Matcher<? super GamePlayer> isGamePlayerAs(final String display, final int funds, final String charactersType) {
        return new TypeSafeMatcher<GamePlayer>() {
            @Override
            protected boolean matchesSafely(GamePlayer gamePlayer) {
                return gamePlayer.display.equals(display) && (gamePlayer.funds==funds) && gamePlayer.charactersType.equals(charactersType);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    @Test
	public void shouldstatrMap(){
		GameMap maps=new GameMap();
		maps.initalizeMap();
		maps.printMap();
	}
	
	@Test
	public void shouldbombisexplodewhenplayer(){
		StartRich startRich=new StartRich();
		startRich.stageProperties.put(2, "bomb");
		startRich.stageProperties.put(10, "bomb");
		startRich.stageProperties.put(11, "bomb");
		startRich.stageProperties.put(7, "block");
		int i=startRich.checkStageProperties(1, 2);
		int j=startRich.checkStageProperties(5,4);
		int k=startRich.checkStageProperties(5,5);
		int m=startRich.checkStageProperties(69,6);
		int n=startRich.checkStageProperties(67,3);
		assertThat(i,is(2));
		assertThat(j,is(7));
		assertThat(k,is(7));
		assertThat(m,is(2));
		assertThat(n,is(-1));
	}
	
	@Test
	public void buyestateOperationTest(){
		
	}
}
