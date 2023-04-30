package com.example.meditationsrest_main.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Category() {

    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category orElseThrow(Throwable e) throws Throwable {
        throw e;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}