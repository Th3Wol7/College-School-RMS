package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "deptID")
    private String deptID;

    @Column(name = "deptName")
    private String deptName;

    @Column(name = "HeadOfDept")
    private String HOD;

    @Column(name = "location")
    private String location;

    public Department(){
        setDeptID("N/A");
        setDeptName("N/A");
        setHOD("N/A");
        setLocation("N/A");
    }

    public Department(String deptID, String deptName, String hOD, String location){
        setDeptID(deptID);
        setDeptName(deptName);
        setHOD(hOD);
        setLocation(location);
    }

    public Department(Department obj){
        setDeptID(obj.getDeptID());
        setDeptName(obj.getDeptName());
        setHOD(obj.getHOD());
        setLocation(obj.getLocation());
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHOD() {
        return HOD;
    }

    public void setHOD(String HOD) {
        this.HOD = HOD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptID='" + getDeptID() + '\'' +
                ", deptName='" + getDeptName() + '\'' +
                ", HOD='" + getHOD() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
