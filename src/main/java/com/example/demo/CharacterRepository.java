package com.example.demo;

import java.util.List;

import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    
}