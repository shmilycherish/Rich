package Game;

import Command.CommandInformation;
import Command.CommandOperation;
import Game.RichGame;
import convertor.StringConvert;
import player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-24
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class APlayerRound {
    private boolean isGoing= true;
    private CommandOperation commandOperation;
    StringConvert stringConvert =new StringConvert();
    UserInput userInput=new UserInput();
    public APlayerRound( CommandOperation  commandOperation ){
        this. commandOperation= commandOperation;
}
    public void receiveCommand(UserInput userInput){
        System.out.print(commandOperation.getPlayer().getCharacterName()+">");
        CommandInformation  commandInformation=new CommandInformation();
        int i=0;
        while(i==0) {
            try{
                i=1;
                String command= userInput.readUserInput();
                commandInformation=stringConvert.convertCommand(command) ;
            }catch(Exception e) {
                i=0 ;
                userInput.printMessage(e.getMessage());
                System.out.print(commandOperation.getPlayer().getCharacterName()+">");
            }
        }
        switch (commandInformation.getCommandType()) {
            case ROBOT:  commandOperation.robot(); break;
            case BOMB:   commandOperation.bomb(commandInformation.getArg());break;
            case BLOCK:  commandOperation.block(commandInformation.getArg());  break;
            case SELL:    commandOperation.sell(commandInformation.getArg()); break;
            case SELLTOOL: commandOperation.sellTool(commandInformation.getArg()); break;
            case QUERY:    commandOperation.query(); break;
            case HELP:    commandOperation.help(); break;
            case QUIT:     break;
            case ROLL:    commandOperation.roll();setGoing(false);break;
        }

    }

    public boolean isGoing() {
        return isGoing;
    }

    public void setGoing(boolean going) {
        isGoing = going;
    }

    public CommandOperation getCommandOperation() {
        return commandOperation;
    }
}
