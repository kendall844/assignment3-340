package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/chacters")
public class CharacterController {
    
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Character>>getAllCharacters(){
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
            Character createdCharacter = characterService.createdCharacter(character);
            if (createdCharacter != null){
                return ResponseEntity.ok(createdCharacter);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
    }

