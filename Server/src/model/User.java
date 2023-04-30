package model;

public class User {
	protected String firstName;
	protected String lastName;
	protected Date dOB;
	protected Address address;
	protected String telephone;
	protected String password;
	protected String userType;

	//Default Constructor
	User(){
		setFirstName("N/A");
		setLastName("N/A");
		setdOB(new Date());
		setAddress(new Address());
		setTelephone("N/A");
		setPassword(null);
	}

	//Primary Constructor
	User(String firstName, String lastName, int day, int month, int year,
		 String streetNum, String streetName, String State, String Country,
		 String telephone) {
		setFirstName(firstName);
		setLastName(lastName);
		setdOB(new Date(day, month, year));
		setAddress(new Address(streetNum, streetName, State, Country));
		setTelephone(telephone);
	}


	//Second Primary Constructor
	User(String firstName, String lastName, Date dOB, Address address, String telephone) {
		setFirstName(firstName);
		setLastName(lastName);
		setdOB(dOB);
		setAddress(address);
		setTelephone(telephone);
	}

	//Copy Constructor
	User(User obj) {
		setFirstName(obj.firstName);
		setLastName(obj.lastName);
		setdOB(obj.dOB);
		setAddress(obj.address);
		setTelephone(obj.telephone);
		setPassword(obj.password);
	}

	//Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getdOB()=" + getdOB()
				+ ", getAddress()=" + getAddress() + ", getTelephone()=" + getTelephone()  + "]";
	}

}
