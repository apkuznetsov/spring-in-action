package ssau.kuznetsov.tacocloudkitchen.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloudkitchen.kitchen.OrderReceiver;
import ssau.kuznetsov.tacocloudkitchen.models.Order;

@Profile("rabbitmq-template")
@Component("templateOrderReceiver")
public class RabbitOrderReceiver implements OrderReceiver {

    private RabbitTemplate rabbit;

    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public Order receiveOrder() {
        return (Order) rabbit.receiveAndConvert("tacocloud.order.queue");
    }

}