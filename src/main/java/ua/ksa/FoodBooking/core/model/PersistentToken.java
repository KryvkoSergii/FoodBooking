package ua.ksa.FoodBooking.core.model;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by ksa on 08.08.17.
 */
@Entity
@Table(name = "PERSISTENT_TOKEN")
public class PersistentToken implements Serializable {
    @Id
    private String series;
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String username;
    @Column(name = "TOKEN", unique = true, nullable = false)
    private String tokenValue;
    @Column(name = "LAST_ACTIVITY")
    private LocalDateTime date;


    //Constructors
    public PersistentToken() {
    }


    //Getters and setters
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    //builder
    public static PersistentToken buildFromPersistentRememberMeToken(PersistentRememberMeToken token) {
        return new PersistentToken()
                .date(token.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .series(token.getSeries())
                .username(token.getUsername())
                .tokenValue(token.getTokenValue());
    }

    public PersistentToken series(String series) {
        this.series = series;
        return this;
    }

    public PersistentToken username(String username) {
        this.username = username;
        return this;
    }

    public PersistentToken tokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
        return this;
    }

    public PersistentToken date(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
