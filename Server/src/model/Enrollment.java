package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Enrolled")
public class Enrollment {
    private String studentID;
    private String courseCode;
    private String programmeCode;
    private int semester;
    private int year;

    public Enrollment() {
        setStudentID("N/A");
        setCourseCode("N/A");
        setProgrammeCode("N/A");
        setSemester(0);
        setYear(0000);
    }

    public Enrollment(String studentID, String courseCode, String programmeCode, int semester, int year) {
        setStudentID(studentID);
        setCourseCode(courseCode);
        setProgrammeCode(programmeCode);
        setSemester(semester);
        setYear(year);
    }

    public Enrollment(Enrollment obj) {
        setStudentID(obj.studentID);
        setCourseCode(obj.courseCode);
        setProgrammeCode(obj.programmeCode);
        setSemester(obj.semester);
        setYear(obj.year);
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

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
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
        return "Enrollement{" +
                "studentID='" + getStudentID() + '\'' +
                ", courseCode='" + getCourseCode() + '\'' +
                ", programmeCode='" + getProgrammeCode() + '\'' +
                ", semester=" + getSemester() +
                ", year=" + getYear() +
                '}';
    }
}
