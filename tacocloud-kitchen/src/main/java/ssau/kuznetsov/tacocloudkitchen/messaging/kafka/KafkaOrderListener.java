package ssau.kuznetsov.tacocloudkitchen.messaging.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloudkitchen.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloudkitchen.models.Order;

@Profile("kafka-listener")
@Component
@Slf4j
public class KafkaOrderListener {

    private KitchenUi ui;

    @Autowired
    public KafkaOrderListener(KitchenUi ui) {
        this.ui = ui;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order, ConsumerRecord<String, Order> record) {

    }
}