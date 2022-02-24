package ssau.kuznetsov.tacocloud.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ssau.kuznetsov.tacocloud.models.Order;
import ssau.kuznetsov.tacocloud.models.User;

import java.util.Date;
import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

}