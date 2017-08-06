package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.Food;

/**
 * Created by ksa on 06.08.17.
 */
public interface FoodRepository extends CrudRepository<Food, Long> {
}
