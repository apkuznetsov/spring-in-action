package ssau.kuznetsov.tacocloud.util;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import ssau.kuznetsov.tacocloud.models.Taco;
import ssau.kuznetsov.tacocloud.represents.TacoResource;
import ssau.kuznetsov.tacocloud.rest.DesignRestController;

public class TacoResourceAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignRestController.class, TacoResource.class);
    }

    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }
}