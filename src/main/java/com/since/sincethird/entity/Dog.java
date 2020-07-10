package com.since.sincethird.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Dog {
    @Id
    Integer id;
    String name;
    String legs;
}
