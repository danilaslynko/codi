package ru.mtuci.codi.conf;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mtuci.codi.entity.user.User;

import java.util.Collection;
import java.util.Collections;

public class CodiUserDetails implements UserDetails {
    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CodiUserDetails fromUserEntityToCustomUserDetails(User user) {
        CodiUserDetails c = new CodiUserDetails();
        c.login = user.getLogin();
        c.password = user.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRole()));
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
