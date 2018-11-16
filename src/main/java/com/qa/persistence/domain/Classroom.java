package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long Id;
	private String fullName;
	
	@OneToMany
	(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Trainee> trainer = new ArrayList<Trainee>();
	
	

	public Classroom() {

	}
	
	public Classroom(String fullName) {
		
		this.fullName = fullName;
		
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	

}
