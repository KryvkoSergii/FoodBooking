package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.User;

/**
 * Created by ksa on 06.08.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
