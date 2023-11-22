package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "CourseGPA")
@Table(name = "CourseGPA")
public class CourseGPA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "courseID")
    private String courseID;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "year")
    private int year;


    //Default Constructor
    public CourseGPA(){
        setStudentID("N/A");
        setCourseID("N/A");
        setGpa(0.00);
        setYear(0000);
    }

    //Primary Constructor
    public CourseGPA(String studentID, String courseID, float gpa, int year){
        setStudentID(studentID);
        setCourseID(courseID);
        setGpa(gpa);
        setYear(year);
    }

    //Copy Constructor
    public CourseGPA( CourseGPA obj){
        setStudentID(obj.studentID);
        setCourseID(obj.courseID);
        setGpa(obj.gpa);
        setYear(obj.year);
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CourseGPA{" +
                "id=" + id +
                ", studentID='" + studentID + '\'' +
                ", courseID='" + courseID + '\'' +
                ", gpa=" + gpa +
                ", year=" + year +
                '}';
    }
}

