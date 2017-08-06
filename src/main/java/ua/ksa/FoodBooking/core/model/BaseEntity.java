package ua.ksa.FoodBooking.core.model;

import javax.persistence.*;

/**
 * Created by ksa on 06.08.17.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
