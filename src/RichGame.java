import player.Player;

import java.util.HashMap;
import java.util.List;


public class RichGame {

	private int funds=10000;
	private String playersTypes;
    private List<Player> players;
	public Integer getFunds() {
		return funds;
	}

	public void setFunds(int funds) {

        this.funds=funds;
	}

	public String getPlayersTypes() {
		return playersTypes;
	}

    public void initialPlayers(List<Player> playerList) {
            this.players=playerList;
    }

    public int getPlayerCount() {
        return players.size();  //To change body of created methods use File | Settings | File Templates.
    }

}
