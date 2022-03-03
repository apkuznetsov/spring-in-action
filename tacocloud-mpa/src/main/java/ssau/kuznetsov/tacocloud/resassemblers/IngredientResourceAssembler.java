package ssau.kuznetsov.tacocloud.resassemblers;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ssau.kuznetsov.tacocloud.models.Ingredient;
import ssau.kuznetsov.tacocloud.represents.IngredientResource;
import ssau.kuznetsov.tacocloud.rest.IngredientRestController;

class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientRestController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateResource(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }
}
