package ssau.kuznetsov.tacocloud.email;

import lombok.Data;
import ssau.kuznetsov.tacocloud.models.Taco;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmailOrder {

    private final String email;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
