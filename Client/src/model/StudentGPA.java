package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "StudentGPA")
@Table(name = "StudentGPA")
public class StudentGPA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentID")
    private String studentID;

    @Column(name = "semester")
    private int semester;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "year")
    private int year;

    //Default Constructor
    public StudentGPA(){
        setStudentID("N/A");
        setSemester(0);
        setGpa(0.00);
        setYear(0000);
    }

    //Primary Constructor
    public StudentGPA(String studentID, int semester, double gpa){
        setStudentID(studentID);
        setSemester(semester);
        setGpa(gpa);
        setYear(year);
    }

    //Copy Constructor
    public StudentGPA(StudentGPA obj){
        setStudentID(obj.studentID);
        setSemester(obj.semester);
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
        return "StudentGPA{" +
                "id=" + id +
                ", studentID='" + studentID + '\'' +
                ", semester=" + semester +
                ", gpa=" + gpa +
                ", year=" + year +
                '}';
    }
}