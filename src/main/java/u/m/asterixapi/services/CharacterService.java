package u.m.asterixapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u.m.asterixapi.models.ChangeModels;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.models.CharacterWithoutId;
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

    public Character getCharacterById(String id) {
        return characters.findById(id).orElseThrow();

    }

    public Character createCharacter(CharacterWithoutId character) {
        Character characterToCreate = ChangeModels.characterWithoutIdToCharacter(character);
        return characters.save(characterToCreate);
    }

    public void updateCharacter(String id, CharacterWithoutId character) {
        if (characters.existsById(id)) {
            Character characterToUpdate = characters.findById(id)
                    .orElseThrow()
                    .withName(character.name())
                    .withAge(character.age())
                    .withOccupation(character.occupation());
            characters.save(characterToUpdate);
        }
    }

    public void deleteCharacter(String id) {
        if (characters.existsById(id)) {
            characters.delete(characters.findById(id).orElseThrow());
        }
    }
}
