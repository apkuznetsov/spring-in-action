package ssau.kuznetsov.tacocloud.messaging;

import ssau.kuznetsov.tacocloud.models.Order;

public interface OrderReceiver {

    Order receiveOrder();

}