package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.FoodGroup;

/**
 * Created by ksa on 06.08.17.
 */
public interface FoodGroupRepository extends CrudRepository<FoodGroup, Long> {
}
