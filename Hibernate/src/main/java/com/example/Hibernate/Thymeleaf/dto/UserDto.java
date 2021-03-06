package com.example.Hibernate.Thymeleaf.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotNull(message = "Name is mandatory")
    @Size(min=2,max = 30, message = "name should have at least 2 character")
	@Pattern(regexp="^[A-Za-z]*$", message = "Invalid Input")
	private String firstName;
	@NotNull(message = "Name is mandatory")
    @Size(min=2,max = 30, message = "name should have at least 2 character")
	@Pattern(regexp="^[A-Za-z]*$", message = "Invalid Input")
    private String lastName;
	@NotNull(message = "Email is mandatory")
    @Email
    private String emailId;
	@NotNull(message = "Phone number is mandatory.")
    @Size(min=10,max=10, message = "Phone number should be 10 digits.")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Invalid Phone number.")
    private String phone;
	@NotNull
	@Size(min=4, message = "min 4 char required")
    private String password;
    
    

	public UserDto() {
		super();
	}

	public UserDto(String firstName, String lastName, String emailId,
			String phone, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
	}



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
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
