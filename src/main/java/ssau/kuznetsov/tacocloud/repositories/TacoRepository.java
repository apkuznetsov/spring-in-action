package ssau.kuznetsov.tacocloud.repositories;

import ssau.kuznetsov.tacocloud.models.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
