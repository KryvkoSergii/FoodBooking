package ua.ksa.FoodBooking.core.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@Table(name = "FOOD_GROUP")
public class FoodGroup extends BaseEntity {
    @Column(name = "NAME", nullable = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.EAGER)
    private Set<Food> food;
    @JoinColumn(name = "DAILY_MENU_ID", foreignKey = @ForeignKey(name = "FK_FOOD_GROUP_DAILY_MENU"))
    @ManyToOne(fetch = FetchType.LAZY)
    private DailyMenu dailyMenu;

    public FoodGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FoodGroup{");
        sb.append("name='").append(name).append('\'');
        sb.append(", food=").append(food);
        sb.append(", dailyMenu=").append(dailyMenu);
        sb.append('}');
        return sb.toString();
    }
}
