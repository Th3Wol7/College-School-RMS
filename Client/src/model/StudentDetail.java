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
        setStudentID("N/A");
        setDateEnrolled(new Date());
        setProgrammeCode("N/A");
        setEnrollmentStatus("0");
        setEmail("N/A");
        setEnrolledCourses(new ArrayList<>());
    }

    //Primary Constructor
    StudentDetail(String ID, int enrollDay, int enrollMonth, int enrollYear, String programmeCode, String status,
                  String email, List<Course> enrolledCourses) {
        setStudentID(ID);
        setDateEnrolled(new Date(enrollDay, enrollMonth, enrollYear));
        setProgrammeCode(programmeCode);
        setEnrollmentStatus("0");
        setEmail(email);
        setEnrolledCourses(enrolledCourses);
    }

    //Copy Constructor
    StudentDetail(Student obj) {
        setStudentID(obj.getStudentID());
        setDateEnrolled(obj.getDetails().getDateEnrolled());
        setProgrammeCode(obj.getDetails().getProgrammeCode());
        setEnrollmentStatus(obj.getDetails().getEnrollmentStatus());
        setEmail(obj.getDetails().getEmail());
        setEnrolledCourses(obj.getDetails().getEnrolledCourses());
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
                "studentID='" + getStudentID() + '\'' +
                ", dateEnrolled=" + getDateEnrolled() +
                ", programmeCode='" + getProgrammeCode() + '\'' +
                ", enrollmentStatus='" + getEnrollmentStatus() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", enrolledCourses=" + getEnrolledCourses() +
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
