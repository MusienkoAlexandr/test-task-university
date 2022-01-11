package com.musiienko.university.repository;

import com.musiienko.university.entity.Department;
import com.musiienko.university.entity.dto.DepartmentStatisticsElementDTO;
import com.musiienko.university.entity.dto.EmployeeCredentialsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repository, containing operations, related to Department entity:
 * - find head of the department by name;
 * - get statistics (number of employees of each degree) for the department by name;
 * - get average salary for the department by name;
 * - get employee number for the department by name;
 * As the application is not using any default CrudRepository-methods and
 * every custom method returns DTO-object - inheriting from CrudRepository,
 * parameterised with the Department class, is more for hypothetical further scaling
 * and logical integrity of the application.
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Query("SELECT new com.musiienko.university.entity.dto.EmployeeCredentialsDTO(e.firstName, e.lastName) FROM Department d JOIN Employee e ON d.head=e WHERE d.name=?1")
    Optional<EmployeeCredentialsDTO> findHeadForName(String departmentName);

    @Query("SELECT new com.musiienko.university.entity.dto.DepartmentStatisticsElementDTO(e.degree, count(e)) FROM Employee e JOIN e.departments d WHERE d.name=?1 GROUP BY e.degree")
    List<DepartmentStatisticsElementDTO> getStatisticsForName(String departmentName);

    @Query("SELECT avg(e.salary) FROM Employee e JOIN e.departments d WHERE d.name=?1")
    Optional<BigDecimal> getAverageSalaryForName(String departmentName);

    @Query("SELECT count(e) FROM Employee e JOIN e.departments d WHERE d.name=?1")
    Optional<Long> getEmployeeNumberForName(String departmentName);

}
