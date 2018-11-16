package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String fullName;
	

	public Trainer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Trainer(String fullName) {
		this.fullName = fullName;
		
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", fullName=" + fullName + ", getId()=" + getId() + ", getFullName()="
				+ getFullName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
