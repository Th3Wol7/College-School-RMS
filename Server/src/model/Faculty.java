package model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Faculty {
    @Id
    @Column(name = "facultyCode")
    private String facultyCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "HeadOfFaculty")
    private String HOF;

    @Column(name = "NumOfSchools")
    private int numOfSchools;

    public Faculty(){
        setFacultyCode("N/A");
        setName("N/A");
        setDescription("N/A");
        setHOF("N/A");
        setNumOfSchools(-1);
    }

    public Faculty(String facultyCode, String name, String description, String HOF, int numOfSchools){
        setFacultyCode(facultyCode);
        setName(name);
        setDescription(description);
        setHOF(HOF);
        setNumOfSchools(numOfSchools);
    }

    public Faculty(Faculty obj){
        setFacultyCode(obj.getFacultyCode());
        setName(obj.getName());
        setDescription(obj.getDescription());
        setHOF(obj.getHOF());
        setNumOfSchools(obj.getNumOfSchools());
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHOF() {
        return HOF;
    }

    public void setHOF(String HOF) {
        this.HOF = HOF;
    }

    public int getNumOfSchools() {
        return numOfSchools;
    }

    public void setNumOfSchools(int numOfSchools) {
        this.numOfSchools = numOfSchools;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyCode='" + getFacultyCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", HOF='" + getHOF() + '\'' +
                ", numOfSchools=" + getNumOfSchools() +
                '}';
    }
}
