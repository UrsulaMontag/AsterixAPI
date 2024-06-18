package u.m.asterixapi.models;

import u.m.asterixapi.services.IdService;

public class ChangeModels {
    private static final IdService idService = new IdService();

    public static Character characterWithoutIdToCharacter(CharacterWithoutId character) {
        return new Character(idService.generateId(), character.name(), character.age(), character.occupation());
    }

}
