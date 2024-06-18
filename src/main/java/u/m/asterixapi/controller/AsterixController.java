package u.m.asterixapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.models.CharacterWithoutId;
import u.m.asterixapi.services.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final CharacterService characterService;

    @GetMapping
    public List<Character> getCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping()
    public Character createCharacter(@RequestBody CharacterWithoutId newCharacter) {
        return characterService.createCharacter(newCharacter);
    }

    @PutMapping
    public void updateCharacter(@RequestParam String id, @RequestBody CharacterWithoutId updatedCharacter) {
        characterService.updateCharacter(id, updatedCharacter);
    }

    @DeleteMapping
    public void deleteCharacter(@RequestParam String id) {
        characterService.deleteCharacter(id);
    }

}
