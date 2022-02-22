package ssau.kuznetsov.tacocloud.repositories;

import ssau.kuznetsov.tacocloud.models.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
