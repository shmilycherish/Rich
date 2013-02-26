package Game;

import Command.CommandException;
import Command.CommandOperation;
import Game.RichGame;
import Game.RichPreparation;
import Game.UserInput;
import RichMap.Ground;
import RichMap.GroundFactory;
import player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-24
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class Rich {
    private RichPreparation richPreparation=new RichPreparation(new UserInput())  ;
    private UserInput userInput=new UserInput();
    RichGame richGame;
    int start=0;
    Player player;
    public void startRichGame() {
        richPreparation.prepareRichGame();
        richGame=  richPreparation.getRichGame();
    }
    public void riching() {

        while(richGame.getPlayerCount()>=2) {
            start= start%richGame.getPlayerCount() ;
            player= richGame.getPlayers().get(start) ;
            CommandOperation  commandOperation =new CommandOperation(player,richGame);
            APlayerRound  APlayerRound=new  APlayerRound(commandOperation);
            if(player.getLeftDays()==0){
                 while(APlayerRound.isGoing()){
                     try{
                        APlayerRound.receiveCommand(userInput);
                     }catch(CommandException e){
                         userInput.printMessage(e.getMessage());
                     }
                 }
                richGame =  commandOperation.getRichGame();
                if(richGame.isExitGameFlag()){
                    System.exit(0);
                }
                player= commandOperation.getPlayer();

                richGame.initialPlayers(putPlayer(start, player));
                if(player.getBankrupt()){
                    richGame.refreshMap(player.getDisplayName());
                    start--;
                }
             }  else{
                String message=commandOperation.getPlayer().getCharacterName()+"> 休息中" ;
                SetColor.printColorStringln(message, Color.GRAY);
                player.statusRefresh();
                richGame.initialPlayers(putPlayer(start, player));
            }

            changeMapDisplay();
            richGame.getGameMap().printMap();
            start++;
        }
        SetColor.printline("游戏结束");
    }



    private List<Player> putPlayer(int start, Player player) {

        List<Player> players=new ArrayList<Player>();
            for(int i=0;i<richGame.getPlayerCount();i++) {
                 if(i!=start){
                     players.add(i,richGame.getPlayers().get(i) );
                 } else{
                     if(!player.getBankrupt()){
                         players.add(i,player);
                     }
                 }
            }
         return players;
    }

    public void changeMapDisplay(){
        for(int i=0;i<64;i++) {
            richGame.getGameMap().getGroundList().get(i).setDisplay(String.valueOf(richGame.getGameMap().getGroundList().get(i).getGroundType()));
        }
            richGame.getGameMap().getGroundList().get(0).setDisplay("S");
            richGame.getGameMap().getGroundList().get(14).setDisplay("H");
            richGame.getGameMap().getGroundList().get(28).setDisplay("T");
            richGame.getGameMap().getGroundList().get(35).setDisplay("G");
            richGame.getGameMap().getGroundList().get(49).setDisplay("P");
            richGame.getGameMap().getGroundList().get(63).setDisplay("M");
        for(int i=64;i<70;i++) {
            richGame.getGameMap().getGroundList().get(i).setDisplay("$");
        }
            for(int i=0;i<70;i++) {
            if(richGame.getProps().containsKey(i)) {
                if(richGame.getProps().get(i).equals("BLOCK")) {
                    richGame.getGameMap().getGroundList().get(i).setDisplay("#");
                }  else if(richGame.getProps().get(i).equals("BOMB"))  {
                    richGame.getGameMap().getGroundList().get(i).setDisplay("@");
                }
            }
        }
        for(int i=0;i<richGame.getPlayerCount();i++) {
            richGame.getGameMap().getGroundList().get(richGame.getPlayers().get(i).getLocaion()).setDisplay(richGame.getPlayers().get(i).getDisplayName());
        }
    }
}
