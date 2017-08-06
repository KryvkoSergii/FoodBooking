package ua.ksa.FoodBooking.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(name = "UK_USER", columnNames = {"LOGIN"}))
public class User extends BaseEntity {
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "LAST_NAME", nullable = false)
    private String lname;
    @Column(name = "FIRST_NAME", nullable = false)
    private String fname;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "UPDATED", nullable = false)
    private LocalDateTime lastModifiedDate;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Roles role;

    public User() {
    }

    public User(String login, String lname, String fname, String password, Roles role) {
        this.login = login;
        this.lname = lname;
        this.fname = fname;
        this.password = password;
        this.role = role;
    }
}
