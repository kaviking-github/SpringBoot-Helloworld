package com.boot1.kavi.User.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User{

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Username is mandatory field")
	@Column(name="USER_NAME",length=50, nullable=false, unique=true)
	private String userName;
	
	@Size(min=2, message="FirstName should have atleast 2")
	@Column(name="FIRST_NAME",length=50, nullable=false)
	private String firsName;
	
	@Column(name="LAST_NAME",length=50, nullable=false)
	private String lastName;
	
	@Column(name="EMAIL",length=50, nullable=false)
	private String email;
	
	@Column(name="ROLE",length=50, nullable=false)
	private String role;
	
	@Column(name="SSN",length=100, nullable=false, unique=true)
	private String ssn;

	//No argument constructor
	public User() {
		
	}

	//Field constructor
	public User(Long id, String userName, String firsName, String lastName, String email, String role, String ssn) {
		this.id = id;
		this.userName = userName;
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firsName=" + firsName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
}
