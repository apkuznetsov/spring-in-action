package ssau.kuznetsov.tacocloudmessagingjms;

import ssau.kuznetsov.tacocloud.models.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}
