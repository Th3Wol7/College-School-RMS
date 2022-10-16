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
		this.enrollementStatus = "N/A";
		this.userType = "Student";
	}
			
	//Primary Constructor
	Student(String firstName, String lastName, Date dOB, Address address, Telephone telephone, String studentID, Date dateEnrolled, 
			String programmeCode, String enrollementStatus,  String password) {
		super(firstName, lastName, dOB, address, telephone, password);
		this.studentID = studentID;
		this.dateEnrolled = dateEnrolled;
		this.programmeCode = programmeCode;
		this.enrollementStatus = enrollementStatus;
		this.userType = "Student";
	}
	
	//Copy Constructor
	Student(Student obj) {
		super(obj.firstName, obj.lastName, obj.dOB, obj.address, obj.telephone, obj.password);
		this.studentID = obj.studentID;
		this.dateEnrolled = obj.dateEnrolled;
		this.programmeCode = obj.programmeCode;
		this.enrollementStatus = obj.enrollementStatus;
		this.userType = "Student";
	}


	//Getters and setters`
	public String getStudentID() {
		return studentID;
	}


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
	
	
}
