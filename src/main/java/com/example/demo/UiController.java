package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/view/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        if (character != null) {
            model.addAttribute("character", character);
            model.addAttribute("title", "Character Details");
        } else {
            model.addAttribute("errorMessage", "Character not found");
            model.addAttribute("title", "Error");
            return "error";
        }
        return "details";
    }

    @GetMapping({ "/", "" })
    public String getAllCharacters(Model model) {
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
    public String addCharacter(Character character, MultipartFile picture) {

        Character newCharacter = characterService.createCharacter(character);

        if (newCharacter != null) {
            characterService.savePicture(newCharacter, picture);
            return "redirect:/characters/view/" + newCharacter.getCharacterId();
        } else {
            return "redirect:/characters/add?error=true";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCharacter(@PathVariable Long id,
            Character updatedCharacter,
            MultipartFile picture) {

        Character character = characterService.updateCharacter(id, updatedCharacter);

        if (character != null) {
            characterService.savePicture(character, picture);
            return "redirect:/characters/view/" + character.getCharacterId();
        } else {
            return "redirect:/characters/update/" + id + "?error=true";
        }
    }
}
