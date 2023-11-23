package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "School")s
public class School {
    @Id
    @Column(name = "schoolCode")
    private String schoolCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "HeadOfSchool")
    private String HOS;

    @Column(name = "faculty")
    private String facultyCode;

    public School(){
        setSchoolCode("N/A");
        setName("N/A");
        setDescription("N/A");
        setHOS("N/A");
        setFacultyCode("N/A");
    }

    public School(String schoolCode, String name, String description, String HOS, String facultyCode){
        setSchoolCode(schoolCode);
        setName(name);
        setDescription(description);
        setHOS(HOS);
        setFacultyCode(facultyCode);
    }

    public School(School obj){
        setSchoolCode(obj.getSchoolCode());
        setName(obj.getName());
        setDescription(obj.getDescription());
        setHOS(obj.getHOS());
        setFacultyCode(obj.getFacultyCode());
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
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

    public String getHOS() {
        return HOS;
    }

    public void setHOS(String HOS) {
        this.HOS = HOS;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolCode='" + schoolCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", HOS='" + HOS + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                '}';
    }
}
