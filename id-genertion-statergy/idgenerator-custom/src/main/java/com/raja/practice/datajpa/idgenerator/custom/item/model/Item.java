package com.raja.practice.datajpa.idgenerator.custom.item.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Item {

    @GenericGenerator(name = "emp_pk_generator",strategy = "com.raja.practice.datajpa.idgenerator.custom.item.model.CustomItomPrimaryKeyGenerator")

    @GeneratedValue(generator = "emp_pk_generator")
    @Id
    private Integer id;

    @Column(name = "name")
    private String itemName;
}
