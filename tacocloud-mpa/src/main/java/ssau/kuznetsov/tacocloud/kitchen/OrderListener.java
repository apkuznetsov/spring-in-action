package ssau.kuznetsov.tacocloud.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ssau.kuznetsov.tacocloud.models.Order;

@Component
public class OrderListener {

    private final KitchenUi ui;

    @Autowired
    public OrderListener(KitchenUi ui) {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
