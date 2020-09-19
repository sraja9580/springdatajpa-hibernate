package com.raja.practice.datajpa.idgeneratortable.employee.repo;

import com.raja.practice.datajpa.idgeneratortable.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo  extends CrudRepository<Employee,Integer> {
}
