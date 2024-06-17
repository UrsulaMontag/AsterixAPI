package u.m.asterixapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import u.m.asterixapi.models.Character;
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

    @PostMapping
    public Character createCharacter(@RequestBody Character newCharacter) {
        return characterService.createCharacter(newCharacter);
    }
}
