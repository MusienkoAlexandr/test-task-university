package com.musiienko.testtaskuniversity.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


/**
 * Entity, representing Employee information:
 * First name, last name, salary, degree and departments.
 * Not using @GeneratedValue for @Id field due to next reasons:
 * - application is not updating tables' fields in database;
 * - for initializing database with data we use data.sql, so filling
 * fields with ids in "join"-columns is unnecessary difficult
 * (or, maybe, even impossible) with @GeneratedValue.
 */
@Entity
@Table(name = "employees", schema = "university")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Employee {
    @Id
    private Integer id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private BigDecimal salary;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Degree degree;
    @ManyToMany(mappedBy = "employees")
    @ToString.Exclude
    private List<Department> departments;

    enum Degree {
        ASSISTANT, ASSOCIATE_PROFESSOR, PROFESSOR
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;

        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return 949447908;
    }


}
