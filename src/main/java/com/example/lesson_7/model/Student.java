package com.example.lesson_7.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
