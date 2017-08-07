package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ksa.FoodBooking.core.model.PersistentToken;

/**
 * Created by ksa on 08.08.17.
 */
public interface PersistentTokenCacheRepository extends CrudRepository<PersistentToken, String> {
}
