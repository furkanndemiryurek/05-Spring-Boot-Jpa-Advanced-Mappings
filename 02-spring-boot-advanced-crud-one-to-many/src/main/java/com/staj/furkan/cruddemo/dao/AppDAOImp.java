package com.staj.furkan.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.staj.furkan.cruddemo.entity.Instructor;
import com.staj.furkan.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class AppDAOImp implements AppDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public AppDAOImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}



	@Override
	public Instructor findInstructorById(int id) {
		return entityManager.find(Instructor.class,id);
	}



	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor tempInstructor = findInstructorById(id);
		entityManager.remove(tempInstructor);
	}



	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
		
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		entityManager.remove(tempInstructorDetail);
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
