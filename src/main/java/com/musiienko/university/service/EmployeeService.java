package com.musiienko.university.service;

/**
 * Service for Employee operations:
 * - search employee by string pattern in credentials.
 * All the data, retrieved from the database,
 * is processed to the specific String-format
 * of the response, that is further passed to the view layer.
 */
public interface EmployeeService {
    String searchByStringPattern(String pattern);
}
