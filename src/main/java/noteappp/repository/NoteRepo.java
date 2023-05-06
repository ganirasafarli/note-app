package noteappp.repository;

import noteappp.entity.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepo extends MongoRepository<Notes, String> {
}
