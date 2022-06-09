package ssau.kuznetsov.tacocloudkitchen.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloudkitchen.kitchen.KitchenUi;
import ssau.kuznetsov.tacocloudkitchen.models.Order;

@Profile("jms-listener")
@Component
public class JmsOrderListener {

    private KitchenUi ui;

    @Autowired
    public JmsOrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }

}
