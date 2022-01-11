package com.musiienko.university.service;

/**
 * Service for Department operations:
 * - find head of the department by name;
 * - get statistics (number of employees of each degree) for the department by name;
 * - get average salary for the department by name;
 * - get employee number for the department by name.
 * All the data, retrieved from the database,
 * is processed to the specific String-format
 * of the response, that is further passed to the view layer.
 */
public interface DepartmentService {
    String findHeadByDepartmentName(String departmentName);
    String getStatisticsByDepartmentName(String departmentName);
    String getNumberOfEmployeesByDepartmentName(String departmentName);
    String getAverageSalaryByDepartmentName(String departmentName);
}
