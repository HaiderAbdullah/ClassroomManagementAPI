package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.classroomRepository;



public class classroomServicempl implements classroomService {

	@Inject
	private classroomRepository repo;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String addTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

	
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
		
	} 

	public void setRepo(classroomRepository repo) {
		this.repo = repo;
	}

}
