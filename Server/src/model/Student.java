package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends User implements Serializable {
    @Id
    @JoinColumn(name = "ID")
    @OneToOne(mappedBy = "ID", cascade = CascadeType.ALL)
    private String studentID;
    @Column(name = "dateEnrolled")
    @Temporal(TemporalType.DATE)
    private Date dateEnrolled;
    @ManyToOne
    @JoinColumn(name = "programmeCode")
    private String programmeCode;
    @Column(name = "enrollmentStatus")
    private String enrollmentStatus;
    @OneToMany(mappedBy = "courseCode")
    List<Course> enrolledCourses = new ArrayList<>();

    //Primary Constructor
    public Student() {
        super();
        setUserType("Student");
        setStudentID("N/A");
        setDateEnrolled(new Date());
        setProgrammeCode("N/A");
        setEnrollmentStatus("0");
        setEnrolledCourses(new ArrayList<>());
    }

    //Primary Constructor
    Student(String studentID, String firstName, String lastName, Date dob, Address address, String telephone,
            Date enrollDate, String programmeCode, String status, String email, List<Course> enrolledCourses) {
        super(studentID, firstName, lastName, dob, email, address, telephone);
        setDateEnrolled(enrollDate);
        setProgrammeCode(programmeCode);
        setEnrollmentStatus(status);
        setEnrolledCourses(enrolledCourses);
        setUserType("Student");
        setPassword(lastName + studentID);
    }

    //Copy Constructor
    Student(Student obj) {
        super(obj.getStudentID(), obj.getFirstName(), obj.getLastName(), obj.getdOB(), obj.getEmail(),
                obj.getAddress(), obj.getTelephone());
        setDateEnrolled(obj.getDateEnrolled());
        setProgrammeCode(obj.getProgrammeCode());
        setEnrollmentStatus(obj.getEnrollmentStatus());
        setEnrolledCourses(obj.getEnrolledCourses());
        setUserType(obj.getUserType());
        setPassword(obj.getLastName() + obj.getStudentID());
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

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
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
