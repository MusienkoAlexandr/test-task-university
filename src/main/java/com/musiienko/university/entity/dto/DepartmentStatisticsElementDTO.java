package com.musiienko.university.entity.dto;

import com.musiienko.university.entity.Employee;
import lombok.Value;

/**
 * DTO-entity, derived from Department entity, representing partial statistics
 * (number of employees with the specific degree) of the department.
 */
@Value
public class DepartmentStatisticsElementDTO {
    Employee.Degree degree;
    Long number;
}
