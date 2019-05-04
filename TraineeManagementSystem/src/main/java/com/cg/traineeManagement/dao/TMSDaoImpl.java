package com.cg.traineeManagement.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.traineeManagement.model.TraineeDetails;

@Component("tDao")
@Repository
@ComponentScan("com.cg.traineeManagement")
public class TMSDaoImpl implements TMSDao{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public int login(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		TraineeDetails td = entityManager.find(TraineeDetails.class, traineeDetails.getName());
		if(td.getPassword().equals(traineeDetails.getPassword())) {
			System.out.println("Login successful");
			return 1;
		}
		return 0;
	}
	@Override
	public int addTrainee(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		entityManager.persist(traineeDetails);
		return 0;
	}

	@Override
	public int updateTrainee(TraineeDetails traineeDetails) {
		// TODO Auto-generated method stub
		entityManager.merge(traineeDetails);
		return 0;
	}

	@Override
	public int deleteTrainee(int id) {
		// TODO Auto-generated method stub
		TraineeDetails traineeDetails =new TraineeDetails();
		traineeDetails.setId(id);
		entityManager.remove(getById(id));
		return 0;
	}

	@Override
	public ArrayList<TraineeDetails> getAll() {
		// TODO Auto-generated method stub
		Query query = (Query) entityManager.createQuery("from TraineeDetails");
		ArrayList<TraineeDetails> list = (ArrayList<TraineeDetails>) query.list();
		return list;
	}

	@Override
	public TraineeDetails getById(int id) {
		// TODO Auto-generated method stub
		TraineeDetails td=entityManager.find(TraineeDetails.class, id);
		return td;
	}

}
