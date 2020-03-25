package JTableEX2;

public class DTOGrade {
	private String name;
	private String j1;
	private String j2;
	private String j3;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJ1() {
		return j1;
	}
	public void setJ1(String j1) {
		this.j1 = j1;
	}
	public String getJ2() {
		return j2;
	}
	public void setJ2(String j2) {
		this.j2 = j2;
	}
	public String getJ3() {
		return j3;
	}
	public void setJ3(String j3) {
		this.j3 = j3;
	}
	public String[] getArray() {
		String[] returnData = new String[4];
		returnData[0]=this.name;
		returnData[1]=this.j1;
		returnData[2]=this.j2;
		returnData[3]=this.j3;
		
		return returnData;
	}
	
	
	
}






