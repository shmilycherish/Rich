package RollAct;

import Game.GameMessage;
import Game.Ground;
import Game.RichGame;
import Game.UserInput;
import player.Player;

import java.security.InvalidParameterException;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-26
 * Time: 上午2:39
 * To change this template use File | Settings | File Templates.
 */
public class RollAction {
    private Player player;
    private RichGame richGame ;
    private UserInput userInput;
    public RollAction(Player player,RichGame richGame,UserInput userInput){
        this.player=player;
        this.richGame=richGame;
        this.userInput=userInput;
    }
    public Player getPlayer(){
        return player;
    }

    public RichGame getRichGame(){
        return richGame;
    }

    public void executeRoll(int rollResult){
        int propFirstMeet=meetPropLocation(rollResult);
        if(propFirstMeet>0){
            propAction(propFirstMeet) ;
        }  else{
            player.setLocaion(player.getLocaion()+rollResult);
        }
        groundAction() ;
    }

    private void groundAction() {
        switch(player.getLocaion()){
            case 0:break;
            case 14:player.getIntoHospital();break;
            case 28:buyPropHouse();break;
            case 35:chooseGiftHouse();break;
            case 49:player.getIntoPrisson();break;
            case 63:useMagic();break;
            default:otherLocationPerformance(player.getLocaion());
        }
    }

    private void otherLocationPerformance(int location) {
        if(isPointsArea(location)) {
            player.setPoints(player.getPoints()+richGame.getGameMap().getGroundList().get(location).getPoint());
        } else{
            estateOperation(location);
        }
    }

    private void estateOperation(int location) {
        Ground ground=richGame.getGameMap().getGroundList().get(location);
        if(ground.getOwners().equals("0")){
            System.out.println("是否购买该处空地，"+ground.getPrice()+"元（Y/N）?");
            String result=getResult();
            if(result.equals("y")&&player.getFunds()>=ground.getPrice()) {
                richGame.getGameMap().getGroundList().get(location).setOwners(player.getDisplayName());
                player.setFunds(player.getFunds()-ground.getPrice());
                player.getLandedProperty()[0]+=1;
            } else if(player.getFunds()<ground.getPrice()){
                System.out.println("资金不足");
            }
        } else if(ground.getOwners().equals(player.getDisplayName())) {
            if( richGame.getGameMap().getGroundList().get(location).getGroundType()<3){
                System.out.println("是否升级该处地产，"+ground.getPrice()+"元（Y/N）?");
                String result=getResult();
                if(result.equals("y")&&player.getFunds()>=ground.getPrice()) {
                    richGame.getGameMap().getGroundList().get(location).setGroundType(ground.getGroundType()+1);
                    player.setFunds(player.getFunds()-ground.getPrice());
                    player.getLandedProperty()[ground.getGroundType()-1]-=1;
                    player.getLandedProperty()[ground.getGroundType()]+=1;
                } else if(player.getFunds()<ground.getPrice()){
                    System.out.println("资金不足");
                }
            }
        }   else{
            int i=findTheAreaOwner(ground.getOwners()) ;
            if(player.getMascotLeftDays()>0){
                System.out.println("福神在身，免收过路费");
            }  else if(richGame.getPlayers().get(i).getHospitalOrPrison()>0){
                System.out.println("主人不在，免收过路费");
            } else{
                int times=(int)Math.pow(2,ground.getGroundType());
                int tolls=(ground.getPrice()/2) *times ;
                if(player.getFunds()<tolls) {
                      player.setBankrupt(true);
                }   else{
                    player.setFunds(player.getFunds()-tolls);
                    richGame.getPlayers().get(i).setFunds( richGame.getPlayers().get(i).getFunds()+tolls);
                }
            }
        }
    }

    private int findTheAreaOwner(String owners) {
        for(int i=0;i<richGame.getPlayerCount();i++){
            if(richGame.getPlayers().get(i).getDisplayName().equals(owners)){
               return   i;
            }
        }
        return 0;
    }


    private String getResult() {
        String result="";
        while (!(result.equals("y")||result.equals("n"))) {
            result=userInput.readUserInput();
            result.toLowerCase();
        }
        return result;
    }

    private boolean isPointsArea(int location) {
        return location>63&&location<=69;
    }


    private void buyPropHouse() {
        GameMessage gameMessage=new GameMessage();
        gameMessage.propHouseWelcomeMessage();
        int toolType=choose() ;
        if(player.getPoints()<30) {
            return;
        } else{
            int giftType=-1 ;
            while(giftType!=0) {
                try{
                    giftType=choose();
                } catch(InvalidParameterException e) {
                    userInput.printMessage(e.getMessage());
                }
                ToolAction(giftType);
            }
        }
    }

    private void ToolAction(int giftType) {
         if(player.propBoxIsHaveSpace()) {
             switch(giftType) {
                 case 0:break;
                 case 1:buyBlock();break;
                 case 2:buyRobot();break;
                 case 3:buyBomb();break;
             }
         }   else{
             System.out.println("prop box is full");
         }

    }

    private void buyBomb() {
        if(player.getPoints()>=50) {
            player.getProps()[2]+=1;
            player.setPoints(player.getPoints()-50);
        }  else{
            System.out.println("points is too little");
        }
    }

    private void buyRobot() {
        if(player.getPoints()>=30) {
            player.getProps()[1]+=1;
            player.setPoints(player.getPoints()-30);
        }  else{
            System.out.println("points is too little");
        }
    }

    private void buyBlock() {
        if(player.getPoints()>=50) {
            player.getProps()[0]+=1;
            player.setPoints(player.getPoints()-50);
        }  else{
            System.out.println("points is too little");
        }
    }

    private void chooseGiftHouse() {
       GameMessage gameMessage=new GameMessage();
       gameMessage.GiftHouseWelcomeMessage();
        int giftType=0;
        try{
           giftType=choose();
        } catch(InvalidParameterException e) {
        }
        GiftAction(giftType);
   }

    private void GiftAction(int giftType) {
        switch(giftType) {
            case 0: break;
            case 1:player.setFunds(player.getFunds()+2000);break;
            case 2:player.setPoints(player.getPoints()+200);break;
            case 3:player.setMascotLeftDays(5);break;
        }
    }

    private int choose() {
       String gift= userInput.readUserInput() ;
       int giftType=0;
       if(gift.equals("F")) {
             return giftType;
       }else{
            try{
                giftType=Integer.parseInt(userInput.readUserInput());
            } catch(Exception e)  {
                throw new InvalidParameterException("prop type should be 1 or 2 or 3");
            }
       }
       return   giftType;
    }

    private void useMagic() {

    }

    private void propAction(int propFirstMeet) {
       String propName= (String)richGame.getProps().get(propFirstMeet);
       if(propName.equals("BOMB")){
              bombAction();
       } else if(propName.equals("BLOCK")) {
              blockAction(propFirstMeet);
       }
    }

    private void blockAction(int propFirstMeet) {
        player.stopInBlock(propFirstMeet) ;
    }

    private void bombAction() {
        player.setLocaion(14);
    }

    private int meetPropLocation(int rollResult) {
        int CheckLocation=(player.getLocaion()+1)%70;
        int propLocation=-1;
        while(rollResult>0){
            if(richGame.getProps().containsKey(CheckLocation)){
                propLocation=CheckLocation;
                return propLocation;
            }
            CheckLocation++;
            rollResult--;
        }
        return propLocation;
}
}
