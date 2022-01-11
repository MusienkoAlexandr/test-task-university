package com.musiienko.university.service;

import com.musiienko.university.controller.ConsoleRequest;

/**
 * <p>
 * Service for <b>Employee</b> operations:
 * </p>
 * <ul>
 * <li>search employee by string pattern in credentials.</li>
 * </ul>
 * <p>
 * All the data, retrieved from the database,
 * is processed to the specific <b>String</b>-format
 * of the response, that is further passed to the view layer.
 * </p>
 */
public interface EmployeeService extends GenericService {
    @ConsoleRequest("Global search by {template}")
    String searchByStringPattern(String pattern);
}
