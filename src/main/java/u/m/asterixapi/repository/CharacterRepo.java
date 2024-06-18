package u.m.asterixapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import u.m.asterixapi.models.Character;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {
}
