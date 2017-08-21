package ua.ksa.FoodBooking.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.ksa.FoodBooking.core.dao.UserRepository;

/**
 * Created by ksa on 07.08.17.
 */
@Component
@Scope
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    public UserDetailsServiceImpl() {
    }
    //    public UserDetailsServiceImpl(UserRepository repository) {
//        this.repository = repository;
//    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findUserByLogin(username);
        if (user == null) throw new UsernameNotFoundException("No user found with login=" + username);
        return user;
    }
}
