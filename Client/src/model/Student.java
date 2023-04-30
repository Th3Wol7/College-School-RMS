package model;

public class Student extends User {
    private String studentID;
    private StudentDetail details;

    //Primary Constructor
    public Student() {
        super();
        this.studentID = "N/A";
        this.userType = "Student";
        this.details = new StudentDetail();
    }

    //Primary Constructor
    Student(String firstName, String lastName, int dDay, int dMonth, int dYear,
            String streetNum, String streetName, String state, String country,
            String telephone, StudentDetail studentDetail) {
        super(firstName, lastName, dDay, dMonth, dYear, streetNum, streetName, state, country, telephone);
        setStudentID(studentID);
        this.userType = "Student";
        this.password = lastName + studentID;
        this.details = studentDetail;
    }

    //Copy Constructor
    Student(Student obj) {
        super(obj.firstName, obj.lastName, obj.dOB, obj.address, obj.telephone);
        setStudentID(obj.studentID);
        this.setUserType(obj.userType);
        this.setPassword(obj.lastName + obj.studentID);
        this.setDetails(obj.details);
    }


    //Getters and setters`
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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
                "studentID='" + studentID + '\'' +
                ", details=" + details +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dOB=" + dOB +
                ", address=" + address +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
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
