package com.registration.teacher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Pojo class

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message="Name is mandatory")
	@Pattern(regexp="^[A-Z][a-z]{3,20}",message = "length must be in between 3 to 20")
	private String name;
	
	@NotBlank(message="Email is mandatory")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
	private String email;
	
	@NotBlank(message="Password is mandatory")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message = "enter password in valid format")
	private String password;
	
	@NotBlank(message="Address is mandatory")
	@Size(min = 5,max = 30)
	private String address;
	
	@NotBlank(message="Need to enter contact details")
	@Pattern(regexp="^[7-9][0-9]{9}$",message = "enter 10 digit mobile number")
	private String contact;
	
	@NotBlank(message="Designation is mandatory")
	@Size(min = 3,max = 20)
	private String designation;
	
	@NotBlank(message="Qualification is mandatory")
	@Size(min = 3,max = 20)
	private String qualification;
	
	public Teacher() {
		
	}
	
	public Teacher(int id, String name, String email,String password, String address, String contact, String designation,
			String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.designation = designation;
		this.qualification = qualification;
	}



	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ",password=" + password+ ", poaddress=" + address + ", contact="
				+ contact + ", designation=" + designation + ", qualification=" + qualification + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Teacher orElseThrow() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
