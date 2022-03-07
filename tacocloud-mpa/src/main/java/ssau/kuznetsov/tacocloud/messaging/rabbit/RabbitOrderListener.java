package ssau.kuznetsov.tacocloud.messaging.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
public class RabbitOrderListener {

    private final KitchenUi ui;

    @Autowired
    public RabbitOrderListener(KitchenUi ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
