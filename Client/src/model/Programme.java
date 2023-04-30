package model;

public class Programme{
	private String programmeCode;
	private String programmeName;
	private String accreditation;// BSC, Diploma, Masters etc
	private int numOfCourses;
	private String length;
	private String Description;
	private double cost;
	private int minimumCredits = -1;

	//Default Constructor
	public Programme() {
		setProgrammeCode("N/A");
		setProgrammeName("N/A");
		setAccreditation("N/A");
		setDescription("N/A");
		setNumOfCourses(-1);
		setMinimumCredits(-1);
		setLength("N/A");
		setCost(0.0);
	}		
	
	//Primary Constructor
	public Programme(String programmeCode, String programmeName, String accreditation, String description,
					 int numOfCourses, int totalCredits, String length, double cost) {
		setProgrammeCode(programmeCode);
		setProgrammeName(programmeName);
		setAccreditation(accreditation);
		setNumOfCourses(numOfCourses);
		setDescription(description);
		setMinimumCredits(totalCredits);
		setLength(length);
		setCost(cost);
	}
	
	//Copy Constructor
	public Programme(Programme obj) {
		setProgrammeCode(obj.getProgrammeCode());
		setProgrammeName(obj.getProgrammeName());
		setAccreditation(obj.getAccreditation());
		setNumOfCourses(obj.getNumOfCourses());
		setDescription(obj.getDescription());
		setMinimumCredits(obj.getMinimumCredits());
		setLength(obj.getLength());
		setCost(obj.getCost());
	}


	//Getters and Setter
	public String getProgrammeCode() {
		return programmeCode;
	}

	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public String getAccreditation() {
		return accreditation;
	}

	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}
	public int getNumOfCourses() {
		return numOfCourses;
	}

	public void setNumOfCourses(int numOfCourses) {
		this.numOfCourses = numOfCourses;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getMinimumCredits() {
		return minimumCredits;
	}

	public void setMinimumCredits(int minimumCredits) {
		this.minimumCredits = minimumCredits;
	}

	@Override
	public String toString() {
		return "Programme{" +
				"programmeCode='" + getProgrammeCode() + '\'' +
				", programmeName='" + getProgrammeName() + '\'' +
				", Accreditation='" + getAccreditation() + '\'' +
				", numOfCourses=" + getNumOfCourses() +
				", length='" + getLength() + '\'' +
				", Description='" + getDescription() + '\'' +
				", cost=" + getCost() +
				", minimumCredits=" + getMinimumCredits() +
				'}';
	}
}
