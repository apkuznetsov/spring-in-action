package ssau.kuznetsov.tacocloud.represents;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import ssau.kuznetsov.tacocloud.models.Ingredient;
import ssau.kuznetsov.tacocloud.models.Taco;

import java.util.Date;
import java.util.List;

public class TacoResource extends ResourceSupport {

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<Ingredient> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }
}