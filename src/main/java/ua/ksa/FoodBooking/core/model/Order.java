package ua.ksa.FoodBooking.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@Table(name = "DAILY_ORDER")
public class Order extends BaseEntity {
    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "UPDATED", nullable = false)
    private LocalDateTime lastModifiedDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_ORDER_USER"))
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DAILY_MENU_ID", foreignKey = @ForeignKey(name = "FK_ORDER_DAILY_MENU"))
    private DailyMenu menu;
    @LastModifiedBy
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LAST_MODIFIED_BY_ID", foreignKey = @ForeignKey(name = "FK_ORDER_LAST_MOD_USER"))
    private User lastModifiedBy;


    public Order() {
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DailyMenu getMenu() {
        return menu;
    }

    public void setMenu(DailyMenu menu) {
        this.menu = menu;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
