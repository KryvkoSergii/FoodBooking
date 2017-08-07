package ua.ksa.FoodBooking.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ksa on 06.08.17.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(name = "UK_USER", columnNames = {"LOGIN"}))
public class User extends BaseEntity implements UserDetails {
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
    private Set<Roles> roles = new HashSet<>();

    public User() {
    }

    public User(String login, String lname, String fname, String password, Set<Roles> roles) {
        this.login = login;
        this.lname = lname;
        this.fname = fname;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
