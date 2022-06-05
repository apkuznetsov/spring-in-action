package ssau.kuznetsov.tacocloudkitchen.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloud.models.Order;

@Profile("kafka-listener")
@Component
@Slf4j
public class KafkaOrderListener {

    private KitchenUI ui;

    @Autowired
    public KafkaOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order, ConsumerRecord<String, Order> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());

        ui.displayOrder(order);
    }

//
// Alternate implementation
//
//  @KafkaListener(topics="tacocloud.orders.topic")
//  public void handle(Order order, Message<Order> message) {
//    MessageHeaders headers = message.getHeaders();
//    log.info("Received from partition {} with timestamp {}",
//        headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
//        headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
//    ui.displayOrder(order);
//  }

}