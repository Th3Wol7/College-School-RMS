package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/*
 * This class represents the model of a staff member of the H&AI
 * institute. The private attributes represents the information
 * being stored about a staff member as their names implies data
 * The possible actions of each taff member is also native to the model.
 * @author Tyrien Gilpin
 * */
public class Staff extends User {
	private String staffID;
	private String faculty;
	private String department;
	private Date dateEmployed;
	
	//Default Constructor
	Staff() {
		super();
		setStaffID("N/A");
		setFaculty("N/A");
		setDepartment("N/A");
		setDateEmployed(new Date());
		setUserType("Staff");
	}
	
	//Primary Constructor
	Staff(String firstName, String lastName,int dDay, int dMonth, int dYear, 
			String streetNum, String streetName, String state, String country,
			String telephone, String faculty, String department, Date dateEmployed, String password) {
		super(firstName, lastName, dDay, dMonth, dYear, streetNum, streetName, state, country, telephone);
		setStaffID(getStaffID());
		setFaculty(faculty);
		setDepartment(department);
		setDateEmployed(dateEmployed);
		setUserType("Staff");
		setPassword(password);
	}
	
	//Copy Constructor
	Staff(Staff obj) {
		super(obj.firstName, obj.lastName, obj.dOB, obj.address, obj.telephone);
		setStaffID(obj.staffID);
		setFaculty(obj.faculty);
		setDepartment(obj.department);
		setDateEmployed(obj.dateEmployed);
		setUserType("Staff");
		setPassword(obj.password);
	}

	//Getters and Setters
	public String getStaffID() {
		return staffID;
	}
	
	public void setStaffID(String staffID) {
		Random random = new Random();
		int x = random.nextInt((200000)+1) + 1000000;
		staffID = String.valueOf(x);
		
		this.staffID = staffID;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateEmployed() {
		return dateEmployed;
	}

	public void setDateEmployed(Date dateEmployed) {
		this.dateEmployed = dateEmployed;
	}

	@Override
	public String toString() {
		return "Staff [getStaffID()=" + getStaffID() + ", getFaculty()=" + getFaculty() + ", getDepartment()="
				+ getDepartment() + ", getDateEmployed()=" + getDateEmployed() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getdOB()=" + getdOB() + ", getAddress()=" + getAddress()
				+ ", getTelephone()=" + getTelephone() + "]";
	}
	
	/*The system should accept student’s details and generate a 
	 * student record. The student id number should be generated 
	 * using the current year, programme code and a sequence that 
	 * starts at zero (0), and the enrollment status should be set to zero (0)*/
	
	
	//method to check if a programme exist
	public boolean checkprogrammeExistence(String code) {
			Scanner input = null;
			Scanner inFileStream = null;
			int maximumNumOfCourses;
			String programmeCode, programmeName, award, accreditation;
			try {
				input = new Scanner(System.in);
				inFileStream = new Scanner(new File ("Programme.dat"));
				
				while(inFileStream.hasNext()) {
					programmeCode = inFileStream.next();
					programmeName = inFileStream.next();
					award = inFileStream.next();
					accreditation = inFileStream.next();
					maximumNumOfCourses = inFileStream.nextInt();	

					if(code == programmeCode) {
						return true;
					}
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
					if(input != null) {
						input.close();
					}
					if (inFileStream!= null) {
						inFileStream.close();
					}
				}
			return false;
		}
		
	//Program to accept and generate a student
	public Student generateStudentData() {
		return null;
	}

	//Registering student and add data to file
	public boolean registerStudent() {	
		Student student = generateStudentData();
		
		FileWriter outFileStream1 = null, outFileStream2 = null;
		try { 
			outFileStream1 = new FileWriter(new File("Students.dat"), true);
			outFileStream2 = new FileWriter(new File("StudentsEnrolled.dat"), true);
		
			//String registerStudent = student.getStudentID() + "\t" + student.getFirstName() + " " + student.getLastName() + "\t" +
			//				student.getdOB()  + "\t" +  student.getTelephone()  + "\t" + student.getAddress()+ "\t" + student.getProgrammeCode()+
			//				"\t" + student.getPassword();
			
			//String studentEnrolled =  student.getStudentID() + "\t" + student.getFirstName() + " " + student.getLastName() + "\t" +
			//						student.getProgrammeCode()+ "\t" + student.getDateEnrolled() + student.getEnrollementStatus();
			
			//outFileStream1.write(registerStudent);
			//outFileStream2.write(studentEnrolled);
			
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(outFileStream1 != null || outFileStream2 != null) {
				try {
					outFileStream1.close();
					outFileStream2.close();
				}catch(IOException e) {
					e.printStackTrace();
				}		
			}
		}
		return false;
	}
	
	
	
	
	public void createProgram() {}
	public void modifyProgramDetails() {}
	
	
	//the system should accept a programme code then displays 
	//the list of student currently enrolled in the programme
	public void generateStudentList() {}
	
	
	
	//The system should display all courses in the programme
	public void viewProgrammeDetails() {}
	//File types: Staff, Student, Course, Programme

}
