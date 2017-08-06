package ua.ksa.FoodBooking.core.model;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by ksa on 06.08.17.
 */
public class AuditorUserAwareImpl implements AuditorAware<User> {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getCurrentAuditor() {
        return user;
    }
}
