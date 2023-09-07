package model;

public class Student extends User {
    private String studentID;
    private StudentDetail details;

    //Primary Constructor
    public Student() {
        super();
        setUserType("Student");
        setDetails(new StudentDetail());
    }

    //Primary Constructor
    Student(String studentID, String firstName, String lastName, int dDay, int dMonth, int dYear,
            String streetNum, String streetName, String state, String country,
            String telephone, StudentDetail studentDetail) {
        super(studentID, firstName, lastName, dDay, dMonth, dYear, streetNum, streetName, state, country, telephone);
        setUserType("Student");
        setPassword(lastName + studentID);
        setDetails(studentDetail);
    }

    //Copy Constructor
    Student(Student obj) {
        super(obj.getStudentID(), obj.getFirstName(), obj.getLastName(), obj.getdOB(), obj.getAddress(), obj.getTelephone());
        setUserType(obj.getUserType());
        setPassword(obj.getLastName() + obj.getStudentID());
        setDetails(obj.getDetails());
    }


    //Getters and setters`
    public String getStudentID() {
        return super.getUserID();
    }

    public void setStudentID(String studentID) {
        super.setUserID(studentID);
    }

    public StudentDetail getDetails() {
        return details;
    }

    public void setDetails(StudentDetail details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + getStudentID() + '\'' +
                ", details=" + getDetails() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dOB=" + getdOB() +
                ", address=" + getAddress() +
                ", telephone='" + getTelephone() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", userType='" + getUserType() + '\'' +
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
