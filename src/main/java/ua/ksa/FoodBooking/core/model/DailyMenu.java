package ua.ksa.FoodBooking.core.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@Table(name = "DAILY_MENU")
public class DailyMenu extends BaseEntity {
    @Column(name = "CURRENT_DATE", nullable = false)
    private long date;
    @Column(name = "UPDATED")
    private long updated;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "dailyMenu")
    private Set<FoodGroup> foodGroups;


    public DailyMenu() {
    }


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public Set<FoodGroup> getFoodGroups() {
        return foodGroups;
    }

    public void setFoodGroups(Set<FoodGroup> foodGroups) {
        this.foodGroups = foodGroups;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DailyMenu{");
        sb.append("date=").append(date);
        sb.append(", updated=").append(updated);
        sb.append(", foodGroups=").append(foodGroups);
        sb.append('}');
        return sb.toString();
    }
}
