package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Character>> getAllCharacters(){
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id){
        Character character = characterService.getCharacterById(id);
        if(character != null){
            return ResponseEntity.ok(character);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Character> createCharacter(@RequestBody Character character){
        Character createdCharacter = characterService.createCharacter(character);
        return ResponseEntity.ok(createdCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character updatedCharacter){
        Character character = characterService.updateCharacter(id, updatedCharacter);
        if(character != null){
            return ResponseEntity.ok(character);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/universe/{universe}")
    public ResponseEntity<List<Character>> getCharactersByUniverse(@PathVariable String universe){
        return ResponseEntity.ok(characterService.getCharactersByUniverse(universe));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Character>> getCharactersByRole(@PathVariable String role){
        return ResponseEntity.ok(characterService.getCharactersByRole(role));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Character>> getCharactersByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.getCharactersByName(name));
    }
}