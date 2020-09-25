package com.raja.practice.datajpa.jpqlandnativesql.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    private Integer score;
}
