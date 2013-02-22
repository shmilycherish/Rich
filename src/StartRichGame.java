import java.util.HashMap;
import java.util.Iterator;


public class StartRichGame {

	private int funds;
	private String playersTypes;

	public Integer getFunds() {
		// TODO Auto-generated method stub
		return funds;
	}

	public void setFunds(int funds) {
		// TODO Auto-generated method stub
		this.funds=funds;
	}

	public void setPlayersTypes(String playersTypes) {
		// TODO Auto-generated method stub
		this.playersTypes=playersTypes;
	}

	public String getPlayersTypes() {
		// TODO Auto-generated method stub
		return playersTypes;
	}

	public HashMap InitialPlayers(int funds, String playersTypes) {
		// TODO Auto-generated method stub		
		HashMap gamePlayers=new HashMap();				
		GamePlayer gamePlayer;		
		for(int i=0;i<playersTypes.length();i++){			
			gamePlayer=new GamePlayer(playersTypes.substring(i, i+1),funds);			
			gamePlayers.put(playersTypes.substring(i, i+1), gamePlayer);
		}
		return gamePlayers;		
	}

}
