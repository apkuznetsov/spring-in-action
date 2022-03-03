package ssau.kuznetsov.tacocloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssau.kuznetsov.tacocloud.models.Ingredient;
import ssau.kuznetsov.tacocloud.repositories.IngredientRepository;

@RestController
@RequestMapping(path = "/ingredientsx", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientRestController {

    private final IngredientRepository repo;

    @Autowired
    public IngredientRestController(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return repo.findAll();
    }

}