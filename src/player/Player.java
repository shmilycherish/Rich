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
    private int points ;
    private int[] landedProperty={0,0,0,0};
    private int[] props={0,0,0} ;
    private int locaion=0;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int[] getLandedProperty() {
        return landedProperty;
    }

    public void setLandedProperty(int[] landedProperty) {
        this.landedProperty = landedProperty;
    }

    public int[] getProps() {
        return props;
    }

    public void setProps(int[] props) {
        this.props = props;
    }

    public int getLocaion() {
        return locaion;
    }

    public void setLocaion(int locaion) {
        this.locaion = locaion;
    }

    public  boolean haveProp(int propType){
        if(props[propType-1]>0) {
            return true;
         }
        return false;
    }


}
