package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")

public class Character{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String universe;

    @Column(nullable = true)
    private double age;


    public Character(){
    }

    public Character(String name, String description, String universe, double age){
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.age = age;
    }

    public Character(Long characterId, String name, String description, String universe, double age){
        this.characterId = characterId;
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.age = age;
    }

    public Long getCharacterId(){
        return characterId;
    }

    public void setCharacterId(Long characterId){
        this.characterId = characterId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription (){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getUniverse (){
        return universe;
    }

    public void setUniverse(String universe){
        this.universe = universe;
    }

    public double getAge(){
        return age;
    }

    public void setAge(double age){
        this.age = age;
    }
}