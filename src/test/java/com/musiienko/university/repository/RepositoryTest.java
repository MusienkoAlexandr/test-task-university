package com.musiienko.university.repository;

import com.musiienko.university.entity.dto.DepartmentStatisticsElementDTO;
import com.musiienko.university.entity.dto.EmployeeCredentialsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class RepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(dataSource);
        assertNotNull(departmentRepository);
    }

    @Test
    void shouldFindHeadForCorrectDepartmentName() {
        Optional<EmployeeCredentialsDTO> expected = Optional.of(new EmployeeCredentialsDTO("Іванна", "Іванова"));
        Optional<EmployeeCredentialsDTO> actual = departmentRepository
                .findHeadForName("Механіко-математичний факультет");
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindHeadForWrongDepartmentName() {
        Optional<EmployeeCredentialsDTO> expected = Optional.empty();
        Optional<EmployeeCredentialsDTO> actual = departmentRepository
                .findHeadForName("Грифіндор");
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetStatisticsForCorrectDepartmentName() {
        List<DepartmentStatisticsElementDTO> actual = departmentRepository
                .getStatisticsForName("Механіко-математичний факультет");
        assertEquals(2, actual.get(0).getNumber());
        assertEquals(4, actual.get(1).getNumber());
        assertEquals(2, actual.get(2).getNumber());
    }

    @Test
    void shouldNotGetStatisticsForWrongDepartmentName() {
        List<DepartmentStatisticsElementDTO> actual = departmentRepository
                .getStatisticsForName("Гафелпаф");
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldGetAverageSalaryForCorrectDepartmentName() {
        assertEquals(Optional.of(new BigDecimal("16006.25")), departmentRepository
                .getAverageSalaryForName("Механіко-математичний факультет"));

    }

    @Test
    void shouldNotGetAverageSalaryForWrongDepartmentName() {
        assertEquals(Optional.empty(), departmentRepository
                .getAverageSalaryForName("Рейвенклов"));
    }

    @Test
    void shouldGetEmployeeNumberForCorrectDepartmentName() {
        assertEquals(8, departmentRepository
                .getEmployeeNumberForName("Механіко-математичний факультет"));
    }

    @Test
    void shouldNotGetEmployeeNumberForWrongDepartmentName() {
        assertEquals(0,
                departmentRepository.getEmployeeNumberForName("Слизерин"));
    }

    @Test
    void shouldFindEmployeesByCorrectPattern() {
        List<EmployeeCredentialsDTO> expected = List.of(new EmployeeCredentialsDTO("Павло", "Павлов"),
                new EmployeeCredentialsDTO("Гаврило", "Гаврилов"));
        List<EmployeeCredentialsDTO> actual = employeeRepository.findUsingPattern("ав");
        assertIterableEquals(expected, actual);
    }

    @Test
    void shouldNotFindEmployeesByWrongPattern() {
        List<EmployeeCredentialsDTO> actual = employeeRepository
                .findUsingPattern("HERE COME THE DRONES!");
        assertTrue(actual.isEmpty());
    }
}