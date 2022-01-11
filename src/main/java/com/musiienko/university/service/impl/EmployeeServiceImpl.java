package com.musiienko.university.service.impl;

import com.musiienko.university.entity.dto.EmployeeCredentialsDTO;
import com.musiienko.university.repository.EmployeeRepository;
import com.musiienko.university.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String SEARCH_ANSWER_NEGATIVE_PATTERN = "No results found.";
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String searchByStringPattern(String pattern) {
        List<EmployeeCredentialsDTO> results = employeeRepository.findUsingPattern(pattern);
        if (results.isEmpty()) return SEARCH_ANSWER_NEGATIVE_PATTERN;
        StringBuilder answer = new StringBuilder("Results: ");
        answer.append(results.get(0).getFullName());
        for (int i = 1; i < results.size(); i++) {
            answer.append(", ");
            answer.append(results.get(i).getFullName());
        }
        answer.append(".");
        return answer.toString();
    }
}
