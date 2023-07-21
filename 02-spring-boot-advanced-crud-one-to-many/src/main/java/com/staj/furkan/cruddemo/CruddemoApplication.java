package com.staj.furkan.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.staj.furkan.cruddemo.dao.AppDAO;
import com.staj.furkan.cruddemo.entity.Course;
import com.staj.furkan.cruddemo.entity.Instructor;
import com.staj.furkan.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

		System.out.println("Done!");
	}

	
	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			
			//findInstructorById(appDAO);
			
			//deleteInstructorById(appDAO);
			
			//deleteInstructorDetailById(appDAO);
			
			addInstructorWithCourses(appDAO);
		};
	}


	private void addInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Furkan", "Demiryürek","demiryureekk@gmail.com");
		
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/furkanndemiryurekk","Video games");
	
		instructor.setInstructorDetail(instructorDetail);
		
		Course course1 = new Course("Temel Java Dersleri");
		Course course2 = new Course("İleri Seviye Java Dersleri");
		
		instructor.add(course1);
		instructor.add(course2);
		
		appDAO.save(instructor);
		
		System.out.println("Instructor added.");
	}


	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId = 2;
		
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.print("Instructor Detail deleted");
		
	}


	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 1;
		
		appDAO.deleteInstructorById(theId);
		
		System.out.print("Instructor deleted");
		
	}


	private void findInstructorById(AppDAO appDAO) {
		int theId = 3;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("Instructor  : " + tempInstructor);
		
		System.out.println("Instructor Detail : " + tempInstructor.getInstructorDetail());
		
	}


	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Deneme100", "Deneme100","Deneme100@gmail.com");
		
		InstructorDetail instructorDetail = new InstructorDetail("Deneme100.com","Deneme100");
	
		instructor.setInstructorDetail(instructorDetail);
		
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
	}
	

	
	
	
	
	
	
	
}
