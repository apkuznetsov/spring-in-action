package ssau.kuznetsov.tacocloudkitchen.kitchen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloudkitchen.models.Order;

@Component
@Slf4j
public class KitchenUi {

    public void displayOrder(Order order) {
        log.info("RECEIVED ORDER:  " + order);
    }

}