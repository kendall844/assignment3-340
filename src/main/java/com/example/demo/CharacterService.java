package com.example.demo;

import java.util.List;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

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
            character.setRole(updatedCharacter.getRole());
            return characterRepository.save(character);
        })
        .orElse(null);
    }

    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    public List<Character> getCharactersByRole(String role){
    return characterRepository.findByRole(role);
}

    public List<Character> getCharactersByName(String name){
        return characterRepository.findByNameContaining(name);
    }

    public List<Character> getCharactersByUniverse(String universe){
        return characterRepository.findByUniverse(universe);
    }

    public void savePicture(Character character, MultipartFile picture){
        if(picture == null || picture.isEmpty()){
            return;
        }
        String ogFile = picture.getOriginalFilename();
        try{
            if(ogFile != null && ogFile.contains(".")){
                String fileExt = ogFile.substring(ogFile.lastIndexOf(".") + 1);
                String fileName = String.valueOf(character.getCharacterId()) + "." + fileExt;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = picture.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                character.setPicturePath(fileName);
                characterRepository.save(character);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

