
public class Ground {	
    public String groundName="0";	
	public int groundType=0;
	public int price=0;
	public int point=0;
	public String owners="0";//0wei
	public String display="0";
	
	
	public void initalizeGround(String groundName){
		this.groundName=groundName;
		this.display=groundName;
	}
	
	public String getOwners() {
		return owners;
	}
	public void setOwners(String owners) {
		this.owners = owners;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getGroundType() {
		return groundType;
	}

	public void setGroundType(int groundType) {
		this.groundType = groundType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}