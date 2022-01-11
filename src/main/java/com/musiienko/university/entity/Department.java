package com.musiienko.university.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity, representing Department information:
 * Department name, Head of the Department and employees.
 * Not using @GeneratedValue for @Id field due to next reasons:
 * - application is not updating tables' fields in database;
 * - for initializing database with data we use data.sql, so filling
 * fields with ids in "join"-columns is unnecessary difficult
 * (or, maybe, even impossible) with @GeneratedValue.
 */
@Table(name = "departments", schema = "university")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Department {
    @Id
    private Integer id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String name;
    @OneToOne(optional = false)
    private Employee head;
    @ManyToMany
    @ToString.Exclude
    private List<Employee> employees;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1487346027;
    }
}
