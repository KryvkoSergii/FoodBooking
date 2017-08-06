package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.Order;

import java.security.acl.LastOwnerException;

/**
 * Created by ksa on 06.08.17.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
