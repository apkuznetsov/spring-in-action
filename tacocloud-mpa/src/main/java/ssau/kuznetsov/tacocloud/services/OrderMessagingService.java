package ssau.kuznetsov.tacocloud.services;

import ssau.kuznetsov.tacocloud.models.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}
