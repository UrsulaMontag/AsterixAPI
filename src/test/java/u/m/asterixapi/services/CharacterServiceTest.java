package u.m.asterixapi.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.models.CharacterWithoutId;
import u.m.asterixapi.repository.CharacterRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CharacterServiceTest {
    //Class to be tested
    private static CharacterService characterService;

    //Dependencies (will be mocked)
    private static CharacterRepo mockCharacterRepo;
    private static UtilService mockUtilService;

    //Test data
    private static List<Character> testCharacters;


    @BeforeAll
    static void setUpCharacters() {
        mockCharacterRepo = mock(CharacterRepo.class);
        mockUtilService = mock(UtilService.class);
        characterService = new CharacterService(mockCharacterRepo, mockUtilService);
        testCharacters = new ArrayList<>() {{
            add(new Character("1", "Asterix", 35, "Krieger"));
            add(new Character("2", "Obelix", 35, "Lieferant"));
            add(new Character("3", "Miraculix", 60, "Druide"));
        }};
    }

    @Test
    void getAllCharacters_returnsListOfCharacters() {
        //Given
        when(mockCharacterRepo.findAll()).thenReturn(testCharacters);

        //When
        characterService.getAllCharacters();
        //Then
        verify(mockCharacterRepo).findAll();
    }

    @Test
    void getCharacterById_returnsCharacter_foundByGivenId() {
        when(mockCharacterRepo.findById("2")).thenReturn(Optional.of(testCharacters.get(1)));
        characterService.getCharacterById("2");
        verify(mockCharacterRepo).findById("2");
    }

    @DirtiesContext
    @Test
    void createCharacter_returnsNewCharacter_withGivenParams() {
        CharacterWithoutId testCharacter = new CharacterWithoutId("postTest", 1, "Tester");
        Character expected = new Character("123", testCharacter.name(), testCharacter.age(), testCharacter.occupation());
        when(mockUtilService.generateId()).thenReturn("123");
        when(mockCharacterRepo.save(expected)).thenReturn(expected);
        characterService.createCharacter(testCharacter);
        verify(mockCharacterRepo).save(expected);
    }

    @DirtiesContext
    @Test
    void updateCharacter() {
        CharacterWithoutId testCharacter = new CharacterWithoutId("putTest", 52, "Tester");
        String testId = "3";
        Character expected = new Character(testId, testCharacter.name(), testCharacter.age(), testCharacter.occupation());
        when(mockCharacterRepo.existsById(testId)).thenReturn(true);
        when(mockCharacterRepo.findById(testId)).thenReturn(Optional.of(new Character(testId, testCharacter.name(), testCharacter.age(), testCharacter.occupation())));

        characterService.updateCharacter(testId, testCharacter);
        verify(mockCharacterRepo).save(expected);

    }

    @DirtiesContext
    @Test
    void deleteCharacter() {

    }
}