package Command;

import Game.Ground;
import Game.GroundFactory;
import player.Player;
import Game.RichGame;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-25
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */
public class CommandOperation {
    private Player player;
    private RichGame richGame ;
    public CommandOperation(Player player,RichGame richGame){
       this.player=player;
       this.richGame=richGame;
    }
     public Player getPlayer(){
         return player;
     }

    public RichGame getRichGame(){
        return richGame;
    }

    public void query(){
        System.out.println("资 金:"+player.getFunds()+"元");
        System.out.println("点数:"+player.getPoints()+"点");
        System.out.print("地产:空地"+player.getLandedProperty()[0]+"处；");
        System.out.print("茅屋"+player.getLandedProperty()[1]+"处；");
        System.out.print("洋房"+player.getLandedProperty()[2]+"处；");
        System.out.println("摩天楼"+player.getLandedProperty()[3]+"处。");
        System.out.print("道具:路障"+player.getProps()[0]+"个；");
        System.out.print("炸弹"+player.getProps()[1]+"个；");
        System.out.println("机器娃娃"+player.getProps()[2]+"个。");
    }

    public void help(){
        System.out.println("命令一览表");
        System.out.println("掷骰子命令，行走1~6步。步数由随即算法产生。");
        System.out.println("block n     玩家拥有路障后，可将路障放置到离当前位置前后10步的距离，任一玩家经过路障，都将被拦截。该道具一次有效。n 前后的相对距离，负数表示后方。");
        System.out.println("bomb n    可将路障放置到离当前位置前后10步的距离，任一玩家j 经过在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方。");
        System.out.println("robot        使用该道具，可清扫前方路面上10步以内的其它道具，如炸弹、路障。");
        System.out.println("sell x        出售自己的房产，x 地图上的绝对位置，即地产的编号。");
        System.out.println("sellTool x  出售道具，x 道具编号");
        System.out.println("query        显示自家资产信息 ");
        System.out.println("help          查看命令帮助");
        System.out.println("quit           强制退出");
    }

    public void sell(int sellArg){
        Ground ground= richGame.getGameMap().getGroundList().get(sellArg) ;
        if(ground.getIsSystemLand()){
              throw new CommandException("Command Error,CANNOT sell system Land") ;
          }else if(ground.isOwnerOfThePlayer(player.getDisplayName())){
              sellLandedProperty(sellArg);
          }else{
              throw new CommandException("Command Error,CANNOT sell the  LandedProperty which is not yours") ;
          }
    }

    private void sellLandedProperty(int sellArg) {
        Ground ground = richGame.getGameMap().getGroundList().get(sellArg) ;
        int  landedPropertyValue=  (ground.getPrice()*(ground.getGroundType()+1))*2;
        player.setFunds( player.getFunds()+landedPropertyValue);
        Ground newGround= GroundFactory.buildEmptyGroundWithPrice(ground.getPrice());
        richGame.getGameMap().getGroundList().set(sellArg,newGround);
    }


     public void block(int blockDistance){
         int  blockLocation= calculatePropLocation(blockDistance) ;
         if(canPlaceProp(blockLocation,1))  {
             richGame.getProps().put(blockLocation,"BLOCK");
             player.getProps()[0]-=1;
         } else if(haveProps(blockLocation)||havePlayer(blockLocation)) {
              throw new CommandException("You CANNOT placed your prop there") ;
         }  else if(!player.haveProp(1)) {
             throw new CommandException("You have no block") ;
         }
     }
    private boolean  canPlaceProp(int Location,int propType) {
        return player.haveProp(propType)&&(!havePlayer(Location)) &&(!haveProps(Location));
    }

    private boolean havePlayer(int blockLocation) {
       for(int i=0;i<richGame.getPlayerCount();i++) {
           if(richGame.getPlayers().get(i).getLocaion()==blockLocation){
                 return true;
           }
       }
        return false;
    }

    private boolean haveProps(int blockLocation) {
         return richGame.getProps().containsKey(blockLocation);
    }

    public int calculatePropLocation(int blockDistance){
        int groundNumber= richGame.getGameMap().getGroundList().size();
        int  blockLocation= (player.getLocaion()  + blockDistance+ groundNumber)%groundNumber;
        return   blockLocation;
    }

    public void bomb(int bombDistance){
        int  bombLocation= calculatePropLocation(bombDistance) ;
        if(canPlaceProp(bombLocation,3))  {
            richGame.getProps().put(bombLocation,"BOMB");
            player.getProps()[2]-=1;
        } else if(haveProps(bombLocation)||havePlayer(bombLocation)) {
            throw new CommandException("You CANNOT placed your prop there") ;
        }  else if(!player.haveProp(3)) {
            throw new CommandException("You have no block") ;
        }
    }
}
