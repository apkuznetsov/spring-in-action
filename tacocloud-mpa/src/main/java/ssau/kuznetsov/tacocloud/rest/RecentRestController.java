package ssau.kuznetsov.tacocloud.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import ssau.kuznetsov.tacocloud.models.Taco;
import ssau.kuznetsov.tacocloud.repositories.TacoRepository;
import ssau.kuznetsov.tacocloud.represents.TacoResource;
import ssau.kuznetsov.tacocloud.util.TacoResourceAssembler;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class RecentRestController {

    private final TacoRepository tacoRepo;

    public RecentRestController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public Resources<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        List<TacoResource> tacoResources =
                new TacoResourceAssembler().toResources(tacos);

        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
        recentResources.add(
                linkTo(methodOn(DesignRestController.class)
                        .recentTacos())
                        .withRel("recents")
        );

        return recentResources;
    }
}