import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GamePlayerTest {
    @Test
    public void shouldInitialPlayerRight(){
       GamePlayer gamePlayer=new GamePlayer("1",10000);
       assertThat(gamePlayer.getCharactersType(), is("1"));
       assertThat(gamePlayer.getCharactersName(), is("钱夫人"));
       assertThat(gamePlayer.getDisplay(), is("Q"));
       assertThat(gamePlayer.getFunds(), is(10000));
    }

    @Test
    public void shouldGetTheDiceResultBetween1And6(){
        GamePlayer gamePlayer=new GamePlayer("1",10000);
        int diceResult1=gamePlayer.dice();
        int diceResult2=gamePlayer.dice();
        assertTrue(isBetween1And6(diceResult1));
        assertTrue(isBetween1And6(diceResult2));
    }
    private  boolean isBetween1And6(int diceResult){
         return  diceResult>=1&&diceResult<=6;
    }

    @Test
    public void shouldPlayerGoToTheRightLocationAfterDiceWhenPlayerNotWalkBeyondMapLimition(){
        GamePlayer gamePlayer=new GamePlayer("1",10000);
        gamePlayer.setLocation(10);        
        int goFoward3Steps=3;      
        gamePlayer.goFoward(goFoward3Steps);
        GamePlayer aotherGamePlayer=new GamePlayer("1",10000);
        aotherGamePlayer.setLocation(68);
        
        assertThat(gamePlayer.getLocation(), is(13));
        
    }
    @Test
    public void shouldPlayerGoToTheRightLocationAfterDiceWhenPlayerWalkOutOfMap(){
        GamePlayer gamePlayer=new GamePlayer("1",10000);
        gamePlayer.setLocation(68);        
        int goFoward3Steps=3;      
        gamePlayer.goFoward(goFoward3Steps);
        assertThat(gamePlayer.getLocation(), is(1));
    }
    
}