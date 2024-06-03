package com.antriksh1994.cruddemo;

import com.antriksh1994.cruddemo.dao.StudentDAO;
import com.antriksh1994.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			// custom code
			System.out.println("Hello world!!");
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students: ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted count: "+ numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}


	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("Updated student..." + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Bruce");
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Create new student");
		Student tempStudent = new Student("Bruce", "Wanye", "wayne@gmail.com");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("Id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Student: "+ myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Create new student");
		Student tempStudent = new Student("Paul", "Doe", "paul.deo@gmail.com");

		// save the student object
		studentDAO.save(tempStudent);
		// display id of saved student
		System.out.println("Saved student. Generate id: " + tempStudent.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Prasad", "Antriksh", "antriksh1994@gmail.com");
		Student tempStudent2 = new Student("Singh", "Lucky", "prasad@gmail.com");
		Student tempStudent3 = new Student("Wayne", "Bruce", "prasad@gmail.com");
		Student tempStudent4 = new Student("Dent", "Harvy", "prasad@gmail.com");

		// save the student object
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		System.out.println("Create multiple students: ");
	}
}
