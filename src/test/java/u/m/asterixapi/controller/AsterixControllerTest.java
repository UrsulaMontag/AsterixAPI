package u.m.asterixapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import u.m.asterixapi.models.Character;
import u.m.asterixapi.repository.CharacterRepo;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AsterixControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CharacterRepo characterRepo;

    @Test
    void getCharacters_shouldReturnListOfCharacters() throws Exception {
        characterRepo.saveAll(List.of(
                new Character("1", "Asterix", 35, "Krieger"),
                new Character("2", "Obelix", 35, "Lieferant"),
                new Character("3", "Miraculix", 60, "Druide"),
                new Character("4", "Majestix", 60, "Häuptling")
        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters?"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        [
                            {
                                "id": "1",
                                "name": "Asterix",
                                "age": 35,
                                "occupation": "Krieger"
                            },
                            {
                                "id": "2",
                                "name": "Obelix",
                                "age": 35,
                                "occupation": "Lieferant"
                            },
                            {
                                "id": "3",
                                "name": "Miraculix",
                                "age": 60,
                                "occupation": "Druide"
                            },
                            {
                                "id": "4",
                                "name": "Majestix",
                                "age": 60,
                                "occupation": "Häuptling"
                            }
                            ]"""));
    }

//    @Test
//    void getCharacterById() {
//    }
//
//    @Test
//    void createCharacter() {
//    }
//
//    @Test
//    void updateCharacter() {
//    }
//
//    @Test
//    void deleteCharacter() {
//    }
}