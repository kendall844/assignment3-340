package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")

public class Character {

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
    private String role;

    private String picturePath;

    public Character() {
    }

    public Character(String name, String description, String universe, String role) {
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.role = role;
    }

    public Character(Long characterId, String name, String description, String universe, String role) {
        this.characterId = characterId;
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.role = role;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}