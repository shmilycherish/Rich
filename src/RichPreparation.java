import convertor.StringConvert;
import player.Player;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class RichPreparation {
    private RichGame richGame=new RichGame();
    public void preparedFunds(Iterator<String> scanner) {
        String userInput=scanner.next();
        StringConvert stringConvert=new StringConvert();
        int funds=stringConvert.convertFunds(userInput);
        richGame.setFunds(funds);
    }

    private StringConvert stringConvert;
    private UserInput userInput;

    public RichPreparation(UserInput userInput)
    {
              this.userInput = userInput;
              stringConvert=new StringConvert();
    }

    public void prepareInteractiveData()
    {
        initFunds();
        List<Player> playerList = initPlayers();
    }

    private List<Player> initPlayers() {

        return null;
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
