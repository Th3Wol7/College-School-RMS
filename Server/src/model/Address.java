package model;

public class Address {
	private String streetNum;
	private String streetName;
	private String state;
	private String country;

	// Default Constructor
	public Address() {
		setStreetNum("N/A");
		setStreetName("N/A");
		setState("N/A");
		setCountry("N/A");
	}

	//Primary Constructor
	public Address(String streetNum, String streetName, String state, String country) {
		setStreetNum(streetNum);
		setStreetName(streetName);
		setState(state);
		setCountry(country);
	}

	public Address(Address obj) {
		setStreetNum(obj.streetNum);
		setStreetName(obj.streetName);
		setState(obj.state);
		setCountry(obj.country);
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
