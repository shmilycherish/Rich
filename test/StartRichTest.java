import Game.GamePlayer;
import Game.StartRich;
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
public class StartRichTest {

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
                return gamePlayer.getDisplay().equals(display) && (gamePlayer.funds==funds) && gamePlayer.getCharactersType().equals(charactersType);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    @Test
    public void shouldGetTheRightRandomNumberWhenRoll(){
        StartRich startRich=new StartRich();
        int result=startRich.roll();
        boolean rollRight=false;
        if(result>=1&&result<=6)
        	rollRight=true;
        assertTrue(rollRight);
    }
    
    @Test
	public void shouldGetRightResultWhenCheckStageProperties(){
    	StartRich startRich=new StartRich();
    	startRich.stageProperties.put(2,"bomb");
    	startRich.stageProperties.put(3, "block");
    	startRich.stageProperties.put(9,"block");
    	int checkStagePropertiesResult1=startRich.checkStageProperties(0, 4);
    	int checkStagePropertiesResult2=startRich.checkStageProperties(3, 6);
    	int checkStagePropertiesResult3=startRich.checkStageProperties(3,3);
    	assertThat(checkStagePropertiesResult1,is(2));
    	assertThat(checkStagePropertiesResult2,is(9));
    	assertThat(checkStagePropertiesResult3,is(-1));
    }
    
    @Test
   	public void shouldGetRightResultWhenMeetProp(){
       	StartRich startRich=new StartRich();
       	startRich.stageProperties.put(2,"bomb");
       	startRich.stageProperties.put(3, "block");
       	startRich.stageProperties.put(9,"block");
       	GamePlayer gamePlayer=new GamePlayer("1",10000);
       	gamePlayer.setLocation(0);
       	GamePlayer gamePlayer1=new GamePlayer("1",10000);
       	gamePlayer1.setLocation(0);
       	startRich.executeRoll(gamePlayer, 4);
    	startRich.executeRoll(gamePlayer1, 4);
       	assertThat(gamePlayer,GamePlayerAttriAs(1,3,14));
       	assertThat(startRich.gameMap.getGroundList().get(14).getDisplay(),is("Q"));
       	assertThat(gamePlayer1,GamePlayerAttriAs(0,0,3));
       	assertThat(startRich.gameMap.getGroundList().get(3).getDisplay(),is("Q"));
       }
    
    private Matcher<? super GamePlayer> GamePlayerAttriAs(final int status, final int leftdays, final int location) {
        return new TypeSafeMatcher<GamePlayer>() {
            @Override
            protected boolean matchesSafely(GamePlayer gamePlayer) {
                return (gamePlayer.status==status) && (gamePlayer.leftdays==leftdays) && (gamePlayer.getLocation()==location);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }
    
    @Test
	public void shouldGetRightResultWhenPlayWalkToHospital(){
    	StartRich startRich=new StartRich();
    	GamePlayer gamePlayer=new GamePlayer("1",10000);
       	gamePlayer.setLocation(9);
       	startRich.executeRoll(gamePlayer, 5);
       	assertThat(gamePlayer,GamePlayerAttriAs(1,3,14));
    	assertThat(startRich.gameMap.getGroundList().get(14).getDisplay(),is("Q"));
	}
	
    @Test
   	public void shouldGetRightResultWhenPlayWalkToGift(){
       	StartRich startRich=new StartRich();
       	GamePlayer gamePlayer=new GamePlayer("1",10000);
          	gamePlayer.setLocation(9);
          	startRich.executeRoll(gamePlayer, 5);
          	assertThat(gamePlayer,GamePlayerAttriAs(1,3,14));
   	}
	@Test
	public void buyestateOperationTest(){
		
	}
}
