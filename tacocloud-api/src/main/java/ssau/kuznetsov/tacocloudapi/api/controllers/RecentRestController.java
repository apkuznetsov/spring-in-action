package ssau.kuznetsov.tacocloudapi.api.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ssau.kuznetsov.tacocloud.models.Taco;
import ssau.kuznetsov.tacocloud.repositories.TacoRepository;
import ssau.kuznetsov.tacocloud.represents.TacoResource;
import ssau.kuznetsov.tacocloud.resassemblers.TacoResourceAssembler;
import ssau.kuznetsov.tacocloudapi.api.resources.TacoResource;
import ssau.kuznetsov.tacocloudapi.api.resassemblers.TacoResourceAssembler;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class RecentRestController {

    private final TacoRepository tacoRepo;

    public RecentRestController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @Bean
    public ResourceProcessor<PagedResources<Resource<Taco>>>
    tacoProcessor(EntityLinks links) {
        return resource -> {
            resource.add(
                    links.linkFor(Taco.class)
                            .slash("recent")
                            .withRel("recents"));
            return resource;
        };
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<Resources<TacoResource>> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());

        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        List<TacoResource> tacoResources =
                new TacoResourceAssembler().toResources(tacos);

        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
        recentResources.add(
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(RecentRestController.class).recentTacos())
                        .withRel("recents")
        );

        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }
}