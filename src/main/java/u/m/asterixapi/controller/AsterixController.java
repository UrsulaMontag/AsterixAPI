package u.m.asterixapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.models.CharacterRepo;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final CharacterRepo characters;

    @GetMapping
    public List<Character> getCharacters() {
        return characters.findAll();
    }
}
