package institutePKG;

public class Administrator extends Staff {
	private String AdminID;
	
	public Administrator(){
		this.firstName = "Default";
		this.lastName = "Admin";
		this.dOB = new Date();
		this.address = new Address();
		this.telephone = "N/A";
		this.password = "$000#";
		this.userType = "Administrator";
	}
	
	
	
	
}
