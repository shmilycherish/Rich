import java.util.ArrayList;
import java.util.List;


public class GameMap {
	public Ground ground;
	public List<Ground> map=new ArrayList<Ground>();
	private int[] point={20,80,100,40,80,60};
	private String groundOwner="0";
 	public GameMap(){
 		initalizeMap();
 	}
	public List<Ground> initalizeMap(){

        map.clear();
 		
 		for(int i=0;i<=69;i++){
 			ground=new Ground();
 			if(i==0){
 				ground.initalizeGround("S");
 			}
 			else if(i>0&&i<28){
 				if(i!=14){
 					ground.initalizeGround("0");
 					ground.setPrice(200);
 				}else{
 					ground.initalizeGround("H");
 				} 				
 			}
 			else if(i==28){
 				ground.initalizeGround("T"); 				
 			}
 			else if(i>28&&i<35){
 				ground.initalizeGround("0");
 				ground.setPrice(500);
 			}
 			else if(i==35){
 				ground.initalizeGround("G");
 			}
 			else if(i>35&&i<63){
 				if(i!=49){
 					ground.initalizeGround("0");
 					ground.setPrice(300);
 				}else{
 					ground.initalizeGround("P");
 				} 				
 			}
 			else if(i==63){
 				ground.initalizeGround("M");
 			}
 			else if(i>63){				
 				ground.initalizeGround("$");
 				ground.setPoint(point[i-64]);		
 			}
 			map.add(ground);
 		}
 		
		return map;
	
 	}
	public void printMap(){	
		for(int i=0;i<=28;i++)
		{	
			ground=map.get(i);
			System.out.print(ground.getDisplay());
		}
		System.out.println();
		int cha=40;
		
		for(int i=29;i<=34;i++){
			printLine(i+cha,i);
			cha=cha-2;
		}
		for(int i=63;i>=35;i--)
		{	
			ground=map.get(i);
			System.out.print(ground.getDisplay());
		}
	}

	public void printLine(int firstGround,int lastGround){
		System.out.print(map.get(firstGround).getDisplay());
		for(int i=1;i<=27;i++)
			System.out.print(" ");
		System.out.println(map.get(lastGround).getDisplay());
	}		
 	
}
