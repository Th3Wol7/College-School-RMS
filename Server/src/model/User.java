package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Users")
@Table(name = "Users")
@SecondaryTable(name = "Telephone", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID"))
public class User implements Serializable{
	@Id
	@Column(name = "ID")
	String userID;
	@Column(name = "firstName")
	protected String firstName;

	@Column(name = "lastName")
	protected String lastName;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	protected Date dOB;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "addressID")
	protected Address address;

	@Column(table = "Telephone", name = "phone")
	protected String telephone;

	@Column(name = "password")
	protected String password;

	@Column(name = "userType")
	protected String userType;
	
	//Default Constructor
	User(){
		setUserID("C!AN");
		setFirstName("N/A");
		setLastName("N/A");
		setEmail("N/A");
		setdOB(new Date());
		setAddress(new Address());
		setTelephone("N/A");
		setPassword(null);
	}
	
	//Primary Constructor
	 User(String userID, String firstName, String lastName, Date dOB, String email, Address address, String telephone) {
			setUserID(userID);
			setFirstName(firstName);
			setLastName(lastName);
			setdOB(dOB);
			setEmail(email);
			setAddress(address);
			setTelephone(telephone);
		}
	 
	 //Copy Constructor
	 User(User obj) {
		    setUserID(obj.getUserID());
			setFirstName(obj.getFirstName());
			setLastName(obj.getLastName());
			setdOB(obj.getdOB());
			setEmail(obj.getEmail());
			setAddress(obj.getAddress());
			setTelephone(obj.getTelephone());
			setPassword(obj.getPassword());
		}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	 //Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userID='" + userID + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dOB=" + dOB +
				", address=" + address +
				", telephone='" + telephone + '\'' +
				", password='" + password + '\'' +
				", userType='" + userType + '\'' +
				'}';
	}
}
