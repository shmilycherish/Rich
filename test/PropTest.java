import Game.Prop;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-22
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public class PropTest {

    private Prop prop;

    @Before
    public void init()
    {
        prop = new Prop();
    }

    @Test
    public void addPropTest(){
        int propLocation=2;
        int propType =1;
        boolean placedPropResult= prop.placedProp(propLocation, propType);
        boolean anotherPlacedPropResult= prop.placedProp(propLocation, propType);
        assertTrue(placedPropResult);
        assertFalse(anotherPlacedPropResult);
    }

    @Test
    public void removePropTest(){
        prop.placedProp(11,1);
        prop.placedProp(13,3);
        prop.placedProp(20,3);
        prop.placedProp(21,3);
        prop.robotRemoveProps(10);
        assertFalse(prop.getProps().containsKey(11));
        assertFalse(prop.getProps().containsKey(13));
        assertFalse(prop.getProps().containsKey(20));
        assertTrue(prop.getProps().containsKey(21));
    }
    @Test
    public void removePropTestWhenRemoveCoverStartingPoint(){
        prop.placedProp(69,1);
        prop.placedProp(0,3);
        prop.placedProp(7,3);
        prop.placedProp(9,3);
        prop.robotRemoveProps(67);
        assertFalse(prop.getProps().containsKey(69));
        assertFalse(prop.getProps().containsKey(5));
        assertFalse(prop.getProps().containsKey(0));
        assertFalse(prop.getProps().containsKey(7));
        assertTrue(prop.getProps().containsKey(9));
    }
}
