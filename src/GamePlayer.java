
public class GamePlayer {
	public String charactersType;
	public String charactersName;
	public String display="";
	public int status=0;//1为医院，2为监狱
	public int funds=0;
	public int points=0;
	public int[] landedProperty={0,0,0,0};//空地x处；茅屋x处；洋房y处；摩天楼z处
	public int[] stageProperty={0,0,0};//路障 x个；炸弹y个；机器娃娃z个
	public int location=0;
	public int leftdays=0;//扣留或住院剩余天数
	public int MascotLeftDays=0;//福神在身剩余天数
	public int getFunds() {
		return funds;
	}


	public void setFunds(int funds) {
		this.funds = funds;
	}

	public GamePlayer(String charactersType,int funds){
		this.charactersType=charactersType;
		InitializeCharacters(charactersType);
		setFunds(funds);
	}
	
	private void InitializeCharacters(String charactersType){
		
		if(charactersType.equals("1")){			
			this.charactersName="钱夫人";
			this.display="Q";
		}
		else if(charactersType.equals("2")){		
			this.charactersName="阿土伯";
			this.display="A";
		}
		else if(charactersType.equals("3")){			
			this.charactersName="孙小美";
			this.display="S";
		}	
		else if(charactersType.equals("4")){			
			this.charactersName="金贝贝";
			this.display="J";
		}
	}
	
	public void getIntoHospital() {
		location=14;		
	    status=1;
		leftdays=3;
	}
}
