package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/characters")
public class UiController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        model.addAttribute("foundCharacter", character);
        if (character != null) {
            return "details";
        } else {
            return "about";
        }
    }

    @GetMapping("/all")
    public String getAllCharacters(Model model){
        model.addAttribute("gallery", characterService.getAllCharacters());
        return "gallery";
    }

        @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("character", new Character());
        model.addAttribute("title", "Add Your Own Character");
        return "new-character-form";
    }

    @PostMapping("/")
    public String addCharacter(Character character, MultipartFile picture){
        Character newCharacter = characterService.createCharacter(character);
        if (newCharacter != null) {
            characterService.savePicture(character, picture);
            return "redirect:/all" + newCharacter.getCharacterId();
        }else{
        return "redirect:/characters/add?error=true";
        }
    }


}
