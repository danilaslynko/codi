package ru.mtuci.codi.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.mtuci.codi.entity.user.User;
import ru.mtuci.codi.entity.user.UserService;

@Component
public class CodiUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CodiUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        return CodiUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
