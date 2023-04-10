package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	//define field for entity
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	// implement the save method
	@Override
	@Transactional
	public void save(Student thestudent) {
		// TODO Auto-generated method stub
		entityManager.persist(thestudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
		//TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName asc",Student.class);
		
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);
		
		theQuery.setParameter("theData", theLastName);
		
		return theQuery.getResultList(); 
	}
	
	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
	}



}
