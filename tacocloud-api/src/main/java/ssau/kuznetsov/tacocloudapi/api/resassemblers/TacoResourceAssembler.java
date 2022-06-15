package ssau.kuznetsov.tacocloudapi.api.resassemblers;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ssau.kuznetsov.tacocloud.models.Taco;
import ssau.kuznetsov.tacocloudapi.api.controllers.DesignRestController;
import ssau.kuznetsov.tacocloudapi.api.resources.TacoResource;

public class TacoResourceAssembler
        extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignRestController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(), taco);
    }
}