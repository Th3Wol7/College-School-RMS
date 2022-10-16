package institutePKG;

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
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.dOB = new Date();
		this.address = new Address();
		this.telephone = "N/A";
		this.password = null;
	}
	
	//Primary Constructor
	 User(String firstName, String lastName, Date dOB, Address address, String telephone, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dOB = dOB;
		this.address = address;
		this.telephone = telephone;
		this.password = password;
	}
	 
	 //Copy Constructor
	 User(User obj) {
			this.firstName = obj.firstName;
			this.lastName = obj.lastName;
			this.dOB = obj.dOB;
			this.address = obj.address;
			this.telephone = obj.telephone;
			this.password = obj.password;
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
