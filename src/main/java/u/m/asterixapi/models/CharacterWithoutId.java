package u.m.asterixapi.models;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("characters")
public record CharacterWithoutId(
        String name,
        int age,
        String occupation
) {
}
