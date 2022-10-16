package institutePKG;

public class ProgrammeRecord {
	private String programmeCode;
	private String programmeName;
	private int maximumNumOfCourses;
	private String award;
	private String accreditation;
	
	//Default Constructor
	public ProgrammeRecord() {
		this.programmeCode = "N/A";
		this.programmeName = "N/A";
		this.maximumNumOfCourses = -1;
		this.award = "N/A";
		this.accreditation = "N/A";
	}		
	
	//Primary Constructor
	public ProgrammeRecord(String programmeCode, String programmeName, int maximumNumOfCourses, String award,
			String accreditation) {
		this.programmeCode = programmeCode;
		this.programmeName = programmeName;
		this.maximumNumOfCourses = maximumNumOfCourses;
		this.award = award;
		this.accreditation = accreditation;
	}
	
	//Copy Constructor
	public ProgrammeRecord(ProgrammeRecord obj) {
		this.programmeCode = obj.programmeCode;
		this.programmeName = obj.programmeName;
		this.maximumNumOfCourses = obj.maximumNumOfCourses;
		this.award = obj.award;
		this.accreditation = obj.accreditation;
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

	public int getMaximumNumOfCourses() {
		return maximumNumOfCourses;
	}

	public void setMaximumNumOfCourses(int maximumNumOfCourses) {
		this.maximumNumOfCourses = maximumNumOfCourses;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getAccreditation() {
		return accreditation;
	}

	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}



	@Override
	public String toString() {
		return "ProgrammeRecord [getProgrammeCode()=" + getProgrammeCode() + ", getProgrammeName()="
				+ getProgrammeName() + ", getMaximumNumOfCourses()=" + getMaximumNumOfCourses() + ", getAward()="
				+ getAward() + ", getAccreditation()=" + getAccreditation() + "]";
	}
	
	
	
}
