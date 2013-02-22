import java.util.HashMap;


public class StartRichGame {

	private int funds;
	private String playersTypes;

	public Integer getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds=funds;
	}

	public void setPlayersTypes(String playersTypes) {
		this.playersTypes=playersTypes;
	}

	public String getPlayersTypes() {
		return playersTypes;
	}

	public HashMap InitialPlayers(int funds, String playersTypes) {
		HashMap gamePlayers=new HashMap();
		GamePlayer gamePlayer;		
		for(int i=0;i<playersTypes.length();i++){			
			gamePlayer=new GamePlayer(playersTypes.substring(i, i+1),funds);			
			gamePlayers.put(playersTypes.substring(i, i+1), gamePlayer);
		}
		return gamePlayers;		
	}

}
