package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;


import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class classroomMapRepository implements classroomRepository {
	
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Trainee> trainee;
	private Long ID;

	@Inject
	private JSONUtil util;
	
	
	public classroomMapRepository() {
		this.trainee = new HashMap<Long, Trainee>();
		ID = INITIAL_COUNT;
		createTraineeMap();
	}

	public String getAllTrainees() {
		return util.getJSONForObject(trainee.values());
	}

	
	public String createTrainee(String trainee) {
		ID++;
		Trainee newTrainee = util.getObjectForJSON(trainee, Trainee.class);
        this.trainee.put(ID, newTrainee);
		return trainee;
	}

	public String updateTrainee(Long id, String traineeToUpdate) {
		Trainee newTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		trainee.put(id, newTrainee);
		return traineeToUpdate;
	}

	public String deleteTrainee(Long id) {
		trainee.remove(id);
		return "{\"message\": \"trainee sucessfully removed\"}";
	}

	private void createTraineeMap() {
		Trainee Trainee = new Trainee("Abdullah Haider");
		trainee.put(1L, Trainee);
	}

}
