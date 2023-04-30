package model;

public class Administrator extends Staff {

	public Administrator(){
		setStaffID("nimdAtlualf3D");
		setFirstName("Default");
		setLastName("Admin");
		setdOB(new Date());
		setAddress(new Address());
		setTelephone("N/A");
		setPassword("$000#");
		setUserType("Administrator");
	}

	//The system should accept general programme details
	public void createProgramme() {}


	//The system should allow for the addition, removal, and
	//editing of courses for the programme.
	public void modifyProgrammeDetails() {}

}
