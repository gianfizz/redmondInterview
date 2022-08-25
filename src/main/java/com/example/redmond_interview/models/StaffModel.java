package com.example.redmond_interview.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StaffModel {

    @Id
    @GeneratedValue
    @Column(name = "file_Number")
    private Long fileNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    public Long getFileNumber() {
        return fileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
