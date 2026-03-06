package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    public Character createCharacter(Character character){
        return characterRepository.save(character);
    }

    public Character getCharacterById(Long id){
        return characterRepository.findById(id).orElse(null);
    }

    public Character updateCharacter(Long id, Character updatedCharacter){
        return characterRepository.findById(id)
        .map(character -> {
            character.setName(updatedCharacter.getName());
            character.setDescription(updatedCharacter.getDescription());
            character.setUniverse(updatedCharacter.getUniverse());
            character.setAge(updatedCharacter.getAge());
            return characterRepository.save(character);
        })
        .orElse(null);
    }

    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    public List<Character> getOlderCharacters(double age){
        return characterRepository.findOlderCharacters(age);
    }

    public List<Character> getCharactersByName(String name){
        return characterRepository.findByName(name);
    }

    public List<Character> getCharactersByUniverse(String universe){
        return characterRepository.findByUniverse(universe);
    }
}
