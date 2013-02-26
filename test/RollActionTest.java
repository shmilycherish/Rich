import Game.RichGame;
import Game.RichPreparation;
import Game.UserInput;
import RollAct.RollAction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import player.Player;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-26
 * Time: 上午5:37
 * To change this template use File | Settings | File Templates.
 */
public class RollActionTest {
    Player player;
    RichGame richGame ;
    RollAction rollAction;
    @Before
    public void setUp()  {
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("10000").thenReturn("2134");
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        richGame=richPreparation.getRichGame();
        player= richGame.getPlayers().get(2) ;
        rollAction=new RollAction(player,richGame,userInput);
        richGame.getGameMap().getGroundList().get(13).setOwners("S");
        richGame.getGameMap().getGroundList().get(13).setGroundType(2);
    }

    public void setUp(String s)  {
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("10000").thenReturn("2134").thenReturn(s);
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        richGame=richPreparation.getRichGame();
        player= richGame.getPlayers().get(2) ;
        rollAction=new RollAction(player,richGame,userInput);
        richGame.getGameMap().getGroundList().get(13).setOwners("S");
        richGame.getGameMap().getGroundList().get(13).setGroundType(2);
    }

    @Test
    public void shouldMeetTheBlockAndBuyArea (){
        setUp("y");
        HashMap props=new HashMap();
        props.put(2,"BLOCK");
        richGame.setProps(props);
        rollAction.executeRoll(3);
       assertThat(rollAction.getPlayer().getLocaion(),is(2));
       assertFalse(rollAction.getRichGame().getProps().containsValue(2));
       assertThat(player.getFunds(),is(9800));
        assertThat(rollAction.getRichGame().getGameMap().getGroundList().get(2).getOwners(),is("S"));
    }

    @Test
    public void shouldMeetTheBlockAndNotBuyArea (){
        setUp("n");
        HashMap props=new HashMap();
        props.put(2,"BLOCK");
        richGame.setProps(props);
        rollAction.executeRoll(3);
        assertThat(rollAction.getPlayer().getLocaion(),is(2));
        assertFalse(rollAction.getRichGame().getProps().containsValue(2));
        assertThat(player.getFunds(),is(10000));
    }
    @Test
    public void shouldMeetTheBomb (){

        HashMap props=new HashMap();
        props.put(4,"BOMB");
        richGame.setProps(props);
        rollAction.executeRoll(4);
        assertThat(rollAction.getPlayer().getLocaion(),is(14));
        assertThat(rollAction.getPlayer().getHospitalOrPrison(),is(1));
        assertThat(rollAction.getPlayer().getLeftDays(),is(3));
    }

    @Test
    public void shouldMeetNoPropWhenGotoASpace (){
        setUp("y");
        HashMap props=new HashMap();

        rollAction.executeRoll(4);
        assertThat(rollAction.getPlayer().getLocaion(),is(4));
        assertThat(rollAction.getPlayer().getFunds(),is(9800));
        assertThat(rollAction.getRichGame().getGameMap().getGroundList().get(4).getOwners(),is("S"));
    }

    @Test
     public void shouldMeetNoPropWhenGotoAAreaisType2OfThePlayer (){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("10000").thenReturn("2134").thenReturn("y");
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        richGame=richPreparation.getRichGame();
        player= richGame.getPlayers().get(2) ;
        player.setLocaion(29);
        rollAction=new RollAction(player,richGame,userInput);
        richGame.getGameMap().getGroundList().get(31).setOwners("S");
        richGame.getGameMap().getGroundList().get(31).setGroundType(2);;
        HashMap props=new HashMap();

        rollAction.executeRoll(2);
        assertThat(rollAction.getPlayer().getLocaion(),is(31));
        assertThat(rollAction.getPlayer().getFunds(),is(9500));
        assertThat(rollAction.getRichGame().getGameMap().getGroundList().get(31).getOwners(),is("S"));
        assertThat(rollAction.getRichGame().getGameMap().getGroundList().get(31).getGroundType(),is(3));
    }

    @Test
    public void shouldMeetNoPropWhenGotoAreaisAnotherPlayer (){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("10000").thenReturn("2134");
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        richGame=richPreparation.getRichGame();
        player= richGame.getPlayers().get(2) ;
        player.setLocaion(41);
        rollAction=new RollAction(player,richGame,userInput);
        richGame.getGameMap().getGroundList().get(44).setOwners("J");
        richGame.getGameMap().getGroundList().get(44).setGroundType(1);;
        HashMap props=new HashMap();

        rollAction.executeRoll(3);
        assertThat(rollAction.getPlayer().getLocaion(),is(44));
        assertThat(rollAction.getPlayer().getFunds(),is(9700));
    }
    @Test
    public void shouldMeetNoPropWhenGotoAreaisAnotherPlayerButHaveMascot (){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("10000").thenReturn("2134");
        RichPreparation richPreparation=new RichPreparation(userInput);;
        richPreparation.prepareRichGame();
        richGame=richPreparation.getRichGame();
        player= richGame.getPlayers().get(2) ;
        player.setLocaion(41);
        player.setMascotLeftDays(5);
        rollAction=new RollAction(player,richGame,userInput);
        richGame.getGameMap().getGroundList().get(44).setOwners("J");
        richGame.getGameMap().getGroundList().get(44).setGroundType(1);;
        HashMap props=new HashMap();

        rollAction.executeRoll(3);
        assertThat(rollAction.getPlayer().getLocaion(),is(44));
        assertThat(rollAction.getPlayer().getFunds(),is(10000));
    }
}
