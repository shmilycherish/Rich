package Game;

import Game.GameMap;
import Game.GamePlayer;
import Game.Ground;

import java.util.*;


public class StartRich {

	/**
	 * @param args
	 */
	public String charactersTypes;
	public HashMap gamePlayers;
	public int playersNumber;
	public List<Integer> bombs=new ArrayList<Integer>();
	public HashMap stageProperties=new HashMap();
	public GameMap gameMap=new GameMap();
	public void RichStart() {
		System.out.println("欢迎开始大富翁游戏");
		System.out.println("设置玩家初始资金，范围1000～50000（默认10000）");
		int funds= setInitialFunds(new Scanner(System.in));		
		System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
		charactersTypes=getGamePlayers(new Scanner(System.in));
		gamePlayers=InitialPlayers(funds,charactersTypes);
	}

	public String readUserInput(Iterator<String> scanner){
		return scanner.next();
	}
	
	//初始化资金
	public int setInitialFunds(Iterator<String> scanner){
		String fundsRead=readUserInput(scanner);
		int funds=10000;
		if(fundsRead!="")
			funds=Integer.parseInt(fundsRead);
		return funds;		
	}
	//获取玩家编号
	public String getGamePlayers(Iterator<String> scanner){
		String charactersTypes=readUserInput(scanner);
		return charactersTypes;
	}
	
	//初始化玩家列表
	public HashMap InitialPlayers(int funds,String charactersTypes ){
		
		playersNumber=charactersTypes.length();
		HashMap gamePlayers=new HashMap();				
		GamePlayer gamePlayer;
		for(int i=0;i<playersNumber;i++){			
			gamePlayer=new GamePlayer(charactersTypes.substring(i, i+1),funds);			
			gamePlayers.put(charactersTypes.substring(i, i+1), gamePlayer);
		}
		return gamePlayers;
	}
	
	//todo 未完成
	public void  beginRichGame(){
		int start=0;
		GamePlayer gamePlayer;
		while(true){
			start=start%4;			
			gamePlayer=(GamePlayer) gamePlayers.get(charactersTypes.substring(start, start+1));
			checkPlayerstatus(gamePlayer);
			System.out.print(gamePlayer.getCharactersName()+">");
			boolean commandEnd=false;
			while(!commandEnd){
				String command=readUserInput(new Scanner(System.in));
				commandEnd=commondAnalysis(command,gamePlayer);
			}
		}
	}
	
	private void checkPlayerstatus(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		
	}

	public boolean commondAnalysis(String command,GamePlayer gamePlayer){
		boolean commandEnd=false;
		if(command.equals("roll")){
			int rollResult=roll();
			executeRoll(gamePlayer,rollResult);
			commandEnd=true;
		}else if(command.equals("query"))
			query(gamePlayer);
		
		return commandEnd;
	}

	public void query(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		System.out.println("资 金:"+gamePlayer.funds+"元");
		System.out.println("点数:"+gamePlayer.points+"点");
		System.out.print("地产:空地"+gamePlayer.landedProperty[0]+"处；");
		System.out.print("茅屋"+gamePlayer.landedProperty[1]+"处；");
		System.out.print("洋房"+gamePlayer.landedProperty[2]+"处；");
		System.out.println("摩天楼"+gamePlayer.landedProperty[3]+"处。");
		System.out.print("道具:路障"+gamePlayer.stageProperty[0]+"个；");
		System.out.print("炸弹"+gamePlayer.stageProperty[1]+"个；");
		System.out.println("机器娃娃"+gamePlayer.stageProperty[2]+"个。");
	}

    public int roll(){
    	int rollResult=(int) (Math.random()*6+1);
		return rollResult;   	
    }
	//todo
	public void executeRoll(GamePlayer gamePlayer,int rollResult) {
		// TODO Auto-generated method stub		
		int locationBeforeRoll=gamePlayer.getLocation();			
		int stagePropertylocation=checkStageProperties(locationBeforeRoll,rollResult);
		//是否有道具
		if(stagePropertylocation>0){			
			StagePropertyPerformance(stagePropertylocation,gamePlayer);
			return;
		}else{
			gamePlayer.setLocation((gamePlayer.getLocation()+rollResult)%70);
			currentLocationPerformance(gamePlayer);
		}
		
		
	}

	private void currentLocationPerformance(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		switch(gamePlayer.getLocation()){
			case 14:getIntoHospital(gamePlayer);break;
			case 28:buyStageProperty(gamePlayer);break;
			case 35:chooseGift(gamePlayer);break;
			case 49:getIntoPrison(gamePlayer);break;
			case 63:useMagic(gamePlayer);break;
			default:otherLocationPerformance(gamePlayer);
				
		}
		
	}

	private void otherLocationPerformance(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		int location=gamePlayer.getLocation();
		Ground ground=gameMap.getGroundList().get(location);
		if(gamePlayer.getLocation()>=64&&gamePlayer.getLocation()<=69)
			gamePlayer.points+=ground.getPoint();
		else{
			estateOperation(gamePlayer);
		}
	}

	public void estateOperation(GamePlayer gamePlayer) {
		int location=gamePlayer.getLocation();
		Ground ground=gameMap.getGroundList().get(location);
		if(ground.getOwners().equals("0")){
			System.out.println("是否购买该处空地，"+ground.getPrice()+"元（Y/N）?");
			checkBuyanswer(gamePlayer);			
		}else if(ground.getOwners().equals(gamePlayer.getCharactersType())){
			if(gameMap.getGroundList().get(location).getGroundType()<3){
				System.out.println("是否升级该处地产，"+ground.getPrice()+"元（Y/N）?");
				checkBuyanswer(gamePlayer);
			}
		}else{
			
		}
		
	}

	private void checkBuyanswer(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		String buyResult=readUserInput(new Scanner(System.in));
		if(buyResult.equalsIgnoreCase("Y")){
			if(gamePlayer.funds>=gameMap.getGroundList().get(gamePlayer.getLocation()).getPrice()){
				gamePlayer.funds-=gameMap.getGroundList().get(gamePlayer.getLocation()).getPrice();
				gameMap.getGroundList().get(gamePlayer.getLocation()).setOwners(gamePlayer.getCharactersType());
			}else{
				System.out.println("剩余资金不够");
			}
		}else if(buyResult.equalsIgnoreCase("N")){
			//doNothing
			return;
		}else{
			checkBuyanswer(gamePlayer);
		}
	}

	private void useMagic(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		
	}

	private void getIntoPrison(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		gamePlayer.setLocation(49);
		gameMap.getGroundList().get(gamePlayer.getLocation()).setDisplay(gamePlayer.getDisplay());
		gamePlayer.status=2;
		gamePlayer.leftdays=2;
	}

	private void chooseGift(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		GameMessage gameMessage =new GameMessage();
        gameMessage.GiftHouseWelcomeMessage();
		String giftCode=readUserInput(new Scanner(System.in));
		switch(giftCode.charAt(0)){
		case 1:gamePlayer.funds+=2000;break;
		case 2:gamePlayer.points+=200;break;
		case 3:gamePlayer.MascotLeftDays+=5;break;
		}
	}

	private void buyStageProperty(GamePlayer gamePlayer) {
		// TODO Auto-generated method stub		
		int StageProperties=gamePlayer.stageProperty[0]+gamePlayer.stageProperty[1]+gamePlayer.stageProperty[2];
		System.out.println("欢迎光临道具屋， 请选择您所需要的道具：");
		System.out.println("道具          编号    价值（点数）");
		System.out.println("路障            1     50");
		System.out.println("机器娃娃   2     30");
		System.out.println("炸 弹           3     50  ");
		System.out.println("输入道具的编号选择道 具,每次选择一件道具，按“F”可手工退出道具屋");
		if(gamePlayer.points<30)
			return;
		else {
			String giftOperationCommand=readUserInput(new Scanner(System.in));
			if(giftOperationCommand.equals("F"))
				return;
			//todo
		}
	}

	private void StagePropertyPerformance(int stagePropertylocation,GamePlayer gamePlayer) {
		// TODO Auto-generated method stub
		String stagePropertyType=(String) stageProperties.get(stagePropertylocation);
		if(stagePropertyType.equals("bomb")){
			getIntoHospital(gamePlayer);			
		}else if(stagePropertyType.equals("block")){
			stopInBlock(gamePlayer,stagePropertylocation);
		}
		stageProperties.remove(stagePropertylocation);
	}

	private void stopInBlock(GamePlayer gamePlayer, int StagePropertylocation) {
		// TODO Auto-generated method stub
		gamePlayer.setLocation(StagePropertylocation);
		gameMap.getGroundList().get(gamePlayer.getLocation()).setDisplay(gamePlayer.getDisplay());
		//currentLocationPerformance(gamePlayer);
	}

	public void getIntoHospital(GamePlayer gamePlayer) {
		gamePlayer.setLocation(14);
		gameMap.getGroundList().get(gamePlayer.getLocation()).setDisplay(gamePlayer.getDisplay());
		gamePlayer.status=1;
		gamePlayer.leftdays=3;
	}

	public int checkStageProperties(int locationBeforeRoll,int rollResult){
		int CheckLocation=(locationBeforeRoll+1)%70;
		int StagePropertylocation=-1; 
		while(rollResult>0){
			if(stageProperties.containsKey(CheckLocation)){
				StagePropertylocation=CheckLocation;
				return StagePropertylocation;
			}
			CheckLocation++;
			rollResult--;
		}
		return StagePropertylocation;
	}
	
}
