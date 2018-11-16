package com.qa.persistence.repository;

public interface classroomRepository {
	
	String getAllTrainees();
	
    String createTrainee(String trainee);

	String updateTrainee(Long id, String traineeToUpdate);

	String deleteTrainee(Long id);

}
