package com.example.Hibernate.Pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {
	
	@NotBlank
	private long zipCode;
    private String Address1;
    @NotBlank
    private String Address2;
    @NotBlank
    private String City;
    @NotBlank
    private String State;
    @NotBlank
    private String Country;
    private Candidate employee;
    
    

    public Address() {
		super();
	}
	public Address(long zipCode, String address1, String address2, String city, String state, String country,
			Candidate employee) {
		super();
		this.zipCode = zipCode;
		Address1 = address1;
		Address2 = address2;
		City = city;
		State = state;
		Country = country;
		this.employee = employee;
	}
	@Id
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name = "address1", nullable = false)
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	 
	@Column(name = "address2", nullable = false)
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	
	@Column(name = "city", nullable = false)
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	@Column(name = "state", nullable = false)
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	@Column(name = "country", nullable = false)
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	@OneToOne(mappedBy="address")
	public Candidate getEmployee() {
		return employee;
	}
	public void setEmployee(Candidate employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Address [Address1=" + Address1 + ", Address2=" + Address2 + ", City=" + City + ", State=" + State
				+ ", Country=" + Country + "]";
	}
    
    

}
