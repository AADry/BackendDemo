package com.example.backendDemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="visas")
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "visaType")
    private String type;



}
