package institutePKG;

public class Telephone {
	private int areaCode;
	private int prefix;
	private int serialNumber;
	
	
	public Telephone() {
		this.areaCode = 000;
		this.prefix = 000;
		this.serialNumber = 000;
	}
	
	
	//Primary Constructor
	public Telephone(int areaCode, int prefix, int serialNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.serialNumber = serialNumber;
	}
	
	
	//Copy Constructor
	public Telephone(Telephone obj) {
		this.areaCode = obj.areaCode;
		this.prefix = obj.prefix;
		this.serialNumber = obj.serialNumber;
	}


	public int getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}


	public int getPrefix() {
		return prefix;
	}


	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}


	public int getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	@Override
	public String toString() {
		return "Telephone [getAreaCode()=" + getAreaCode() + ", getPrefix()=" + getPrefix() + ", getSerialNumber()="
				+ getSerialNumber() + "]";
	}
	
	

}
