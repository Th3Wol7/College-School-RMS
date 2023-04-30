package model;

public class Course {
	private String courseCode;
	private String courseName;
	private String description;
	private int credits;
	private String prerequisite;

	//Default Constructor
	public Course() {
		setCourseCode("N/A");
		setCourseName("N/A");
		setDescription("N/A");
		setCredits(-1);
		setPrerequisite("none");
	}

	//Primary Constructor
	public Course(String courseCode, String courseName, String description, int credits, String prerequisite) {
		setCourseCode(courseCode);
		setCourseName(courseName);
		setDescription(description);
		setCredits(credits);
		setPrerequisite(prerequisite);
	}

	//Copy Construcor
	public Course(Course obj) {
		setCourseCode(obj.courseCode);
		setCourseName(obj.courseName);
		setDescription(obj.description);
		setCredits(obj.credits);
		setPrerequisite(obj.prerequisite);
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
