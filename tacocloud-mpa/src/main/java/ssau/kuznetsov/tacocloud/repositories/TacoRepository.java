package ssau.kuznetsov.tacocloud.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ssau.kuznetsov.tacocloud.models.Taco;

public interface TacoRepository
        extends PagingAndSortingRepository<Taco, Long> {
}
