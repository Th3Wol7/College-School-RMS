package institutePKG;

public class Course {
	private String courseCode;
	private String courseName;
	private String description;
	private int credits;
	private String prerequisite;
	
	//Default Constructor
	public Course() {
		this.courseCode = "N/A";
		this.courseName = "N/A";
		this.description = "N/A";
		this.credits = -1;
		this.prerequisite = "none";
	}
	
	//Primary Consturctor
	public Course(String courseCode, String courseName, String description, int credits, String prerequisite) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.description = description;
		this.credits = credits;
		this.prerequisite = prerequisite;
	}
	
	//Copy Construcor
	public Course(Course obj) {
		this.courseCode = obj.courseCode;
		this.courseName = obj.courseName;
		this.description = obj.description;
		this.credits = obj.credits;
		this.prerequisite = obj.prerequisite;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	@Override
	public String toString() {
		return "Course [getCourseCode()=" + getCourseCode() + ", getCourseName()=" + getCourseName()
				+ ", getDescription()=" + getDescription() + ", getCredits()=" + getCredits() + ", getPrerequisite()="
				+ getPrerequisite() + "]";
	}
	
		
}
