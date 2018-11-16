package com.qa.persistence.domain;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Trainee {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String Name;

	public Trainee() {

	}

	public Trainee(String Name) {
		
		this.Name = Name;
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	

	
	
	

}
