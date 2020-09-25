package com.raja.practice.datajpa.jpqlandnativesql;

import com.raja.practice.datajpa.jpqlandnativesql.entities.Student;
import com.raja.practice.datajpa.jpqlandnativesql.repos.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
class JpqlAndNativeSqlApplicationTests {

	@Autowired
	StudentRepo studentRepo;

	@Test
	void testStudentCreate() {
		/*Student student = new Student();
		student.setFirstName("RAJA");
		student.setLastName("SELVARAJ");
		student.setScore(89);

		Student student1 = new Student();
		student1.setFirstName("ABINESH");
		student1.setLastName("SHANMUGM");
		student1.setScore(75);

		Student student2 = new Student();
		student2.setFirstName("KARTHIK");
		student2.setLastName("ASHOK");
		student2.setScore(86);

		Student student3 = new Student();
		student3.setFirstName("ARUN");
		student3.setLastName("JAYAPAL");
		student3.setScore(65);

		studentRepo.save(student);
		studentRepo.save(student1);
		studentRepo.save(student3);
		studentRepo.save(student2);*/
	}

	@Test
	void testGetAllStudents(){
		System.out.println("************ testGetAllStudents START ************");
		studentRepo.getAllStudents().forEach(System.out::println);
		System.out.println("************ testGetAllStudents END ************");
	}

	@Test
	void getAllStudentsPartialData(){
		System.out.println("************ getAllStudentsPartialData START ************");
		studentRepo.getAllStudentsPartialData().forEach(student-> System.out.println(student[0]+" "+student[1]+" "+student[2]));
		System.out.println("************ getAllStudentsPartialData END ************");
	}

	@Test
	void getAllStudentsWithLastName(){
		System.out.println("************ getAllStudentsWithLastName START ************");
		studentRepo.getAllStudentsWithLastName("SELVARAJ").forEach(System.out::println);
		System.out.println("************ getAllStudentsWithLastName END ************");
	}

	@Test
	void getAllStudentsBetweenScoreRange(){
		System.out.println("************ getAllStudentsBetweenScoreRange START ************");
		studentRepo.getAllStudentsBetweenScoreRange(80,95).forEach(System.out::println);
		System.out.println("************ getAllStudentsBetweenScoreRange END ************");
	}

	@Test
	@Transactional //TO RUN DML
	//@Rollback(false) //IN TEST SPRING REVERTS ALL DML OPERATION AFTER THE EXECUTION,IF YOU WANT TO REALY DELETE DATA THEN USE ROLLBACK FALSE
	void testdeleteStudentByLastName(){
		System.out.println("************ deleteStudentByLastName START ************");
		studentRepo.deleteStudentByLastName("ASHOK");
		System.out.println("************ deleteStudentByLastName END ************");
	}

	//PAGING
	@Test
	void getAllStudentsWithPagingAndSorting(){
		System.out.println("************ getAllStudentsWithPagingAndSorting START ************");
		System.out.println("PAGE 1");
		Pageable pageable = PageRequest.of(0,3,Sort.by(Sort.Order.desc("score"),Sort.Order.asc("firstName")));
		studentRepo.getAllStudentsWithPagingAndSorting(pageable).forEach(System.out::println);

		System.out.println("PAGE 2");
		pageable = PageRequest.of(1,3,Sort.by(Sort.Order.desc("score"),Sort.Order.asc("firstName")));
		studentRepo.getAllStudentsWithPagingAndSorting(pageable).forEach(System.out::println);

		System.out.println("************ getAllStudentsWithPagingAndSorting END ************");
	}

	//NATIVE QUERY
	@Test
	void testgetAllStudentsWithLastNameNativeQuery(){
		System.out.println("************ testgetAllStudentsWithLastNameNativeQuery START ************");
		studentRepo.getAllStudentsWithLastNameNativeQuery("SELVARAJ").forEach(System.out::println);
		System.out.println("************ testgetAllStudentsWithLastNameNativeQuery END ************");
	}
}
