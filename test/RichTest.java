import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
public class RichTest {

	@Test
	public void shouldstartGame(){
		StartRich startRich=new StartRich();
		startRich.query(new GamePlayer("1",15000));
	}
		
	@Test
	public void shouldstatrMap(){
		GameMap maps=new GameMap();
		maps.initalizeMap();
		maps.printMap();
	}
	
	@Test
	public void shouldbombisexplodewhenplayer(){
		StartRich startRich=new StartRich();
		startRich.stageProperties.put(2, "bomb");
		startRich.stageProperties.put(10, "bomb");
		startRich.stageProperties.put(11, "bomb");
		startRich.stageProperties.put(7, "block");
		int i=startRich.checkStageProperties(1, 2);
		int j=startRich.checkStageProperties(5,4);
		int k=startRich.checkStageProperties(5,5);
		int m=startRich.checkStageProperties(69,6);
		int n=startRich.checkStageProperties(67,3);
		assertThat(i,is(2));
		assertThat(j,is(7));
		assertThat(k,is(7));
		assertThat(m,is(2));
		assertThat(n,is(-1));
	}
	
	@Test
	public void buyestateOperationTest(){
		
	}
}
