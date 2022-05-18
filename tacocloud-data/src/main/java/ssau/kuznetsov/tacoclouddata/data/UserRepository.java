package ssau.kuznetsov.tacoclouddata.data;

import org.springframework.data.repository.CrudRepository;
import ssau.kuznetsov.tacocloud.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
