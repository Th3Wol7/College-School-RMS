package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CourseGPA")
public class CourseGPA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "semester")
    private int semester;

    @Column(name = "year")
    private int year;


    //Default Constructor
    public CourseGPA(){
        setStudentID("N/A");
        setCourseCode("N/A");
        setGpa(0.00);
        setSemester(0);
        setYear(0000);
    }

    //Primary Constructor
    public CourseGPA(String studentID, String courseCode, float gpa, int semester, int year){
        setStudentID(studentID);
        setCourseCode(courseCode);
        setGpa(gpa);
        setSemester(semester);
        setYear(year);
    }

    //Copy Constructor
    public CourseGPA( CourseGPA obj){
        setStudentID(obj.studentID);
        setCourseCode(obj.courseCode);
        setGpa(obj.gpa);
        setSemester(obj.semester);
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
                "id=" + getId() +
                ", studentID='" + getStudentID() + '\'' +
                ", courseCode='" + getCourseCode() + '\'' +
                ", gpa=" + getGpa() +
                ", semester=" + getSemester() +
                ", year=" + getYear() +
                '}';
    }
}

