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
 * <p>
 * Repository, containing operations, related to <b>Department</b> entity:
 * </p>
 * <ul>
 * <li>find head of the department by name;</li>
 * <li>get statistics (number of employees of each degree) for the department by name;</li>
 * <li>get average salary for the department by name;</li>
 * <li>get employee number for the department by name.</li>
 * </ul>
 * <p>
 * As the application is not using any default <b>CrudRepository</b>-methods and
 * every custom method returns DTO-object - inheriting from <b>CrudRepository</b>,
 * parameterised with the <b>Department</b> class, is more for hypothetical further scaling
 * and logical integrity of the application.
 * </p>
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Query("SELECT new com.musiienko.university.entity.dto.EmployeeCredentialsDTO(e.firstName, e.lastName) FROM Department d JOIN Employee e ON d.head=e WHERE d.name=?1")
    Optional<EmployeeCredentialsDTO> findHeadForName(String departmentName);

    @Query("SELECT new com.musiienko.university.entity.dto.DepartmentStatisticsElementDTO(e.degree, count(e)) FROM Employee e JOIN e.departments d WHERE d.name=?1 GROUP BY e.degree ORDER BY e.degree")
    List<DepartmentStatisticsElementDTO> getStatisticsForName(String departmentName);

    @Query("SELECT avg(e.salary) FROM Employee e JOIN e.departments d WHERE d.name=?1")
    Optional<BigDecimal> getAverageSalaryForName(String departmentName);

    @Query("SELECT count(e) FROM Employee e JOIN e.departments d WHERE d.name=?1")
    Optional<Long> getEmployeeNumberForName(String departmentName);

}
