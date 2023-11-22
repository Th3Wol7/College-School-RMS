package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Programme")
@Table(name = "Programme")
public class Programme implements Serializable{
	@Id
	@Column(name = "programmeCode")
	private String programmeCode;

	@Column(name = "programmeName")
	private String programmeName;

	@Column(name = "accreditation")
	private String accreditation;// BSC, Diploma, Masters etc

	@Column(name = "numOfCourses")
	private int numOfCourses;

	@Column(name = "yearsOfStudy")
	private String length;

	@Column(name = "description")
	private String Description;

	@Column(name = "cost")
	private double cost;

	@Column(name = "totalCredits")
	private int minimumCredits = -1;

	private String director; //programme director identified by user ID

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
		setDirector("Admin");
	}		
	
	//Primary Constructor
	public Programme(String programmeCode, String programmeName, String accreditation, String description,
					 String director, int numOfCourses, int totalCredits, String length, double cost) {
		setProgrammeCode(programmeCode);
		setProgrammeName(programmeName);
		setAccreditation(accreditation);
		setNumOfCourses(numOfCourses);
		setDescription(description);
		setMinimumCredits(totalCredits);
		setLength(length);
		setCost(cost);
		setDirector(director);
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
		setDirector(obj.getDirector());
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Programme{" +
				"programmeCode='" + programmeCode + '\'' +
				", programmeName='" + programmeName + '\'' +
				", accreditation='" + accreditation + '\'' +
				", numOfCourses=" + numOfCourses +
				", length='" + length + '\'' +
				", Description='" + Description + '\'' +
				", cost=" + cost +
				", minimumCredits=" + minimumCredits +
				", director='" + director + '\'' +
				'}';
	}
}
