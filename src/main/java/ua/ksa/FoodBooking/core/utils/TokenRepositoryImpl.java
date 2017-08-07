package ua.ksa.FoodBooking.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;
import ua.ksa.FoodBooking.core.dao.PersistentTokenCacheRepository;
import ua.ksa.FoodBooking.core.model.PersistentToken;

import java.util.Date;

/**
 * Created by ksa on 08.08.17.
 */
@Component
@Scope
public class TokenRepositoryImpl implements PersistentTokenRepository {
    static final Logger logger = LoggerFactory.getLogger(TokenRepositoryImpl.class);
    @Autowired
    private PersistentTokenCacheRepository repository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("saved " + repository.save(PersistentToken.buildFromPersistentRememberMeToken(token)));
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        PersistentToken persistentToken = repository.findOne(series);
        persistentToken
                .tokenValue(tokenValue)
                .date(lastUsed.)
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return null;
    }

    @Override
    public void removeUserTokens(String username) {

    }
}
