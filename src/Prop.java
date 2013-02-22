import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-22
 * Time: 下午3:56
 * To change this template use File | Settings | File Templates.
 */
public class Prop {
    private HashMap props=new HashMap();
    private int robotEffectDistance=10;
	public HashMap getProps() {
		return props;
	}

    private boolean hasProp(int location) {
        return props.containsKey(location);
    }

	public boolean placedProp(int location,int propType) {
         if(hasProp(location))
             return false;
        else
        props.put(location, propType);
        return true;
	}

    public void robotRemoveProps(int playCurrentLocation) {
        int removeCount=robotEffectDistance;
        int removeLocation=playCurrentLocation+1;
        while(removeCount>0) {
            props.remove(removeLocation%70);
            removeLocation++;
            removeCount--;
         }
    }
	
}
