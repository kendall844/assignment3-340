package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterRepository extends JpaRepository<Character, Long> {

@Query(value = "SELECT c.* FROM characters c WHERE c.name like %?1%", nativeQuery = true)
List<Character> findByName(String name);

List<Character> findByNameContaining(String name);

List<Character> findByRole(String role);

List<Character> findByUniverse(String universe);

    
}