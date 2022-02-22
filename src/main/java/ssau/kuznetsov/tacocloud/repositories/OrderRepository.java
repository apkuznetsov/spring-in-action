package ssau.kuznetsov.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ssau.kuznetsov.tacocloud.models.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

}