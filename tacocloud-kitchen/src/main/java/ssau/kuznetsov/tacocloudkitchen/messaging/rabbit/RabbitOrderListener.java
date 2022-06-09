package ssau.kuznetsov.tacocloudkitchen.messaging.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloudkitchen.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloudkitchen.models.Order;

@Profile("rabbitmq-listener")
@Component
public class RabbitOrderListener {

    private KitchenUI ui;

    @Autowired
    public RabbitOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }

}