package player;

/**
 * Created with IntelliJ IDEA.
 * User: shmilyhoney
 * Date: 13-2-23
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class Player {

    private int funds;

    public Player()
    {
        this.funds = 10000;
    }

    public Player(int funds){
        this.funds = funds;
    }

    public int getFunds()
    {
         return funds;
    }
    public void setFunds(int funds){
        this.funds=funds ;
    }

    public abstract String getDisplayName();

    public abstract String getCharacterName();
}
