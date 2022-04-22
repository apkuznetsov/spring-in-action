package ssau.kuznetsov.tacocloudmessagingrabbitmq;

public interface OrderMessagingService {

    void sendOrder(Order order);

}