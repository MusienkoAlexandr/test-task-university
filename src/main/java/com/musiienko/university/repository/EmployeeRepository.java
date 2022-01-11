package com.musiienko.university.repository;

import com.musiienko.university.entity.Employee;
import com.musiienko.university.entity.dto.EmployeeCredentialsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository, containing operation, related to Employee entity:
 * - find employee (credentials) by string pattern in name;
 * As the application is not using any default CrudRepository-methods and
 * the custom method returns DTO-object - inheriting from CrudRepository,
 * parameterised with the Employee class, is more for hypothetical further scaling
 * and logical integrity of the application.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("SELECT new com.musiienko.university.entity.dto.EmployeeCredentialsDTO(e.firstName, e.lastName) FROM Employee e WHERE lower(concat(e.firstName, ' ', e.lastName)) LIKE %?1%")
    List<EmployeeCredentialsDTO> findByPattern(String pattern);
}
