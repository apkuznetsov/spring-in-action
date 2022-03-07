package ssau.kuznetsov.tacocloud.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
public class OrderListener {

    private final KitchenUi ui;

    @Autowired
    public OrderListener(KitchenUi ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
