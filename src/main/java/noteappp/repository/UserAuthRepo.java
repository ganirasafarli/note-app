package noteappp.repository;

import noteappp.entity.UserRegister;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserAuthRepo extends MongoRepository<UserRegister, String> {
    UserRegister findByUsername(String userName);

    @Query("{'username': ?0, 'password': ?1}")
    UserRegister findByUsernameAndPassword(String username, String password);
}
