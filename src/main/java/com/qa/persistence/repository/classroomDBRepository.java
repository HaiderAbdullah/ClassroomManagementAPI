package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class classroomDBRepository implements classroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Trainer a");
		Collection<Classroom> trainee = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(trainee);
	}

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Classroom cTrainee = util.getObjectForJSON(trainee, Classroom.class);
		manager.persist(cTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate) {
		Classroom updatedTrainer = util.getObjectForJSON(traineeToUpdate, Classroom.class);
		Classroom traineeFromDB = findTrainer(id);
		if (traineeToUpdate != null) {
			traineeFromDB = updatedTrainer;
			manager.merge(traineeFromDB);
		}
		return "{\"message\": \"trainee sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Classroom traineeInDB = findTrainer(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	private Classroom findTrainer(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	
}
