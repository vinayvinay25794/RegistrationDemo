package com.example.Hibernate.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;

@Entity
@Table(name="role")
public class Role {

	private long id;
	@NotBlank(message = "Name is mandatory")
	private String rName;
	
	public Role() {
		
	}
	
	public Role(String rName) {
		super();
		this.rName = rName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	
	
}
