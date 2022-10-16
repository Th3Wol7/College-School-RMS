package institutePKG;

public class Staff extends User {
	private String staffID;
	private String faculty;
	private String department;
	private Date dateEmployed;
	
	//Default Constructor
	Staff() {
		super();
		this.staffID = "N/A";
		this.faculty = "N/A";
		this.department = "N/A";
		this.dateEmployed = new Date();
		this.userType = "Staff";
	}
	
	//Primary Constructor
	Staff(String firstName, String lastName, Date dOB, Address address, String telephone, String staffID, 
			String faculty, String department, Date dateEmployed, String password) {
		super(firstName, lastName, dOB, address, telephone, password);
		this.staffID = staffID;
		this.faculty = faculty;
		this.department = department;
		this.dateEmployed = dateEmployed;
		this.userType = "Staff";
	}
	
	//Copy Constructor
	Staff(Staff obj) {
		super(obj.firstName, obj.lastName, obj.dOB, obj.address, obj.telephone, obj.password);
		this.staffID = obj.staffID;
		this.faculty = obj.faculty;
		this.department = obj.department;
		this.dateEmployed = obj.dateEmployed;
		this.userType = "Staff";
	}

	//Getters and Setters
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateEmployed() {
		return dateEmployed;
	}

	public void setDateEmployed(Date dateEmployed) {
		this.dateEmployed = dateEmployed;
	}

	@Override
	public String toString() {
		return "Staff [getStaffID()=" + getStaffID() + ", getFaculty()=" + getFaculty() + ", getDepartment()="
				+ getDepartment() + ", getDateEmployed()=" + getDateEmployed() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getdOB()=" + getdOB() + ", getAddress()=" + getAddress()
				+ ", getTelephone()=" + getTelephone() + "]";
	}
	
	
	public void registerStudent() {}
	public void createProgram() {}
	public void modifyProgramDetails() {}
	public void generateStudentList() {}
	
	//File types: Staff, Student, Course, Programme

}
