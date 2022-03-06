package ssau.kuznetsov.tacocloud.kitchen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
@Slf4j
public class KitchenUi {

    public void displayOrder(Order order) {

        log.info("RECEIVED ORDER:  " + order);
    }

}