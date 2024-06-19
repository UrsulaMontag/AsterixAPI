package u.m.asterixapi.models;

import u.m.asterixapi.services.Utilservice;

public class ChangeModels {
    private static final Utilservice idService = new Utilservice();

    public static Character characterWithoutIdToCharacter(CharacterWithoutId character) {
        return new Character(idService.generateId(), character.name(), character.age(), character.occupation());
    }

}
