package com.staj.furkan.cruddemo.dao;

import java.util.List;

import com.staj.furkan.cruddemo.entity.Instructor;

public interface AppDAO {

	void save(Instructor instrucotr);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
	
	void deleteInstructorDetailById(int id);
	
	
}
