
public class GamePlayer {
	private String charactersType;
	private String charactersName;
	private String display="";
	public int status=0;//1为医院，2为监狱
	public int funds=0;
	public int points=0;
	public int[] landedProperty={0,0,0,0};//空地x处；茅屋x处；洋房y处；摩天楼z处
	public int[] stageProperty={0,0,0};//路障 x个；炸弹y个；机器娃娃z个
	public int location=0;
	public int leftdays=0;//扣留或住院剩余天数
	public int MascotLeftDays=0;//福神在身剩余天数
	
	
	public String getCharactersType() {
		return charactersType;
	}


	private void setCharactersType(String charactersType) {
		this.charactersType = charactersType;
	}


	public String getCharactersName() {
		return charactersName;
	}


	private void setCharactersName(String charactersName) {
		this.charactersName = charactersName;
	}


	public String getDisplay() {
		return display;
	}


	private void setDisplay(String display) {
		this.display = display;
	}


	public int getFunds() {
		return funds;
	}


	public void setFunds(int funds) {
		this.funds = funds;
	}

	public GamePlayer(String charactersType,int funds){
		setCharactersType(charactersType);
		InitializeCharacters(charactersType);
		setFunds(funds);
	}
	
	private void InitializeCharacters(String charactersType){
		
		if(charactersType.equals("1")){			
			setCharactersName("钱夫人");
			setDisplay("Q");
		}
		else if(charactersType.equals("2")){		
			setCharactersName("阿土伯");
			setDisplay("A");			
		}
		else if(charactersType.equals("3")){			
			setCharactersName("孙小美");
			setDisplay("S");
		}	
		else if(charactersType.equals("4")){			
			setCharactersName("金贝贝");
			setDisplay("J");
		}
	}
	
	public int dice(){
		return (int) (Math.random()*6+1);		 	
	}
	
	public void getIntoHospital() {
		location=14;		
	    status=1;
		leftdays=3;
	}
}
