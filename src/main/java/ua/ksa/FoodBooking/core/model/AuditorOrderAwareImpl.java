package ua.ksa.FoodBooking.core.model;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by ksa on 06.08.17.
 */
public class AuditorOrderAwareImpl implements AuditorAware<Order> {
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getCurrentAuditor() {
        return order;
    }
}
