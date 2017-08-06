package ua.ksa.FoodBooking.core.model;

import javax.persistence.*;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@Table(name = "FOOD")
public class Food extends BaseEntity {
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "PRICE", nullable = false)
    private Float price;
    @JoinColumn(name = "FOOD_GROUP_ID", foreignKey = @ForeignKey(name = "FK_FOOD_GROUP_FOOD"))
    @ManyToOne(fetch = FetchType.LAZY)
    private FoodGroup group;

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public FoodGroup getGroup() {
        return group;
    }

    public void setGroup(FoodGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Food{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", group=").append(group);
        sb.append('}');
        return sb.toString();
    }
}
