package com.musiienko.testtaskuniversity.repository;

import com.musiienko.testtaskuniversity.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
