package ssau.kuznetsov.tacocloud.messaging;

import ssau.kuznetsov.tacocloud.models.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}
