package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Course")
public class Course implements Serializable {
    @Id
    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private int credits;

    @Column(name = "prerequisite")
    private String prerequisite;

    @Column(name = "cost")
    private double cost;

    //Default Constructor
    public Course() {
        setCourseCode("N/A");
        setCourseName("N/A");
        setDescription("N/A");
        setCredits(-1);
        setPrerequisite("none");
        setCost(0.00);
    }

    //Primary Constructor
    public Course(String courseCode, String courseName, String description, int credits, String prerequisite, double cost) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setDescription(description);
        setCredits(credits);
        setPrerequisite(prerequisite);
        setCost(cost);
    }

    //Copy Constructor
    public Course(Course obj) {
        setCourseCode(obj.courseCode);
        setCourseName(obj.courseName);
        setDescription(obj.description);
        setCredits(obj.credits);
        setPrerequisite(obj.prerequisite);
        setCost(obj.cost);
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + getCourseCode() + '\t' +
                ", courseName='" + getCourseName() + '\t' +
                ", description='" + getDescription() + '\t' +
                ", credits=" + getCredits() +'\t'+
                ", prerequisite='" + getPrerequisite() + '\t' +
                ", cost=" + getCost() +
                '}';
    }
}
