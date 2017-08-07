package ua.ksa.FoodBooking.core.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by ksa on 06.08.17.
 */
public enum Roles implements GrantedAuthority {
    ADMINISTRATOR, USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
