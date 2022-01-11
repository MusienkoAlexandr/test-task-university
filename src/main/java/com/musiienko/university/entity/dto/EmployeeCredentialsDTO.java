package com.musiienko.university.entity.dto;

import lombok.Value;

/**
 * DTO-entity, derived from Employee entity, representing
 * credentials (full name) of the employee.
 */
@Value
public class EmployeeCredentialsDTO {
    String firstName;
    String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
