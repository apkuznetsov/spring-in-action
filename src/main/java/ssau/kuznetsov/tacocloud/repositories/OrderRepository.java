package ssau.kuznetsov.tacocloud.repositories;

import ssau.kuznetsov.tacocloud.models.Order;

public interface OrderRepository {
    Order save(Order order);
}