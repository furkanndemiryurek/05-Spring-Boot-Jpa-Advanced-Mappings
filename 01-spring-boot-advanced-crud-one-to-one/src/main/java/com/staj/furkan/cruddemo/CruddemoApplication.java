package com.staj.furkan.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.staj.furkan.cruddemo.dao.AppDAO;
import com.staj.furkan.cruddemo.entity.Instructor;
import com.staj.furkan.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	
	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			
			//findInstructorById(appDAO);
			
			//deleteInstructorById(appDAO);
			
			deleteInstructorDetailById(appDAO);

		};
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
