import convertor.StringConvert;
import player.Player;
import sun.rmi.runtime.NewThreadAction;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class RichPreparation {
    private RichGame richGame=new RichGame();

    private StringConvert stringConvert;
    private UserInput userInput;

    public RichPreparation(UserInput userInput)
    {
              this.userInput = userInput;
              stringConvert=new StringConvert();
    }
     public void prepareRichGame(){
         prepareInteractiveData();
         prepareGameMap();
         prepareProps();
     }

    private void prepareProps() {
        richGame.setProps(new HashMap());
    }

    private void prepareGameMap() {
        richGame.setGameMap(new GameMap());
    }

    public void prepareInteractiveData()
    {
        initFunds();
        List<Player> playerList = initPlayers(richGame.getFunds());
    }

    private List<Player> initPlayers(int funds) {
        List<Player> players=new ArrayList<Player>();
        while(players.isEmpty()) {
             try{
                 players= stringConvert.convertPlayers(userInput.readUserInput()) ;
             } catch (Exception e)  {
                 userInput.printMessage(e.getMessage());
             }
        }
        richGame.initialPlayers(players);
        return players;
    }

    private void initFunds() {
        int funds = 0;
        while(funds == 0) {
             try{
                 funds= stringConvert.convertFunds(userInput.readUserInput()) ;
             }  catch (Exception e) {
                 userInput.printMessage(e.getMessage());
             }
        }

        richGame.setFunds(funds);
    }

    public RichGame getRichGame() {
        return richGame;  //To change body of created methods use File | Settings | File Templates.
    }
}
