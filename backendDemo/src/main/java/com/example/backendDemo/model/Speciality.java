package com.example.backendDemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "specialities")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
