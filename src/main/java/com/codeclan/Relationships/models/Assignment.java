package com.codeclan.Relationships.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    @JsonIgnoreProperties({"assignments"})
    Employee employee;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = true)
    @JsonIgnoreProperties({"assignments"})
    Project project;

    public Assignment(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
    }

    public Assignment() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
