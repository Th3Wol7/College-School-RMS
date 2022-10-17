package institutePKG;

public class Student extends User{
	private String studentID;
	private Date dateEnrolled;
	private String programmeCode;
	private String enrollementStatus;
	
	//Primary Constructor
	Student() {
		super();
		this.studentID = "N/A";
		this.dateEnrolled = new Date();
		this.programmeCode = "N/A";
		this.enrollementStatus = "0";
		this.userType = "Student";
	}
			
	//Primary Constructor
	Student(String firstName, String lastName, int dDay, int dMonth, int dYear, 
			String streetNum, String streetName, String state, String country, 
			String telephone, int day, int month, int year, String programmeCode) {
		super(firstName, lastName, dDay, dMonth, dYear, streetNum, streetName, state, country, telephone);
		setStudentID(studentID);
		this.dateEnrolled = new Date(day, month, year);
		this.programmeCode = programmeCode;
		this.enrollementStatus = "0";
		this.userType = "Student";
		this.password = lastName + studentID;
	}
	
	//Copy Constructor
	Student(Student obj) {
		super(obj.firstName, obj.lastName, obj.dOB, obj.address, obj.telephone);
		setStudentID(obj.studentID);
		this.dateEnrolled = obj.dateEnrolled;
		this.programmeCode = obj.programmeCode;
		obj.enrollementStatus = "0";
		obj.userType = "Student";
		obj.password = obj.lastName + obj.studentID;
	}


	//Getters and setters`
	public String getStudentID() {
		return studentID;
	}

	//Fix this
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public Date getDateEnrolled() {
		return dateEnrolled;
	}


	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}


	public String getProgrammeCode() {
		return programmeCode;
	}


	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}


	public String getEnrollementStatus() {
		return enrollementStatus;
	}


	public void setEnrollementStatus(String enrollementStatus) {
		this.enrollementStatus = enrollementStatus;
	}


	@Override
	public String toString() {
		return "Student [getStudentID()=" + getStudentID() + ", getDateEnrolled()=" + getDateEnrolled()
				+ ", getProgrammeCode()=" + getProgrammeCode() + ", getEnrollementStatus()=" + getEnrollementStatus()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getdOB()=" + getdOB()
				+ ", getAddress()=" + getAddress() + ", getTelephone()=" + getTelephone() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	public void enrollForSemester(){}
	public void viewProgrammeDetails() {}
	public void addCourse() {}
	public void generateFees() {}
	public void generateReport() {}
	
	
}
