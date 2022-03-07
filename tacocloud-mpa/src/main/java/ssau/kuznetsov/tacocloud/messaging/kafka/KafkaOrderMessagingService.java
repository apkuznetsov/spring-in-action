package ssau.kuznetsov.tacocloud.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ssau.kuznetsov.tacocloud.messaging.OrderMessagingService;
import ssau.kuznetsov.tacocloud.models.Order;

@Service
public class KafkaOrderMessagingService
        implements OrderMessagingService {

    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public KafkaOrderMessagingService(
            KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.sendDefault(order);
    }
}