package ssau.kuznetsov.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ssau.kuznetsov.tacocloud.models.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
