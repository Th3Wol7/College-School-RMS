package institutePKG;

public class Administrator extends User {
	private String AdminID;
	
	public Administrator(){
		this.firstName = "Default";
		this.lastName = "Admin";
		this.dOB = new Date();
		this.address = new Address();
		this.telephone = new Telephone();
		this.password = "$000#";
		this.userType = "Administrator";
	}
	
	public Administrator(String firstName, String lastName, Date dOB, Address address, Telephone telephone, String password){
		super(firstName, lastName, dOB, address, telephone, password);
	}
	
	
}
