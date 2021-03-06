package ua.ksa.FoodBooking.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.ksa.FoodBooking.core.model.User;

/**
 * Created by ksa on 06.08.17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.login=:login")
    User findUserByLogin(@Param("login") String login);
}
