package com.musiienko.university.service;

import com.musiienko.university.controller.ConsoleRequest;

/**
 * <p>
 * Service for <b>Department</b> operations:
 * </p>
 * <ul>
 * <li>find head of the department by name;</li>
 * <li>get statistics (number of employees of each degree) for the department by name;</li>
 * <li>get average salary for the department by name;</li>
 * <li>get employee number for the department by name.</li>
 * </ul>
 * <p>
 * All the data, retrieved from the database,
 * is processed to the specific <b>String</b>-format
 * of the response, that is further passed to the view layer.
 * </p>
 */
public interface DepartmentService extends GenericService {
    @ConsoleRequest("Who is head of department {department_name}")
    String findHeadByDepartmentName(String departmentName);
    @ConsoleRequest("Show {department_name} statistics")
    String getStatisticsByDepartmentName(String departmentName);
    @ConsoleRequest("Show count of employee for {department_name}")
    String getNumberOfEmployeesByDepartmentName(String departmentName);
    @ConsoleRequest("Show the average salary for the department {department_name}")
    String getAverageSalaryByDepartmentName(String departmentName);
}
