package com.musiienko.university.service.impl;

import com.musiienko.university.entity.dto.DepartmentStatisticsElementDTO;
import com.musiienko.university.repository.DepartmentRepository;
import com.musiienko.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final String FIND_HEAD_ANSWER_POSITIVE_PATTERN = "Head of %s department is %s";
    private static final String GET_STATISTICS_ANSWER_POSITIVE_PATTERN = "Statistics of the department %s:\n" +
            "assistants - %s; associate professors - %s; professors - %s.";
    private static final String GET_NUMBER_OF_EMPLOYEES_ANSWER_POSITIVE_PATTERN = "The number of employees in the department %s: %s";
    private static final String GET_AVERAGE_SALARY_ANSWER_POSITIVE_PATTERN = "The average salary of %s is %s";
    private static final String GENERIC_ANSWER_NEGATIVE_PATTERN = "Could not find the department with name %s";

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(@Autowired DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String findHeadByDepartmentName(String departmentName) {
        return departmentRepository.findHeadForName(departmentName).map(
                        (cr) -> String.format(FIND_HEAD_ANSWER_POSITIVE_PATTERN, departmentName,
                                cr.getFullName()))
                .orElse(String.format(GENERIC_ANSWER_NEGATIVE_PATTERN, departmentName));

    }

    @Override
    public String getStatisticsByDepartmentName(String departmentName) {
        List<DepartmentStatisticsElementDTO> statistics = departmentRepository.getStatisticsForName(departmentName);
        return (statistics.isEmpty()) ? String.format(GENERIC_ANSWER_NEGATIVE_PATTERN, departmentName) :
                String.format(GET_STATISTICS_ANSWER_POSITIVE_PATTERN, departmentName,
                        statistics.get(0).getNumber(), statistics.get(1).getNumber(), statistics.get(2).getNumber());
    }

    @Override
    public String getNumberOfEmployeesByDepartmentName(String departmentName) {
        return departmentRepository.getEmployeeNumberForName(departmentName).map(
                        (n) -> String.format(GET_NUMBER_OF_EMPLOYEES_ANSWER_POSITIVE_PATTERN, departmentName, n))
                .orElse(String.format(GENERIC_ANSWER_NEGATIVE_PATTERN, departmentName));
    }

    @Override
    public String getAverageSalaryByDepartmentName(String departmentName) {
        return departmentRepository.getAverageSalaryForName(departmentName).map(
                        (avg) -> String.format(GET_AVERAGE_SALARY_ANSWER_POSITIVE_PATTERN, departmentName, avg))
                .orElse(String.format(GENERIC_ANSWER_NEGATIVE_PATTERN, departmentName));
    }
}
