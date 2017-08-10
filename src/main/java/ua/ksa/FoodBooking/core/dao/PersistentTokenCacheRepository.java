package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.ksa.FoodBooking.core.model.PersistentToken;

/**
 * Created by ksa on 08.08.17.
 */
public interface PersistentTokenCacheRepository extends CrudRepository<PersistentToken, String> {
    @Query("delete from PersistentToken pt  where pt.username=:username")
    void removeByName(@Param("username") String username);
}
