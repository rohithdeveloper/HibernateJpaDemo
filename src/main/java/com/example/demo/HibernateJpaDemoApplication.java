package com.example.demo;




import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@SpringBootApplication
public class HibernateJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao StudentDao) {
		return runner->{
			createStudent(StudentDao);
			readStudent(StudentDao);
			queryStudents(StudentDao);
			queryStudentsByLastName(StudentDao);
			updateStudent(StudentDao);
			
			
		};
		
	}
	private void updateStudent(StudentDao studentDao) {
		// TODO Auto-generated method stub
		
		// retrive student based on id
				int studentId=1;
				System.out.println("getting strudent with id"+studentId);
				Student myStudent=studentDao.findById(studentId);
				
				// updating student
				System.out.println("updating student");
				myStudent.setFirstName("Gurunath");
				
				// update student
				studentDao.update(myStudent);
				
				// display update student
				System.out.println("updated student:"+myStudent);
				System.out.println("updated successfully");
				System.out.println("------------------------------");

	}

	private void queryStudentsByLastName(StudentDao studentDao) {
		// TODO Auto-generated method stub
		System.out.println("Query students by last name");
		java.util.List<Student> theLastName=studentDao.findByLastName("Warner");
		for(Student tempStudent:theLastName) {
			System.out.println(tempStudent);
		}
		System.out.println("------------------------------");
	}

	private void queryStudents(StudentDao studentDao) {
		// TODO Auto-generated method stub
		System.out.println("Query students");
		java.util.List<Student> theStudent=studentDao.findAll();
		for(Student tempStudent:theStudent) {
			System.out.println(tempStudent);
		}
		System.out.println("------------------------------");
	}
	

	private void readStudent(StudentDao studentDao) {
		// TODO Auto-generated method stub
		// read student object
		System.out.println("creating 3 student object");
		Student tempStudent1=new Student("David","Warner","david@gmail.com");
		
		// save the student
		System.out.println("saving student");
		studentDao.save(tempStudent1);
		
		//display the id of studentid
		int theId=tempStudent1.getId();
		System.out.println("saved student: generatedId"+theId);
		
		// retriving student with id
		System.out.println("Retriving student with id: generatedId"+theId); 
		Student myStudent=studentDao.findById(theId);
		
		// display student
		System.out.println("found the student:"+myStudent);
		
		System.out.println("------------------------------");
		
	}

private void createStudent(StudentDao studentDao) {
		// TODO Auto-generated method stub
		//create student object
		System.out.println("creating new student object");
		Student tempStudent=new Student("rohith","parimella","rohith@gmail.com");
		
		
		// save the object
		System.out.println("saving student object");
		studentDao.save(tempStudent);
		
		System.out.println("------------------------------");
	}
}
