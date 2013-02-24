import player.Player;

import java.util.HashMap;
import java.util.List;


public class RichGame {

	private int funds=10000;
	private String playersTypes;
    private List<Player> players;
    private GameMap gameMap;
    private HashMap props;

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }


	public Integer getFunds() {
		return funds;
	}

	public void setFunds(int funds) {

        this.funds=funds;
	}

	public List<Player> getPlayers(){
         return  players;
    }

    public void initialPlayers(List<Player> playerList) {
            this.players=playerList;
    }

    public int getPlayerCount() {
        return players.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public void setProps(HashMap props) {
            this.props= props;
    }
    public HashMap getProps() {
        return props;
    }



}
