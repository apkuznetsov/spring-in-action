package ssau.kuznetsov.tacoclouddata.data;

import org.springframework.data.repository.CrudRepository;
import ssau.kuznetsov.tacocloud.models.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
