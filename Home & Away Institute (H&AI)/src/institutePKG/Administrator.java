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
	
	
	
	//The system should accept general programme details
	public void createProgramme() {}
	
	
	//The system should allow for the addition, removal, and 
	//editing of courses for the programme.
	public void modifyProgrammeDetails() {}
	
	
	
	
}
