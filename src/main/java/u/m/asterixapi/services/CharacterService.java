package u.m.asterixapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.repository.CharacterRepo;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepo characters;

    public List<Character> getAllCharacters() {
        return characters.findAll();
    }

    public Character createCharacter(Character newCharacter) {
        Character characterToCreate = new Character(
                UUID.randomUUID().toString(),
                newCharacter.name(),
                newCharacter.age(),
                newCharacter.occupation());
        return characters.save(characterToCreate);
    }
}
