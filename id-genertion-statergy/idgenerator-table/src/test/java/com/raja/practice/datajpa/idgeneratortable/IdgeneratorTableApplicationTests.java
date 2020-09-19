package com.raja.practice.datajpa.idgeneratortable;

import com.raja.practice.datajpa.idgeneratortable.employee.model.Employee;
import com.raja.practice.datajpa.idgeneratortable.employee.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorTableApplicationTests {

	@Autowired
	EmployeeRepo empRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testIDGenerator(){
		Employee emp = new Employee();
		emp.setEmpName("SELVARAJ RAMAR");
		empRepo.save(emp);
	}
}
