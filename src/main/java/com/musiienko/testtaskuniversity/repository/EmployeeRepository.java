package com.musiienko.testtaskuniversity.repository;

import com.musiienko.testtaskuniversity.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
