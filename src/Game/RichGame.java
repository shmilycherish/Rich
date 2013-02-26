package Game;

import RichMap.GameMap;
import RichMap.GroundFactory;
import player.Player;

import java.util.HashMap;
import java.util.List;


public class RichGame {

	private int funds=10000;
	private String playersTypes;
    private List<Player> players;
    private GameMap gameMap;
    private HashMap props;
    private boolean exitGameFlag=false;
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
        return players.size();
    }

    public void setProps(HashMap props) {
            this.props= props;
    }
    public HashMap getProps() {
        return props;
    }


    public boolean isExitGameFlag() {
        return exitGameFlag;
    }

    public void setExitGameFlag(boolean exitGameFlag) {
        this.exitGameFlag = exitGameFlag;
    }

    public void refreshMap(String playType) {
        for(int i=0;i<gameMap.getGroundList().size();i++) {
            if(gameMap.getGroundList().get(i).getOwners().equals(playType)) {
                gameMap.getGroundList().set(i, GroundFactory.buildEmptyGroundWithPrice(gameMap.getGroundList().get(i).getPrice()));
            }

        }
    }
}
