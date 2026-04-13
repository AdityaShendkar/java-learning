package com.postgresqlcrud.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "student_mgmt")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int standard;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStandard() {
        return standard;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }
}