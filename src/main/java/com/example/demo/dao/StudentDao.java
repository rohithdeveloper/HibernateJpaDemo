package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDao {
	void save(Student thestudent);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
}
