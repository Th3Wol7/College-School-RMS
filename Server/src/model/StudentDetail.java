package model;

import java.util.ArrayList;
import java.util.List;

public class StudentDetail {
    private String studentID;
    private Date dateEnrolled;
    private String programmeCode;
    private String enrollmentStatus;
    private String email;
    List<Course> enrolledCourses = new ArrayList<>();

    //Primary Constructor
    public StudentDetail() {
        this.studentID = "N/A";
        this.dateEnrolled = new Date();
        this.programmeCode = "N/A";
        this.enrollmentStatus = "0";
        this.email = "N/A";
        enrolledCourses = new ArrayList<>();
    }

    //Primary Constructor
    StudentDetail(String ID, int enrollDay, int enrollMonth, int enrollYear, String programmeCode, String status, String email, List<Course> enrolledCourses) {
        this.studentID = ID;
        this.dateEnrolled = new Date(enrollDay, enrollMonth, enrollYear);
        this.programmeCode = programmeCode;
        this.enrollmentStatus = "0";
        this.email = email;
        this.enrolledCourses = enrolledCourses;
    }

    //Copy Constructor
    StudentDetail(Student obj) {
        setStudentID(obj.getStudentID());
        obj.userType = "Student";
        obj.password = obj.lastName + obj.getStudentID();
        this.studentID = obj.getStudentID();
        this.dateEnrolled = obj.getDetails().getDateEnrolled();
        this.programmeCode = obj.getDetails().getProgrammeCode();
        this.enrollmentStatus = obj.getDetails().getEnrollmentStatus();
        this.email = obj.getDetails().getEmail();
        this.enrolledCourses = obj.getDetails().getEnrolledCourses();
    }

    //Getters and setters`
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "studentID='" + studentID + '\'' +
                ", dateEnrolled=" + dateEnrolled +
                ", programmeCode='" + programmeCode + '\'' +
                ", enrollmentStatus='" + enrollmentStatus + '\'' +
                ", email='" + email + '\'' +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

    public void enrollForSemester() {
    }

    public void viewProgrammeDetails() {
    }

    public void addCourse() {
    }

    public void generateFees() {
    }

    public void generateReport() {
    }

}
