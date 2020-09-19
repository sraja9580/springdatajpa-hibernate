package com.raja.practice.datajpa.idgeneratortable.employee.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Employee {

    //create table id_gen(gen_name varchar(60) PRIMARY KEY,gen_val int(20))
    @TableGenerator(name = "emp_pk_generator",table = "id_gen",pkColumnName = "gen_name",valueColumnName ="gen_val",allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.TABLE,generator = "emp_pk_generator")
    @Id
    private Integer id;

    @Column(name = "name")
    private String empName;
}
