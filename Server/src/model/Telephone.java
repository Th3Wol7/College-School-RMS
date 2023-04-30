package model;

public class Telephone {
	private int areaCode;
	private int prefix;
	private int serialNumber;


	public Telephone() {
		setAreaCode(000);
		setPrefix(000);
		setSerialNumber(000);
	}

	//Primary Constructor
	public Telephone(int areaCode, int prefix, int serialNumber) {
		setAreaCode(areaCode);
		setPrefix(prefix);
		setSerialNumber(serialNumber);
	}

	//Copy Constructor
	public Telephone(Telephone obj) {
		setAreaCode(obj.getAreaCode());
		setPrefix(obj.getPrefix());
		setSerialNumber(obj.getSerialNumber());
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
