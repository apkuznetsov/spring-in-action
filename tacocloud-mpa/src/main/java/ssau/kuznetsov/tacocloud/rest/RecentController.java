package ssau.kuznetsov.tacocloud.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import ssau.kuznetsov.tacocloud.models.Taco;
import ssau.kuznetsov.tacocloud.repositories.TacoRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class RecentController {

    private final TacoRepository tacoRepo;

    public RecentController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public CollectionModel<EntityModel<Taco>> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<EntityModel<Taco>> recentResources = CollectionModel.wrap(tacos);
        recentResources.add(
                linkTo(methodOn(DesignRestController.class).recentTacos())
                        .withRel("recents")
        );
        return recentResources;
    }

}