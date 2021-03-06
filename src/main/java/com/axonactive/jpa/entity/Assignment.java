package com.axonactive.jpa.entity;

import com.axonactive.jpa.persistence.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assignment")
@NamedQueries({
        @NamedQuery(name = Assignment.GET_ALL, query = "from Assignment"),
        @NamedQuery(name = Assignment.GET_ASSIGNMENT_BY_ID, query = "from Assignment a where a.id = :assignmentId")
})
public class Assignment implements IEntity {

    private static final String QUALIFIER = "com.axonactive.jpa.entity";
    public static final String GET_ALL = QUALIFIER + "getAllAssignments";
    public static final String GET_ASSIGNMENT_BY_ID = QUALIFIER + "getAssignmentById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;
}
