package ssau.kuznetsov.tacocloud.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
public class KafkaOrderListener {

    private final KitchenUi ui;

    @Autowired
    public KafkaOrderListener(KitchenUi ui) {
        this.ui = ui;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order) {
        ui.displayOrder(order);
    }
}