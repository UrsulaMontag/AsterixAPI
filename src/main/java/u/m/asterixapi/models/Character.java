package u.m.asterixapi.models;

import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("characters")
public record Character(
        @Id
        String id, String name, int age, String occupation) {
}
