package ssau.kuznetsov.tacocloud.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.messaging.OrderReceiver;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private final JmsTemplate jms;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
