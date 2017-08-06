package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.DailyMenu;

/**
 * Created by ksa on 06.08.17.
 */
public interface DailyMenuRepository extends CrudRepository<DailyMenu, Long> {
}
