package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

@Query(value = "SELECT c.* FROM characters c WHERE c.name like %?1%", nativeQuery = true);
List<Character> findByName(String name);

@Query(value = "SELECT c.* FROM characters c WHERE c.age >= ?1", nativeQuery = true)
List<Character> findOlderCharacters(double age);

List<Character> findByUniverse(String universe);

    
}