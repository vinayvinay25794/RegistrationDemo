package com.example.Hibernate.Pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "candidate")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name="findCandidates",
			procedureName = "find_candidate",
			resultClasses = {Candidate.class}
			//parameters = {@StoredProcedureParameter()})
)})
public class Candidate {

	private long id;
	
    private String firstName;
	
    private String lastName;
    private Date dateOfBirth;
	
    private String applyingForPosition;
	
    private String emailId;
	
    private String phone;

    private String linkedIn;
    private Address address;
   
    
	public Candidate() {
		super();
	}
	public Candidate(String firstName, String lastName, Date dateOfBirth, String applyingForPosition, String emailId,
			String phone, String linkedIn, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.applyingForPosition = applyingForPosition;
		this.emailId = emailId;
		this.phone = phone;
		this.linkedIn = linkedIn;
		this.address = address;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	@NotNull(message = "Name is mandatory ")
	@Size(min=2,  message =  "min 2 char required")
	@Pattern(regexp="^[A-Za-z]*$", message = "Invalid Input")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	@NotNull(message = "Name is mandatory ")
	@Size(min=2,  message =  "min 2 char required")
	@Pattern(regexp="^[A-Za-z]*$", message = "Invalid Input")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DateTimeFormat(iso=ISO.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "position")
	@NotNull(message = "position is mandatory ")
	public String getApplyingForPosition() {
		return applyingForPosition;
	}
	public void setApplyingForPosition(String applyingForPosition) {
		this.applyingForPosition = applyingForPosition;
	}
	
	@Column(name = "email_address", nullable = false)
	@NotNull(message = "Email is mandatory ")
	@Email
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "phoneNo", nullable = false)
	@NotNull(message = "Phone is mandatory ")
	@Size(min = 10,max = 10, message = "Enter valid phone number")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Invalid Type Input")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "LinkedIn", nullable = true)
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	@OneToOne
	@JoinColumn(name="zip_code")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Candidate [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", applyingForPosition=" + applyingForPosition + ", emailId=" + emailId + ", phone=" + phone
				+ ", linkedIn=" + linkedIn + ", address=" + address + "]";
	}
    
}
