package com.musiienko.university.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


/**
 * <p>
 * Entity, representing Department information:
 * </p>
 * <p>
 * First name, last name, degree, salary and departments.
 * </p>
 * <p>
 * Not using <b>@GeneratedValue</b> for <b>@Id</b> field due to next reasons:
 * </p>
 * <ul>
 * <li>application is not updating tables' fields in database;</li>
 * <li>for initializing database with data we use data.sql, so filling
 * fields with ids in "join"-columns is unnecessary difficult
 * (or, maybe, even impossible) with <b>@GeneratedValue</b>.</li>
 * </ul>
 */
@Entity
@Table(name = "employees")
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

    public enum Degree {
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
