package institutePKG;

public class Address {
	private String streetNum;
	private String streetName;
	private String state;
	private String country;
	
	// Default Constructor
	public Address() {
		this.streetNum = "N/A";
		this.streetName = "N/A";
		this.state = "N/A";
		this.country = "N/A";
	}
	
	//Primary Constructor
	public Address(String streetNum, String streetName, String state, String country) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
	}

	public Address(Address obj) {
		this.streetNum = obj.streetNum;
		this.streetName = obj.streetName;
		this.state = obj.state;
		this.country = obj.country;
	}
	
	//Getters and Setters
	public String getStreetNum() {
		return streetNum;
	}


	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Address [getStreetNum()=" + getStreetNum() + ", getStreetName()=" + getStreetName() + ", getState()="
				+ getState() + ", getCountry()=" + getCountry() + "]";
	}



}
