package convertor;

import player.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shmilyhoney
 * Date: 13-2-23
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class StringConvert {
    public Integer convertFunds(String s) {
        int funds;
        try{
            funds = Integer.parseInt(s);
        } catch (Exception e) {
            throw new InvalidParameterException("Should be a number");
        }
        if(funds>50000){
            throw  new InvalidParameterException("Should not exceed the maximum");
        }  else if(funds<1000)  {
            throw  new InvalidParameterException("Should not under the minimum");
        }

        return funds;
    }

    public List<Player> convertPlayers(String playersInformation) {
        List<Player>   players=new ArrayList<Player>() ;
        if(playersInformation.length()<2) {
            throw new InvalidParameterException("players number should be over 2");
        } else if(playersInformation.length()>4){
            throw new InvalidParameterException("players number should be under 5");
        }
        if(hasRepeatPlayersType(playersInformation)) {
            throw new InvalidParameterException("players number should not be repeat");
        }
        for(int i=0;i<playersInformation.length();i++) {
            char playerType=playersInformation.charAt(i);
            switch(playerType) {
            case'1': players.add(new QianfurenPlayer());  break;
            case'2': players.add(new ATuBoPlayer());  break;
            case'3': players.add(new SunMeiMeiPlayer());  break;
            case'4': players.add(new JinBaoBeiPlayer());  break;
            default:throw  new InvalidParameterException("play type should be 1 or 2 or 3 or 4");
            }
        }
        return players;
    }

    private boolean hasRepeatPlayersType(String playersInformation) {
            char[]  playTypes= playersInformation.toCharArray();
            HashMap  playTypeInformation=new HashMap();
            for(int i=0;i<playersInformation.length();i++){
                 if(playTypeInformation.containsKey(playTypes[i])){
                    return true;
                 } else {
                     playTypeInformation.put(playTypes[i],1);
                 }
            }
            return false;
    }
}
